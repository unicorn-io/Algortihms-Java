public class heap_sort {

    /**
     *                Uses Max Priority Queue API  
     *                Heap Sorts the array by heapifying it 
     *                and now exchanging the first and last values
     *                and sinking the first value to the respective
     *                place.           
     * 
    * @param array    The array to be sorted
     */
    public static <T extends Comparable<T>> void heapSort(T[] array) {
        int len = array.length;
        /*  First starting with the lower branches
            of the binary Heap i.e, Three node branches
            and heapify them by sinking the values
            and continuing till the top. */
        for (int i = len/2; i >= 1; i--) { // len/2 because it is a binary HEAP.
            sink(array, i, len);
        }
        while (len > 1) {
            exch(array, 1, len);
            sink(array, 1, --len);
        }
        
    }

    /**
     *                Sinks the value to its Respective place in the HEAP
     *                it does it by checking the daughter value and in 
     *                case of conflict i.e, both daugthers are greater than
     *                parent then the larger daughter dominates.
     *     
     * @param array   The heap Array
     * @param inx     The index that is supposed to be Sinked
     * @param len     The current length of the array
     */
    private static <T extends Comparable<T>> void sink(T[] array, int inx, int len) {
        while (2 * inx <= len) {
            int j = 2 * inx;
            if (j < len && less(array[j - 1], array[j])) j++;
            if (!less(array[inx - 1], array[j - 1])) break; // Same doc as SWAP(1)
            exch(array, inx, j);
            inx = j;
        } 
    }

    /**
     *                Swaps the values
     *                (1)The values of the parameters is decremented by One
     *                As in priority queue we contruct it on/from index 1
     *                but here it is sorting so we prank the heapSort function
     *                and ask a value respectiong MAX PQ but decrement it here.
     * 
     * @param array   operable array
     * @param i       first index  
     * @param j       second index 
     */
    private static <T extends Comparable<T>> void exch(T[] array, int i, int j) {
        T temp = array[i - 1];
        array[i - 1] = array[j - 1];
        array[j - 1] = temp;
    }

    /**
     *           checks whether a element is less than other
     * 
     * @param a  First Item
     * @param b  Second Item
     * @return   True if first Item < second Item
     */
    private static <T extends Comparable<T>> boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }
    
    public static void main(String[] args) {
        String[] unsorted = {"u", "n", "i", "c", "o", "r", "n", "-", "i", "o"};
        heapSort(unsorted);
        for (int i = 0; i < unsorted.length; i++) {
            System.out.printf("%s ", unsorted[i]);
        }
        System.out.println();
    }

}