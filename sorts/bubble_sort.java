public class bubble_sort {

    /**
     * swap if the next element is less than the just previous
     * @param array
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j].compareTo(array[j+1]) > 0) {
                    T temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] strings = {"c", "a", "e", "b", "d"};
        bubbleSort(strings);
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + " ");
        }
        System.out.println();
    }
}