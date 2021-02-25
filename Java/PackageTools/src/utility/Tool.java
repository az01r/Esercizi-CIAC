package utility;

import java.util.Date;
import java.util.Scanner;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class Tool {
    private Tool() {

    }

    public static float getInt() {
        int x = 0;
        boolean errore;
        do {
            Scanner lettore = new Scanner(System.in);
            try {
                x = lettore.nextInt();
                errore = false;
            } catch (Exception e) {
                errore = true;
                System.out.println("errore, riprovare");
            }
        } while (errore);
        return x;
    }

    public static float getFloat() {
        float x = 0;
        boolean errore;
        do {
            Scanner lettore = new Scanner(System.in);
            try {
                x = lettore.nextFloat();
                errore = false;
            } catch (Exception e) {
                errore = true;
                System.out.println("errore, riprovare");
            }
        } while (errore);
        return x;
    }

    public static Double getDouble() {
        Double x = 0.0;
        boolean errore;
        do {
            Scanner lettore = new Scanner(System.in);
            try {
                x = lettore.nextDouble();
                errore = false;
            } catch (Exception e) {
                errore = true;
                System.out.println("errore, riprovare");
            }
        } while (errore);
        return x;
    }

    public static String getString() {
        String txt = "";
        boolean errore;
        do {
            Scanner lettore = new Scanner(System.in);
            txt = lettore.nextLine();
            if (txt.length() != 0) {
                errore = false;
            } else {
                errore = true;
                System.out.println("errore, stringa vuota");
            }
        } while (errore);
        return txt;
    }

    public static Date getDate() {
        int date = 0;
        int month = 0;
        int year = 0;
        boolean errore;
        do {
            Scanner lettore = new Scanner(System.in);
            try {
                System.out.println("inserire giorno");
                date = lettore.nextInt();
                errore = false;
            } catch (Exception e) {
                errore = true;
                System.out.println("errore, riprovare");
            }
        } while (errore);

        do {
            Scanner lettore = new Scanner(System.in);
            try {

                System.out.println("inserire mese");
                month = lettore.nextInt();

                errore = false;
            } catch (Exception e) {
                errore = true;
                System.out.println("errore, riprovare");
            }
        } while (errore);

        do {
            try {
                Scanner lettore = new Scanner(System.in);
                System.out.println("inserire anno");
                year = lettore.nextInt();
                errore = false;
            } catch (Exception e) {
                errore = true;
                System.out.println("errore, riprovare");
            }
        } while (errore);
        return new Date(year, month, date);
    }

    public static boolean checkChar(String s){
        boolean ris=true;
        for(int i=0;i<s.length();i++){
            if(!(s.charAt(i)>=65 && s.charAt(i)<=90)){
                ris=false;
            }
        }
        return ris;
    }

    /*
     * check codice fiscale leggi string req va tagliato in 6 pezzi si usa substring
     * delle String s2="63" ma se s2= "gh" int aa = Integer.parseInt(s2); valutare
     * eventuale errore se errore check fallato es metodo: boolean
     * checkCodFiscale(String strcod){ }
     */

    public static boolean checkCodFiscale(String cFisc) {
        boolean check = true;
        String s0, s1, s2, s3, s4, s5, s6;
        cFisc=cFisc.toUpperCase();
        if (cFisc.length() != 16) {
            check = false;
            return check;
        }

        s1 = cFisc.substring(0, 6);
        if(checkChar(s1)==false){
            check=false;
            return check;
        }
        
        s2 = cFisc.substring(6, 8);
        try {
            int num = Integer.parseInt(s2);
        } catch (Exception e) {
            check = false;
        }
        s3 = cFisc.substring(8, 9);
        if(checkChar(s3)==false||s3.charAt(0)>=84){ // da A a T oovero da 65 a 84 in ascii dec
            check=false;
            return check;
        }
        s4 = cFisc.substring(9, 11);
        try {
            int num = Integer.parseInt(s4);
            if(num>71){ // se donna oovero +40 nata il 31 del mese
                check=false;
                return check;
            }
        } catch (Exception e) {
            check = false;
        }
        s5 = cFisc.substring(11, 12);
        if(checkChar(s5)==false){
            check=false;
            return check;
        }
        s6 = cFisc.substring(12, 15);
        try {
            int num = Integer.parseInt(s6);
        } catch (Exception e) {
            check = false;
        }
        String cod=s6+s6;
        String dati= leggiFile();
        if(dati.indexOf(cod)>0 ==false){
            check = false;
            return check;
        }
        return check;
    }

    public static String leggiFile(){
        String data="";
        try {
            File myObj = new File("istat_ok.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              data += myReader.nextLine()+"|";
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("errore lettura file");
            e.printStackTrace();
          }
        return data;
    }

    
    private static void creaElencoComuni(String dati){
        
        String[] elComuni=dati.split("|");
        for(int i = 0; i<elComuni.length;i++){
            String[] arComune = elComuni[0].split(";");
            String comune = arComune[0];
            String provincia = arComune[1];
            String codice= arComune[2];
            Comune objComune = new Comune(comune,provincia,codice);
        
        }
    }



}
