/*
 * E' comodo rispondere alle chiamate dei servizi rest usando le classi stesse. 
 * Bisogna però gestire i dati che non vogliamo che vengano restituiti al client.
 * 3 modi:
 * - ritornare direttamente le Entity, usando 2 tipi di annotazioni: 
 *   per JPA e per Openapi per definire cosa restituire;
 * - restituire un json appositamente costruito da noi
 * NB problema: devo però definire io la documentazione mentre usando le annotazioni 
 *              Swagger analizza e interpreta autonomamente la classe java
 * - creare classi apposite con solo gli attributi che voglio restituire e usare
 *   queste per rispondere alle chiamate dei servizi. In questo modo la Swagger 
 *   crea la documentazione autonomamente senza dover usare due tipi di annotazioni
 * 
 * In questo progetto abbiamo scelto quest'ultima strada
 */
package it.tss.banksystem.bank.entity;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
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

/**
 * Classe astratta e relative annotazioni di JPA
 */
@MappedSuperclass
@EntityListeners({EntityListener.class})
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "created_on")
    protected LocalDateTime createdOn;

    @Column(name = "modified_on")
    protected LocalDateTime modifiedOn;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    protected User createdBy;

    @ManyToOne
    @JoinColumn(name = "modified_by_id")
    protected User modifiedBy;

    /*
    JPA aggiorna il campo version autonomamente, in questo modo avverte se 
    quando si sta modificando un record qualcun'altro ha modificato il 
    record prima che io lo abbia modificato 
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        return Objects.equals(this.id, other.id);
    }

}
