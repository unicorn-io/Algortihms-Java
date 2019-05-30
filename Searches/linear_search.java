public class linear_search {
    
    /**
     *               Generic Linear Search Method
     *
     * @param array  The array to be Searched in
     * @param item   The Item to be Seached for
     * @return       index of the item if FOUND else -1    
     */
    public static <T extends Comparable<T>> int linearSearch(T[] array, T item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == item) {
                return i;
            } else {
                return -1;
            }
        }
        return 0;
    }
}
