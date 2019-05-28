public class merge_sort{

    /**
     * @param array  unsorted comparable array
     * @param low    first index of the current array
     * @param mid    middle index of the current array
     * @param high   last index of the current array
     *               merges the items in increasing order
     *               into an temp array and copying to comparable
     */
    private static <T extends Comparable<T>> void merge(T[] array, int low, int mid, int high) {
      @SuppressWarnings("unchecked")
      T[] temp = (T[]) new Comparable[high - low + 1];
      int i = low, j = mid + 1, k = 0;
  
      while (i <= mid && j <= high) {
        if (array[i].compareTo(array[j]) <= 0) {
          temp[k++] = array[i++];
        } else {
          temp[k++] = array[j++];
        }
      }
  
      while (i <= mid) {
        temp[k++] = array[i++];
      }
  
      while (j <= high) {
        temp[k++] = array[j++];
      }
  
      for (int l = low; l <= high; l++) {
        array[l] = temp[l - low];
      }
    }
  
    /***
     * @param array comparable unsorted array
     * @param low   value to the extreme left of the current array
     * @param high  value to the extreme right of the current array
     *              recursively sorts the array in increasing order
     */
    public static <T extends Comparable<T>> void mergeSort(T[] array, int low, int high) {
      if (low < high) {
        int mid = (high + low) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        merge(array, low, mid, high);
      }
  
    }
  
    public static void main(String[] args) {
      Integer[] unsorted = {5, 15, 8, 4, 9, 63, 88};
      mergeSort(unsorted, 0, unsorted.length - 1);
      for (int i = 0; i < unsorted.length; i++) {
        System.out.printf("%d ", unsorted[i]);
      }
      System.out.println();
    }
  }