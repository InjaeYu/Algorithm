public class QuickSort { 
    public void quickSort(int[] arr) {
        qSort(arr, 0, arr.length - 1);
    }

    private void qSort(int[] arr, int low, int high) {
        int i = low, j = high;
        int pivot = arr[(i + j) / 2];

        while(i <= j) {
            while(arr[i] < pivot) {
                i += 1;
            }
            while(arr[j] > pivot) {
                j -= 1;
            }
            if(i <= j) {
                int temp = arr[i];
                arr[i++] = arr[j];
                arr[j--] = temp;
            }
        }

        if(low < j) {
            qSort(arr, low, j);
        }

        if(i < high) {
            qSort(arr, i, high);
        }
    }
}
