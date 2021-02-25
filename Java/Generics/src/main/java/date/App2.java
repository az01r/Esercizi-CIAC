/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 *
 * @author alfonso
 */
public class App2 {

    public static void main(String[] args) {
        
        LocalDateTime now = LocalDateTime.now();
        
        ZonedDateTime roma = ZonedDateTime.of(now, ZoneId.of("Europe/Rome"));
        
        ZonedDateTime ny = ZonedDateTime.of(now, ZoneId.of("America/New_York"));
        
        ZonedDateTime ny1 = roma.withZoneSameInstant( ZoneId.of("America/New_York"));
        
        System.out.println(roma);
        
        System.out.println(ny);
        
        System.out.println(ny1);
    }
}