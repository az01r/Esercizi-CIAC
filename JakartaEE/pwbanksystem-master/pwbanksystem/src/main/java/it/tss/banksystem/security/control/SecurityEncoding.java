
package it.tss.banksystem.security.control;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * classe con un solo metodo statico che crypta una stringa
 * @author alfonso
 */
public class SecurityEncoding {

    /**
     * crypta una stringa
     * @param value
     * @return 
     */
    public static String shaHash(String value) {
        try {
            MessageDigest m = null;
            m = MessageDigest.getInstance("SHA-256");
            byte[] hash = m.digest(value.getBytes("UTF-8"));
            byte[] encodedhash = Base64.getEncoder().encode(hash);
            return new String(encodedhash);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            throw new IllegalArgumentException("Impossibile codificare in SHA-256", ex);
        }
    }
}
