/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 *
 * @author alfonso
 */
public class App4 {

    public static void main(String[] args) {
        DateTimeFormatter f1 = DateTimeFormatter.ISO_LOCAL_DATE;
        LocalDate d1 = LocalDate.now();
        System.out.println(d1.format(f1));

        // Creazione formatter, parsing e formattazione mediante pattern
        DateTimeFormatter f2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        d1 = LocalDate.parse("24/06/2014", f2);
        System.out.println(d1.format(f2));

        DateTimeFormatter f = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        LocalDate d2 = LocalDate.now();
        System.out.println(d2.format(f));
    }
}
