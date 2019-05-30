public class shell_sort {
    
    /**
     *                h sorts the array using insertion sort
     *                h follows 3*X+1 Series 
     *                O(N^3/2)
     *              
     * @param array   THe array to be sorted
     */
    public static <T extends Comparable<T>> void shellSort(T[] array) {
        int h = 1, len = array.length;

        while(h < len / 3) h = 3*h + 1; // gets the h value as array_length / 3
 
        // h sort the array updating h until h is less than or equal to 1
        while (h >= 1) {
            for (int i = 0; i < len; i++) {
                /* exchanges the ith value (making it equal to j) over and over
                   if it is greater that the lesser index Item*/
                for (int j = i; j >= h && array[j].compareTo(array[j - h]) < 0; j -= h) {
                    exch(array, j, j - h);
                }
            }
            h /= 3;
        }

    }

    /**
     *                Swaps the values
     * 
     * @param array   operable array
     * @param i       first index  
     * @param j       second index 
     */
    private static <T extends Comparable<T>> void exch(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static void main(String[] args) {
        Integer[] unsorted = {5, 15, 8, 4, 9, 63, 88};
        shellSort(unsorted);
        for (int i = 0; i < unsorted.length; i++) {
            System.out.printf("%d ", unsorted[i]);
        }
        System.out.println();
    }
}