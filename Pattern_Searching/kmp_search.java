public class kmp_search {

    public static int kmpSearch (String text, String pat) {
      int[] lsp = createLSP(pat);
      int patIndex = 0;
      for (int i = 0; i < text.length(); i++) {
        if (pat.charAt(patIndex) == text.charAt(i)) {
          patIndex++;
          if(patIndex == pat.length()) {
            return i - pat.length() + 1;
          }
        } else {
          patIndex = lsp[patIndex - 1] == -1 ? 0 : lsp[patIndex - 1];
        }
      }
      return -1;
    }
  
    private static int[] createLSP(String pat) {
      int i = 0, j = 1;
      int lsp[] = new int[pat.length()];
      lsp[0] = 0;
      for (j = 1; j < pat.length(); j++) {
        if (pat.charAt(i) == pat.charAt(j)) {
          lsp[j] = ++i;
        } else {
          i = 0;
          lsp[j] = 0;
        }
      }
      return lsp;
  
    }
  
    public static void main(String[] args) {
      kmp_search ss = new kmp_search();
      int[] arr = createLSP("abcd");
      String text = "abcdabcabdabcd";
      System.out.println(kmpSearch("abcdedabcdabcedabcdabd", "abd"));
    }
  }