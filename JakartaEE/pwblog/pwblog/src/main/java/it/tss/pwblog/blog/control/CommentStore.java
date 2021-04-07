/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.pwblog.blog.control;

import it.tss.pwblog.blog.entity.Comment;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

/**
 *
 * @author Paolo
 */
@RequestScoped
@Transactional(Transactional.TxType.REQUIRED)
public class CommentStore {

    @PersistenceContext
    private EntityManager em;

    /*
    private TypedQuery<Comment> searchQuery(boolean deleted, Long createdById, Long articleId, Long commentId, Long answersTo, LocalDate ffrom, LocalDate tto) {
         
            return em.createQuery("SELECT E FROM Comment E WHERE E.deleted = :deleted AND E.createdById = :createdById AND E.articleId= :articleId "
                + "AND E.id= :commentId AND E.answersTo= :answersTo AND E.createdOn >= :ffrom AND E.createdOn <= :tto ORDER BY E.id ", Comment.class)
                .setParameter("deleted", deleted)
                .setParameter("createdById", createdById == null ? "%" : createdById)
                .setParameter("articleId", articleId == null ? "%" : articleId) // % solo su string
                .setParameter("id", commentId == null ? "%" : commentId)
                .setParameter("answersTo", answersTo == null ? "%" : answersTo)
                .setParameter("ffrom", ffrom == null ? "%" : ffrom)
                .setParameter("tto", tto == null ? "%" : tto);
        
    }
     */
    private List<Comment> searchQuery(boolean deleted, Long createdById, Long articleId, Long commentId, Long answersTo, LocalDate ffrom, LocalDate tto) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Comment> query = cb.createQuery(Comment.class);
        Root<Comment> root = query.from(Comment.class);
        query.select(root).where(searchPredicate(cb, root, deleted, createdById, articleId, commentId, answersTo, ffrom, tto));
        return em.createQuery(query)
                .getResultList();

    }

    public Predicate searchPredicate(CriteriaBuilder cb, Root<Comment> root, boolean deleted, Long createdById, Long articleId, Long commentId, Long answersTo, LocalDate ffrom, LocalDate tto) {
        Predicate result = cb.conjunction();
        result = cb.and(cb.equal(root.get("deleted"), deleted));
        if (createdById != null) {

            result = cb.and(result, cb.equal(root.get("createdById"), createdById));
        }
        if (articleId != null) {
            result = cb.and(result, cb.equal(root.get("articleId"), articleId));
        }
        if (commentId != null) {
            result = cb.and(result, cb.equal(root.get("id"), commentId));
        }
        if (answersTo != null) {
            result = cb.and(result, cb.equal(root.get("answersTo"), answersTo));
        }
        if (ffrom != null && tto != null) {
            result = cb.and(result, cb.greaterThanOrEqualTo(root.get("createdOn"), ffrom), cb.lessThanOrEqualTo(root.get("createdOn"), tto));
        }
        return result;
    }

    /**
     * cerca tutti i commenti
     *
     * @return List<BlogUser>
     */
    public Optional<List<Comment>> findAllComments() {
        List found = searchQuery(false, null, null, null, null, null, null);
        return found.isEmpty() ? Optional.empty() : Optional.of(found);
    }

    /**
     * cerca tutti i commenti di un utente
     *
     * @param userId id dell'utente di cui si vogliono i commenti
     * @return List<Comment>
     */
    public Optional<List<Comment>> findCommentsByUser(Long userId) {
        List found = searchQuery(false, userId, null, null, null, null, null);
        return found.isEmpty() ? Optional.empty() : Optional.of(found);
    }

    /**
     * cerca tutti i commenti di un articolo
     *
     * @param articleId id dell'articolo di cui si vogliono i commenti
     * @return
     */
    public Optional<List<Comment>> findCommentsByArticle(Long articleId) {
        List found = searchQuery(false, null, articleId, null, null, null, null);
        return found.isEmpty() ? Optional.empty() : Optional.of(found);
    }

    /**
     * cerca un singolo commento
     *
     * @param commentId
     * @return Comment
     */
    public Optional<Comment> findCommentById(Long commentId) {
        Comment found = searchQuery(false, null, null, commentId, null, null, null).get(0);
        return found == null ? Optional.empty() : Optional.of(found);
    }

    /**
     * cerca i commenti che rispondono a un determinato commento
     *
     * @param answerTo
     * @return
     */
    public Optional<List<Comment>> findResponsesToComment(Long answerTo) {
        List found = searchQuery(false, null, null, null, answerTo, null, null);
        return found.isEmpty() ? Optional.empty() : Optional.of(found);
    }

    public void deleteComm(Long id) {
        Comment found = em.find(Comment.class, id);
        found.setDeleted(true);
        em.merge(found);
    }

    public Comment createComm(Comment comment) {
        return em.merge(comment);
    }

    public Optional<List<Comment>> findCommentsByPeriod(LocalDate from, LocalDate to) {
        List found = searchQuery(false, null, null, null, null, from, to);
        return found.isEmpty() ? Optional.empty() : Optional.of(found);
    }
}
