/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.bankSystem.entity;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 *
 * @author Paolo
 */
/* 
tutto quello che viene scritto viene riportato in tutte le tabelle che 
estendono questa classe 
*/
@MappedSuperclass  
public abstract class AbstractEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    
    @Column(name = "created_on")
    protected LocalDateTime createdOn;
    
    @Column(name = "modified_on")
    protected LocalDateTime modifiedOn;
    
    @ManyToOne
    @JoinColumn(name = "created_by_id") //self join
    protected User createdBy;
    
    @ManyToOne
    @JoinColumn(name = "modified_by_id")
    protected User modifiedBy;
    
    /*
    Tramite il campo version JPA avverte se quando si sta modificando un record
    qualcun'altro ha modificato il record prima che io lo abbia modificato 
    Evita quindi le modifiche concorrenti
    */
    @Version
    protected Long version;
    
    /*
    get/set
    */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(LocalDateTime modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(User modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    /*
    hashCode/equals id
    */
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractEntity other = (AbstractEntity) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
