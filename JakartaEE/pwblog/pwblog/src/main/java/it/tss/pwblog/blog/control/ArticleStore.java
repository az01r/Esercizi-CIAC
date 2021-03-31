/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.pwblog.blog.control;

import it.tss.pwblog.blog.entity.Article;
import java.util.List;
import java.util.Optional;
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
public class ArticleStore {
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    @ConfigProperty(name = "maxResult", defaultValue = "10")
    int maxResult;
    
    public Optional<Article> find(Long id) {
        Article found = em.find(Article.class, id);
        return found == null ? Optional.empty() : Optional.of(found);
    }
    
    private TypedQuery<Article> searchAllQuery() {
        return em.createQuery("select e from Article order by e.createdOn DESC ", Article.class);
    }

    public List<Article> searchAll() {
        return searchAllQuery().getResultList();
    }
    
    public Article create(Article article) {
        return em.merge(article);
    }
}
