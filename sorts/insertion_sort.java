public class insertion_sort {
    
    /**              sorts the array using insertion sort
     *  
     * @param array  The unsorted array
     */
    public static <T extends Comparable<T>> void insertionSort(T[] array) {
        int length = array.length;
        int i, j;
        /*Move elements of the array that are greater
          than the key moving by one position
          ahead of the current postiions*/
        for (i = 1; i < length; i++) {
           for (j = i; j >= 1 && array[j].compareTo(array[j - 1]) < 0; j--) {
               T temp = array[j];
               array[j] = array[j - 1];
               array[j - 1] = temp;
           }
        }
    }
    

    public static void main(String[] args) {
        Integer[] unsorted = {5, 15, 8, 4, 9, 63, 88};
        insertionSort(unsorted);
        for (int i = 0; i < unsorted.length; i++) {
            System.out.printf("%d ", unsorted[i]);
        }
        System.out.println();
    }
}

