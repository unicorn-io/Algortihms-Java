public class insertion_sort {

    public static void insertionSort(int[] array) {
        int length = array.length;
        int i, key, j;
        for (i = 1; i < length; i++) {
            key = array[i];
            j = i - 1;
            /*Move elements of the array that are greater
              than the key moving by one position
              ahead of the current postiions*/
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;

        }
    }

    public static void main(String[] args) {
        int[] unsorted = {5, 15, 8, 4, 9, 63, 88};
        insertionSort(unsorted);
        for (int i = 0; i < unsorted.length; i++) {
            System.out.printf("%d ", unsorted[i]);
        }
        System.out.println();
    }
}

