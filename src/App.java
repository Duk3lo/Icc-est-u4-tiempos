import java.util.Arrays;
import java.util.concurrent.Callable;

import controllers.SortMethods;
import models.Results;

public class App {
    public static void main(String[] args) {
        /*
         * long inicio = System.nanoTime();
         * for (int i = 0; i < 100000; i++) {
         * String s = "Numero: " + i;
         * System.out.println(s);
         * }
         * 
         * long fin = System.nanoTime();
         * 
         * long tiempoNano = fin - inicio;
         * double tiempoSeg = tiempoNano / 1_000_000_000.0;
         * System.out.println("Tiempo transcurrido: " + tiempoNano + " nanos");
         * System.out.println("Tiempo transcurrido: " + tiempoSeg + " segundos");
         * 
         * Results result = new Results(1, "Imprimir 100000 numeros", (int) tiempoSeg);
         * 
         * System.out.println(result.toString());
         */

        int[] originalArray = generate(500000);

        int[] array1000 = new int[1000];
        System.arraycopy(originalArray, 0, array1000, 0, 1000);

        int[] array5000 = new int[5000];
        System.arraycopy(originalArray, 0, array5000, 0, 5000);

        int[] array10000 = new int[10000];
        System.arraycopy(originalArray, 0, array10000, 0, 10000);

        int[] array50000 = new int[50000];
        System.arraycopy(originalArray, 0, array50000, 0, 50000);

        int[] array250000 = new int[250000];
        System.arraycopy(originalArray, 0, array250000, 0, 250000);

        int[][] arrays = { array1000, array5000, array10000, array50000, array250000, originalArray };

        SortMethods sorter = new SortMethods();

        for (int[] array : arrays) {
            int size = array.length;
            System.out.println("\n--- Tamaño: " + size + " ---");

            // ==============================
            // Bubble
            // ==============================
            Callable<Void> bubbleCall = () -> {
                int[] toSort = Arrays.copyOf(array, array.length);
                sorter.sortBubble(toSort);
                return null;
            };
            Results rBubble = Benchmark.medir_tiempo(bubbleCall, size);
            System.out.println("Bubble: " + rBubble);

            // ==============================
            // Bubble Optimizado
            // ==============================
            Callable<Void> bubbleOptCall = () -> {
                int[] toSort = Arrays.copyOf(array, array.length);
                sorter.burbble(toSort);
                return null;
            };
            Results rBubbleOpt = Benchmark.medir_tiempo(bubbleOptCall, size);
            System.out.println("Bubble Optimizado: " + rBubbleOpt);

            // ==============================
            // Shell
            // ==============================
            Callable<Void> shellCall = () -> {
                int[] toSort = Arrays.copyOf(array, array.length);
                sorter.shell(toSort);
                return null;
            };
            Results rShell = Benchmark.medir_tiempo(shellCall, size);
            System.out.println("Shell: " + rShell);

            // ==============================
            // Merge Sort
            // ==============================
            Callable<Void> mergeCall = () -> {
                int[] toSort = Arrays.copyOf(array, array.length);
                sorter.mergeSort(toSort);
                return null;
            };
            Results rMerge = Benchmark.medir_tiempo(mergeCall, size);
            System.out.println("Merge Sort: " + rMerge);

            // ==============================
            // Sin ordenar (solo medir tiempo base)
            // ==============================
            Callable<Void> noSortCall = () -> {
                // no se ordena
                return null;
            };
            Results rBase = Benchmark.medir_tiempo(noSortCall, size);
            System.out.println("Sin ordenar: " + rBase);
        }
    }

    public static void function1() {
        for (int i = 0; i < 100000; i++) {
            String s = "Numero: " + i;
            System.out.println(s);
        }
    }

    public static int[] generate(int size) {
        int[] numeros = new int[size];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 1000);
        }
        return numeros;
    }

}
