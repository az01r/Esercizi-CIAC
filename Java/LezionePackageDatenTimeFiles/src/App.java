import packageProva.myPackage; // package di prova 
import java.util.Scanner; // java.util is a package while Scanner is a class of the java.util package 

import java.time.LocalDate; // import the LocalDate class
import java.time.LocalTime; // import the LocalTime class
import java.time.LocalDateTime; // import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

import java.io.File;  // Import the File class

public class App {
    public static void main(String[] args) {
        /*
         * ------------------PACKAGES-------------------- 
         * 
         * A package in Java is used to group related classes. Packages are
         * divided into two categories: 
         *      Built-in Packages (packages from the Java API)
         *      User-defined Packages 
         * You can either import a single class (along with its
         * methods and attributes), or a whole package that contain all the classes that
         * belong to the specified package. 
         * To use a class or a package from the library, you need to use 
         * the import keyword: 
         *      import package.name.Class; //Import a single class 
         *      import package.name.*; // Import the whole package
         * NB * importa tutte le classi del package
         */

        Scanner lettore = new Scanner(System.in); // creo oggetto lettore, istanza di Scanner, classe di java.util
        System.out.println("Enter usarname");
        String userName = lettore.nextLine(); // uso il metodo nextLine di lettore, oggetto di tipo Scanner
        System.out.println("Usarname is: "+userName);

        /*
         * To create a package, use the package keyword:
         */

/*------------------------------------------------------------------------------------------------------------------------------------*/

        /* 
         * ----------------DATE AND TIME------------------ 
         * 
         * Java does not have a built-in Date class, 
         * but we can import the java.time package to work 
         * with the date and time API. 
         * LocalDate	Represents a date (year, month, day (yyyy-MM-dd))
         * LocalTime	Represents a time (hour, minute, second and nanoseconds (HH-mm-ss-ns))
         * LocalDateTime	Represents both a date and a time (yyyy-MM-dd-HH-mm-ss-ns)
         * DateTimeFormatter	Formatter for displaying and parsing date-time objects
         * 
         */

        LocalDate dataLocale = LocalDate.now(); // Create a date object
        System.out.println(dataLocale); // Display the current date

        LocalTime oraLocale = LocalTime.now();
        System.out.println(oraLocale);

        LocalDateTime dataOraLocale = LocalDateTime.now();
        System.out.println(dataOraLocale);

        System.out.println("Before formatting: " + dataOraLocale);
    
        /*
         * The "T" in the example above is used to separate 
         * the date from the time. You can use the 
         * DateTimeFormatter class with the ofPattern() method 
         * in the same package to format or parse date-time 
         * objects. The following example will remove both 
         * the "T" and nanoseconds from the date-time:
         */

        DateTimeFormatter form = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String dataFormattata = dataOraLocale.format(form);

        System.out.println("After formatting: " + dataFormattata);
    
/*------------------------------------------------------------------------------------------------------------------------------------*/

        /* 
         * ----------------DATE AND TIME------------------ 
         * 
         * The File class from the java.io package, allows us to work with files.
         * To use the File class, create an object of the class, 
         * and specify the filename or directory name:
         * 
         */
        
        File myFile = new File("filename.txt"); // Specify the filename

        /*
         * The File class has many useful methods for creating and getting information 
         * about files. For example: 
         * canRead()	Boolean	Tests whether the file is readable or not
         * canWrite()	Boolean	Tests whether the file is writable or not
         * createNewFile()	Boolean	Creates an empty file
         * delete()	Boolean	Deletes a file
         * exists()	Boolean	Tests whether the file exists
         * getName()	String	Returns the name of the file
         * getAbsolutePath()	String	Returns the absolute pathname of the file
         * length()	Long	Returns the size of the file in bytes
         * list()	String[]	Returns an array of the files in the directory
         * mkdir()	Boolean	Creates a directory
         */    
    
    } 

}
