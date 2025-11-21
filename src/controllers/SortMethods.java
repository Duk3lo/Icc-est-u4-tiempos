package controllers;

public class SortMethods {

    // Burbuja clásica (in-place)
    public void sortBubble(int[] numeros) {
        int n = numeros.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }
            }
        }
    }

    public void burbble(int[] numeros) {
        int n = numeros.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public void shell(int[] numeros) {
        int n = numeros.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = numeros[i];
                int j = i;
                while (j >= gap && numeros[j - gap] > temp) {
                    numeros[j] = numeros[j - gap];
                    j -= gap;
                }
                numeros[j] = temp;
            }
        }
    }

    public void mergeSort(int[] numeros) {
        int n = numeros.length;
        if (n < 2) return;
        int[] aux = new int[n];
        for (int width = 1; width < n; width *= 2) {
            for (int left = 0; left < n; left += 2 * width) {
                int mid = Math.min(left + width, n);
                int right = Math.min(left + 2 * width, n);
                for (int k = left; k < right; k++) aux[k] = numeros[k];
                int i = left, j = mid, k = left;
                while (i < mid && j < right) {
                    if (aux[i] <= aux[j]) numeros[k++] = aux[i++];
                    else numeros[k++] = aux[j++];
                }
                while (i < mid) numeros[k++] = aux[i++];
                while (j < right) numeros[k++] = aux[j++];
            }
        }
    }
}
