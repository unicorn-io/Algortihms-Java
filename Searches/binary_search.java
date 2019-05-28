public class binary_search {
    

    /**
     *               Generic Binary Search Algorithm
     * @param array  The SORTED array to be looked in.
     * @param item   The item to be searched for
     * @return       returns the index if FOUND else -1
     */
    public static <T extends Comparable<T>> int binarySearch(T[] array, T item) {
        int low = 0, mid;
        int high = array.length - 1;
        
        while (low < high) {
            mid = (low + high) / 2;
            if (array[mid] == item) {
                return mid;
            } else if (array[mid].compareTo(item) > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {

        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(a, 3));

    }
}