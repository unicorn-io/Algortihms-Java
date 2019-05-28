public class selection_sort {

    public static <T extends Comparable<T>> void selectionSort(T[] array) {
        int len = array.length, key = 0;
        // get the maximum in the array and throw to the last
        // max tracks the maximum and key tracks the index
        T max;
        for (int i = 0; i < len; i++) {
            max = array[0];
            for (int j = 1; j < len - i; j++) {
                if (array[j].compareTo(max) > 0) {
                    max = array[j];
                    key = j;
                }
            }
            // Throws at the last
            T temp = array[len-i-1];
            array[len-i-1] = array[key];
            array[key] = temp;
        }
    }

    public static void main(String[] args) {
        Integer[] unsorted = {5, 15, 8, 4, 9, 63, 88};
        selectionSort(unsorted);
        for (int i = 0; i < unsorted.length; i++) {
            System.out.printf("%d ", unsorted[i]);
        }
        System.out.println();
    }
}