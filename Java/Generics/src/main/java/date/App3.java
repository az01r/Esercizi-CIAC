/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package date;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author alfonso
 */
public class App3 {

    public static void main(String[] args) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

// Partenza da San Francisco il 20 luglio 2014, alle 19:30
        LocalDateTime leaving = LocalDateTime.of(2014, Month.JULY, 20, 19, 30);
        ZoneId leavingZone = ZoneId.of("America/Los_Angeles");
        ZonedDateTime departure = ZonedDateTime.of(leaving, leavingZone);

        try {
            String out1 = departure.format(format);
            System.out.printf("PARTENZA: %s (%s)%n", out1, leavingZone);

        } catch (DateTimeException exc) {
            System.out.printf("%s can't be formatted!%n", departure);
            throw exc;
        }

// Il volo dura 15 ore e 45 minuti, quindi 945 minuti
        ZoneId arrivingZone = ZoneId.of("Europe/Rome");
        ZonedDateTime arrival = departure.withZoneSameInstant(arrivingZone)
                .plusMinutes(945);

        try {
            String out2 = arrival.format(format);
            System.out.printf("ARRIVO: %s (%s)%n", out2, arrivingZone);
        } catch (DateTimeException exc) {
            System.out.printf("%s can't be formatted!%n", arrival);
            throw exc;
        }

// Informazioni circa l'ora legale
        if (arrivingZone.getRules().isDaylightSavings(arrival.toInstant())) {
            System.out.printf(" (a %s è attiva l'ora legale)%n",
                    arrivingZone);
        } else {
            System.out.printf(" ( a %s è attiva l'ora solare standard)%n",
                    arrivingZone);
        }
    }
}