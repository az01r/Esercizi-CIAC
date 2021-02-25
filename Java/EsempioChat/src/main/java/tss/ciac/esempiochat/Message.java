/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.esempiochat;
import java.time.LocalDateTime;

/**
 *
 * @author tss
 */
public class Message {
    private String fromUser;
    private String toUser;
    private String messageUser;
    private LocalDateTime dataInvio;

    public Message(String fromUser, String toUser, String messageUser) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.messageUser = messageUser;
        this.dataInvio = LocalDateTime.now(); // setta la data di sistema
    }

    
    
    public String getFromUser() {
        return fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public LocalDateTime getDataInvio() {
        return dataInvio;
    }
    
}
