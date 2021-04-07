/*
 * E' comodo rispondere alle chiamate dei servizi rest usando le classi stesse. 
 * Bisogna però gestire i dati che non vogliamo che vengano restituiti al client.
 * 3 modi:
 * - ritornare direttamente le Entity, usando 2 tipi di annotazioni: 
 *   per JPA e Jsonb per definire cosa restituire;
 *      es: @JsonbTransient non fa ritornare la proprietà
 * - restituire un json appositamente costruito da noi
 * NB problema: devo però definire io la documentazione mentre usando le annotazioni 
 *              Swagger analizza e interpreta autonomamente la classe java
 * - creare classi apposite con solo gli attributi che voglio restituire e usare
 *   queste per rispondere alle chiamate dei servizi. In questo modo la Swagger 
 *   crea la documentazione autonomamente senza dover usare due tipi di annotazioni
 * 
 * In questo progetto abbiamo scelto quest'ultima strada
 * Link per interfaccia openapi dell'app:
 * http://localhost:8080/resources/openapi-ui
 */
package it.tss.pwblog.blog.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
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

    @Column(name = "created_on")
    protected LocalDateTime createdOn;

    @Column(name = "modified_on")
    protected LocalDateTime modifiedOn;

    @Column(name = "created_by_id")
    protected Long createdById;

    @Column(name = "modified_by_id")
    protected Long modifiedById;

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

    public Long getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Long createdById) {
        this.createdById = createdById;
    }

    public Long getModifiedById() {
        return modifiedById;
    }

    public void setModifiedById(Long modifiedById) {
        this.modifiedById = modifiedById;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}
