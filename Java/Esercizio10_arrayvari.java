import org.graalvm.compiler.nodes.calc.RightShiftNode;

/* 
    esercizi:
    cercare carattere dentro array
    dire se un array è contenuto in un altro
    ritorna posizione carattere all'interno di un array
    dati 2 array sommarne i valori di indice uguale

*/
public class Esercizio10_arrayvari {
    public static void main(String[] args) {
        int[] array1 = { 0, 1, 2, 3, 4 };
        int[] array2 = { 2, 3 };
        int x = 3;
        int maxl;
        if (array1.length > array2.length) {
            maxl = array1.length;
        } else {
            maxl = array2.length;
        }
        int[] somma = new int[maxl];

        cercaNumero(array1, x);
        cercaArray(array1, array2);
        posizioneNumero(array1, x);
        sommaArray(array1, array2, somma);
        stampaArray(somma);
    }

    static boolean cercaNumero(int[] array, int a) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == a) {
                System.out.println("Il numero " + a + " è contenuto nell'array");
                return true;
            }
        }
        System.out.println("Il numero " + a + " non è contenuto nell'array");
        return false;
    }

    static boolean cercaArray(int[] array1, int[] array2) {
        int i = 0; // puntatore posizione attuale array1
        int j = 0; // puntatore posizione attuale array2
        int k = 0; // puntatore posizione a cui array1 torna se !=
        while (j < array2.length && i < array1.length && k < array1.length) {
            if (array1[i] == array2[j]) {
                if (j == array2.length - 1) { // array2.length -1 perchè i puntatori partono da 0
                    System.out.println("L'array2 è contenuto nell'array1");
                    return true;
                }
                i++;
                j++;
            } else {
                j = 0;
                k++;
                i = k;
            }
        }
        System.out.println("L'array2 non è contenuto nell'array1");
        return false;
    }

    static void posizioneNumero(int[] array, int a) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == a) {
                System.out.println("Numero trovato in posizione " + i);
            }
        }
    }

    static void sommaArray(int[] array1, int[] array2, int[] ris) {
        if (array1.length > array2.length) {
            for (int i = 0; i < array2.length; i++) {
                ris[i] = array1[i] + array2[i];
            }
            for(int i=array2.length;i<array1.length;i++){
                ris[i]=array1[i];
            }
        } else {
            for (int i = 0; i < array1.length; i++) {
                ris[i] = array1[i] + array2[i];
            }
            for(int i=array1.length;i<array2.length;i++){
                ris[i]=array2[i];
            }
        }
    }
    
    static void stampaArray (int[] array){
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}
