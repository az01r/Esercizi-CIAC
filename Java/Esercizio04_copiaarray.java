public class Esercizio04_copiaarray {
    public static void main(String[] args) {
        int[] array = {0,7,2,3,4};
        int[] copia= new int[array.length];
        int[] fintacopia= array;
        for(int i= 0; i<array.length;i++){
            copia[i]=array[i];
        }

        System.out.println("Indirizzo array "+array);
        System.out.println("Indirizzo copia "+copia);
        System.out.println("Indirizzo fintacopia "+fintacopia);
        
        System.out.println("Contenuto array");
        stampavettore(array);
        System.out.println("Contenuto copia");
        stampavettore(copia);
        
    }

    static void stampavettore(int[] vettore){
        for(int i=0;i<vettore.length;i++){
            System.out.println(vettore[i]+" ");
        }
    }
}
