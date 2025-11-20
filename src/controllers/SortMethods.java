package controllers;

public class SortMethods {

    // Burbuja clásica
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

    // Burbuja mejorada (detiene si ya está ordenado)
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

    // Shell sort (secuencia simple gap /= 2)
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

    // Merge sort iterativo (bottom-up) sin métodos auxiliares privados
    public void mergeSort(int[] numeros) {
        int n = numeros.length;
        if (n < 2)
            return;

        int[] aux = new int[n];

        // tamaño de subarrays a fusionar: 1, 2, 4, 8, ...
        for (int width = 1; width < n; width *= 2) {
            for (int left = 0; left < n; left += 2 * width) {
                int mid = Math.min(left + width, n);
                int right = Math.min(left + 2 * width, n);

                // copiar segmento [left, right)
                for (int k = left; k < right; k++) {
                    aux[k] = numeros[k];
                }

                int i = left; // cursor izquierda (aux)
                int j = mid; // cursor derecha (aux)
                int k = left; // cursor resultado en numeros

                while (i < mid && j < right) {
                    if (aux[i] <= aux[j]) {
                        numeros[k++] = aux[i++];
                    } else {
                        numeros[k++] = aux[j++];
                    }
                }
                while (i < mid) {
                    numeros[k++] = aux[i++];
                }
                while (j < right) {
                    numeros[k++] = aux[j++];
                }
            }
        }
    }
}