/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.pwblog.blog.control;


import it.tss.pwblog.blog.boundary.dto.BlogUserUpdate;
import it.tss.pwblog.blog.entity.BlogUser;
import it.tss.pwblog.security.control.SecurityEncoding;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author alfonso
 */

/* 
obbligatorio iniziare e terminare la transazione -> se qualcosa va storto 
non fa l'intero create
 */
@RequestScoped
@Transactional(Transactional.TxType.REQUIRED)
public class BlogUserStore {

    private System.Logger LOG = System.getLogger(BlogUserStore.class.getName());
    
    @PersistenceContext //chiedo a JPA di creare un'istanza di EntityManager
    private EntityManager em;
    
    private List<BlogUser> searchQuery(boolean banned, String email, Long id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BlogUser> query = cb.createQuery(BlogUser.class);
        Root<BlogUser> root = query.from(BlogUser.class);
        query.select(root).where(searchPredicate(cb, root, banned, email, id));
        return em.createQuery(query)
                .getResultList();
    }
    
    public Predicate searchPredicate(CriteriaBuilder cb, Root<BlogUser> root, boolean banned, String email, Long id) {
        Predicate result = cb.conjunction();
        result = cb.and(result, cb.equal(root.get("banned"), banned));
        if (email != null) {
            result = cb.and(result, cb.equal(root.get("email"), email));
        }
        if (id != null) {
            result = cb.and(result, cb.equal(root.get("id"), id));
        }
        return result;
    }
    
    /**
     * cerca tutti gli utenti
     * @return List<BlogUser>
     */
    public List<BlogUser> findAllUsers() {
        return searchQuery(false, null, null);
    }
    
    /**
     * cerca utenti
     * @param start inserire un valore se si vuole ritorare i risultati a partire da un certo numero
     * @param maxResult numero massimo di risultati ritornati
     * @param email email dell'utente da cercare
     * @return List<BlogUser>
     */
    public List<BlogUser> findUserByEmail(String email) {
        return searchQuery(false, email, null);
    }
    
    /**
     * cerca utenti
     * @param id id dell'utente da cercare
     * @return Optional<BlogUser>
     */
    public Optional<BlogUser> findUserById(Long id) {
        LOG.log(System.Logger.Level.INFO, "search user " + id);
        BlogUser found = em.find(BlogUser.class, id); //EntityManager ha un metodo find che cerca un'entity dando una classe e la chiave primaria
        return found == null ? Optional.empty() : Optional.of(found);
    }
    
    public Optional<BlogUser> findUserByEmailAndPwd(String email, String pwd) {
        try {
            BlogUser found = em.createNamedQuery(BlogUser.LOGIN, BlogUser.class)
                    .setParameter("email", email)
                    .setParameter("pwd", SecurityEncoding.shaHash(pwd))
                    .getSingleResult();
            return Optional.of(found);
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }
    
    public BlogUser createUsr(BlogUser u) {
        u.setPwd(SecurityEncoding.shaHash(u.getPwd())); // prima di salvare l'utente nel db crypto la pwd
        BlogUser saved = em.merge(u);
        return saved;
    }

    public BlogUser updateUsr(BlogUser user, BlogUserUpdate u) {
        user.setFname(u);
        user.setLname(u);
        user.setEmail(u);
        user.setPwd(SecurityEncoding.shaHash(u.pwd)); // prima di salvare l'utente nel db crypto la pwd       
        user.setRole(u);
        user.setBanned(u);
        return em.merge(user);
    }

    public void banUsr(Long id) {
        BlogUser found = em.find(BlogUser.class, id);
        found.setBanned(true);
        em.merge(found);
    }

    
}
