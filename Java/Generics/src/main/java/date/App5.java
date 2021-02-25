/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package date;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author alfonso
 */
public class App5 {
    public static void main(String[] args) {
        Date now = new Date();
        
        System.out.println(now);
        
        Calendar cal = new Calendar.Builder().setInstant(new Date()).build();
        
        System.out.println(cal);
        
        Date now1 = cal.getTime();
        
        System.out.println(now1);
        
        LocalDate now2 = now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        Date now3 = Date.from(now2.atStartOfDay(ZoneOffset.systemDefault()).toInstant());
    }
}