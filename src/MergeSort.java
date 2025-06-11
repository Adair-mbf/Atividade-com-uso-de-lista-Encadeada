public class MergeSort {
    public static void mergeSort(int[] array, int inicio, int fim) {
        if (inicio >= fim) return;

        int meio = (inicio + fim) / 2;
        mergeSort(array, inicio, meio);
        mergeSort(array, meio + 1, fim);

        int n1 = meio - inicio + 1;
        int n2 = fim - meio;
        int[] temp = new int[fim - inicio + 1];
        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (array[inicio + i] <= array[meio + 1 + j]) {
                temp[k++] = array[inicio + i++];
            } else {
                temp[k++] = array[meio + 1 + j++];
            }
        }

        while (i < n1) temp[k++] = array[inicio + i++];
        while (j < n2) temp[k++] = array[meio + 1 + j++];
        for (int m = 0; m < temp.length; m++) {
            array[inicio + m] = temp[m];
        }
    }
}
