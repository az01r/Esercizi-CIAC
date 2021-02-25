public class Esercizio09_confrontoArray {
    public static void main(String[] args) {
        /* PASSARE UN NUMERO NON DEEFINITO DI PARAMETRI */
        int a = 5;
        int b = 3;
        int c = 4;
        int somma = sommaValoriArray(a, b, c);
        System.out.println("la somma è: " + somma);

        int[] array1 = { 0, 1, 2, 3 };
        int[] array2 = { 0, 1, 2, 3 };
        if (confronta(array1, array2)) {
            System.out.println("uguali");
        } else {
            System.out.println("diversi");
        }
    }

    static int sommaValoriArray(int... valori) {
        int somma = 0;
        for (int i = 0; i < valori.length; i++) {
            somma = somma + valori[i];
        }
        return somma;
    }

    /**
     * uguaglianza array1 e array2
     * 
     * @param arr1
     * @param arr2
     * @return true se uguali false se diversi
     */
    static boolean confronta(int[] arr1, int[] arr2) {
        if (arr1 == null|| arr2==null){
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;

    }
}

