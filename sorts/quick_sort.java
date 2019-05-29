import java.util.Random;

public class quick_sort {

    /**
     *               Get the position of a random element by arranging
     *               in such a way that elements before j are less than
     *               and after are greater than in the array
     *               and sort recursively to the right and left    
     * 
     * @param array  The array to be sorted
     * @param low    The left index
     * @param high   The right index
     */
    public static <T extends Comparable<T>> void quickSort(T[] array, int low, int high) {
        if (high < low) return;
        else {
            int j = partition(array, low, high); // gets the jth position fixed
            quickSort(array, low, j - 1);
            quickSort(array, j + 1, high);
        }

    }

    /**
     *               partition the array by considering j
     * 
     * @param array  partitioning array
     * @param low    left index
     * @param high   right index
     * @return       The position of the element that was fixed in partitioning
     */
    private static <T extends Comparable<T>> int partition(T[] array, int low, int high) {
        int i = low, j = high + 1; // high + 1 as we are using --j

        while (true) {
            while (less(array[++i], array[low])) {
                if (i == high) break;
            }
            while (less(array[low], array[--j])) {
                if (j == low) break;
            }
            if (i >= j) break;
            exch(array, i, j);
        }
        exch(array, low, j);
        return j;
    }

    /**
     *                Swaps the values
     * 
     * @param array   operable array
     * @param i       first index  
     * @param j       secind index 
     */
    private static <T extends Comparable<T>> void exch(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     *           checks wheater a element is less than other
     * 
     * @param a  First Item
     * @param b  Second Item
     * @return   True if first Item < second Item
     */
    private static <T extends Comparable<T>> boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }
    
    public static void main(String[] args) {
        Integer[] a = {1, 6, 8, 4, 2, 5, 88, 7, 60, 39, 9, 42, 7, 5, 21, 3};
        quickSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}