public class interpolation_search {

    /**
     *                 Gets the probe positon 
     *                 Searches in the array near probe
     * 
     * @param array    The array to be looked in
     * @param item     The item to be looked for
     * @return         Returns the index if FOUND else -1  
     */
    public static int interpolationSearch(int[] array, int item) {
        int low = 0, high = array.length - 1;

        while (low < high) {
            int pos = probePosition(array, low, high, item);
            if (array[pos] == item) return pos;
            else if (array[pos] > item) {
                high = pos + 1;
            } else {
                low = pos - 1;
            }
        }
        return -1;
    }

    /**
     *               Gets the probr position
     * 
     * @credits      Geekforgeeks
     * @param arr    The array for calculation
     * @param low    lower array value
     * @param high   higher array value
     * @param item   The item for relative probe postion
     * @return       The probe position
     */
    private static int probePosition(int[] arr, int low, int high, int item) {
        // The idea of formula is to return higher value of pos
        // when element to be searched is closer to arr[hi]. And
        // smaller value when closer to arr[lo]
        return ((item - arr[low]) * (high - low)) / (arr[high] - arr[low]);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(interpolationSearch(a, 1));
    }

}