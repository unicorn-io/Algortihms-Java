public class selection_sort {

    public static void selectionSort(int[] array) {
        int len = array.length;
        // get the maximum in the array and throw to the last
        // max tracks the maximum and key tracks the index
        int max, key = 0;
        for (int i = 0; i < len; i++) {
            max = array[0];
            for (int j = 1; j < len - i; j++) {
                if (max < array[j]) {
                    max = array[j];
                    key = j;
                }
            }
            // Throws at the last
            int temp = array[len-i-1];
            array[len-i-1] = array[key];
            array[key] = temp;
        }
    }

    public static void main(String[] args) {
        int[] unsorted = {5, 15, 8, 4, 9, 63, 88};
        selectionSort(unsorted);
        for (int i = 0; i < unsorted.length; i++) {
            System.out.printf("%d ", unsorted[i]);
        }
        System.out.println();
    }
}