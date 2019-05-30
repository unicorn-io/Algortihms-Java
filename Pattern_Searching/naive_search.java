public class naive_search {
    
    /**
     *                 Searches for the pattern if the string
     *                 matches the first character and then
     *                 continues to search.. O(N*M)
     *                 Prints the index found
     *    
     * @param str      The String to be looked in.
     * @param value    The String to be searched for.
     */
    public static void naiveSearch(String str, String value) {
        int len = str.length();
        int lenV = value.length();
        int found = 0;

        for (int i = 0; i < len; i++) {
            found = 0;
            if (str.charAt(i) == (value.charAt(0))) {
                for (int j = 1; j < lenV; j++) {
                    found = str.charAt(i + j) == (value.charAt(j)) ? 1 : 0;
                }
            }
            if (found == 1) System.out.println("Found at Index: " + i);
        }
    }
    
    public static void main(String[] args) {
        String ss = "thisisloremipsumandsomerandomtest";
        String value = "and";
        naiveSearch(ss, value);
    }
}