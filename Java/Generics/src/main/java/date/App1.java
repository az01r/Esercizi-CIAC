/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 *
 * @author alfonso
 */
public class App1 {
    public static void main(String[] args) {
        LocalDate oggi = LocalDate.now();
        
        LocalDate d1 = LocalDate.of(2020, Month.APRIL, 21);
        
        LocalDate d2 = LocalDate.parse("20/12/2020", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        LocalDate d3 = LocalDate.parse("2020-12-20");
        
        System.out.println(oggi);
        
        System.out.println(d1);
        
        System.out.println(d2);
        
        System.out.println(d3);
        
        System.out.println(d1.isAfter(oggi));
        
        LocalDateTime adesso = LocalDateTime.now();
        
        System.out.println(adesso);
        
        System.out.println(oggi.plusDays(7));
        
        System.out.println(oggi.plus(30, ChronoUnit.YEARS));
        
        System.out.println(d3);
        System.out.println(oggi);
        
        Period periodo = Period.between(d3, oggi);
        System.out.println(periodo.toString());
        
        System.out.println(ChronoUnit.DAYS.between(d3, oggi));
        
        
    }
}