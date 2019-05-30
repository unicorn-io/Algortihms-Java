public class jump_search {
    
    /**
     *                 First searches for the smaller interval
     *                 Then linear searches for the actual value
     *                 accross the interval.
     *       
     * @param array    The SORTED searchable array
     * @param item     The Item to be searched for!
     * @return         The index if FOUND else -1
     */
    public static <T extends Comparable<T>> int jumpSearch(T[] array, T item) {
        int len = array.length, k = 0, prev = 0;
        int inrval = (int) Math.floor(Math.sqrt(len));
    
        while (array[k].compareTo(item) < 0 && k < len) {
            if (array[k].equals(item)) return k;
            prev = k;
            k += inrval;
        }
         
        for (int j = prev; j < k; j++) {
            if (array[j].equals(item)) return j;
        } 
        
        return -1;
    }
    
    public static void main(String[] args) {
        Integer[] a = {0, 0, 1, 3, 5, 6, 7, 8, 9};
        System.out.println(jumpSearch(a, 1));
    }
}