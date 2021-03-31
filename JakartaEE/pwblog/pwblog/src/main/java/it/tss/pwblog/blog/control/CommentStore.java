/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.pwblog.blog.control;

import it.tss.pwblog.blog.entity.Comment;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author Paolo
 */
@RequestScoped
@Transactional(Transactional.TxType.REQUIRED)
public class CommentStore {

    @PersistenceContext
    private EntityManager em;

    @Inject
    @ConfigProperty(name = "maxResult", defaultValue = "10")
    int maxResult;

    private TypedQuery<Comment> searchQuery(boolean deleted, Long userId, Long articleId, Long commentId) {
        return em.createQuery("SELECT E FROM Comment E WHERE E.deleted :deleted AND E.userId :userId AND E.articleId :articleId AND E.id :commentId ORDER BY E.id ", Comment.class)
                .setParameter("deleted", deleted)
                .setParameter("userId", userId == null ? "%" : userId)
                .setParameter("articleId", articleId == null ? "%" : articleId)
                .setParameter("id", articleId == null ? "%" : commentId);
    }
    
    /**
     * cerca tutti i commenti
     * @return List<BlogUser>
     */
    public List<Comment> searchAll() {
        return searchQuery(false, null, null, null).getResultList();
    }
    
    /**
     * cerca tutti i commenti di un utente
     * @param start inserire un valore se si vuole ritorare i risultati a partire da un certo numero
     * @param maxResult numero massimo di risultati ritornati, se 0 ne ritorna un numero di deafault (10)
     * @param userId id dell'utente di cui si vogliono i commenti
     * @return List<Comment>
     */
    public List<Comment> searchByUser(int start, int maxResult, Long userId) {
        return searchQuery(false, userId, null, null)
                .setFirstResult(start)
                .setMaxResults(maxResult == 0 ? this.maxResult : maxResult)
                .getResultList();
    }
    
    /**
     * cerca tutti i commenti di un articolo
     * @param start inserire un valore se si vuole ritorare i risultati a partire da un certo numero
     * @param maxResult numero massimo di risultati ritornati, se 0 ne ritorna un numero di deafault (10)
     * @param articleId id dell'articolo di cui si vogliono i commenti
     * @return 
     */
    public List<Comment> searchByArticle(int start, int maxResult, Long articleId) {
        return searchQuery(false, null, articleId, null)
                .setFirstResult(start)
                .setMaxResults(maxResult == 0 ? this.maxResult : maxResult)
                .getResultList();
    }
    
    /**
     * cerca un singolo commento
     * @param commentId
     * @return Comment
     */
    public Comment searchSingleComment(Long commentId) {
        return searchQuery(false, null, null, commentId)
                .getSingleResult();
    }
    
    public void delete(Long id) {
        Comment found = em.find(Comment.class, id);
        found.setDeleted(true);
        em.merge(found);
    }
    
    public Comment create(Comment comment) {
        return em.merge(comment);
    }
}
