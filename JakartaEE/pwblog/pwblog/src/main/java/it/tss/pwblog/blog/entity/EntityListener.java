/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.pwblog.blog.entity;

import it.tss.pwblog.blog.control.BlogUserStore;
import java.time.LocalDateTime;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import org.eclipse.microprofile.jwt.JsonWebToken;

/**
 *
 * @author Paolo
 */
public class EntityListener {
    
    @Inject
    BlogUserStore userStore;

    @Inject
    JsonWebToken jwt;

    @PostConstruct
    public void init() {
        System.out.println("init entity listener..");
    }

    @PrePersist // prima che venga l'oggetto creato
    public void onPrePersist(AbstractEntity e) {
        if (jwt != null && jwt.getSubject()!=null) {
            e.setCreatedBy(userStore.search(0,Long.parseLong(jwt.getSubject())).get());
        }
        e.setCreatedOn(LocalDateTime.now());
    }

    @PreUpdate // prima che venga l'oggetto aggiornato
    public void onPreUpdate(AbstractEntity e) {
        if (jwt != null && jwt.getSubject()!=null) {
            e.setModifiedBy(userStore.search(0,Long.parseLong(jwt.getSubject())).get());
        }
        e.setModifiedOn(LocalDateTime.now());
    }
}
