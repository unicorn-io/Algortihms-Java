/**
 * Knuth Moris Pratt algorithm
 * It is a O(n) algorithms for finding pat in text
 */

public class kmp_search {

    /**
     *                It implements the KMP search over
     *                the text with a given pattern
     * 
     * @param text    The text to be searched in.
     * @param pat     The pattern to be matched
     * @return        The index of the pattern in the text else -1.
     */
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
  
    /**
     *               In the preprocessing part, we
     *               calculate values in lps[]. To
     *               do that, we keep track of the
     *               length of the longest prefix suffix
     *               value (we use len variable for this purpose)
     *               for the previous index. We initialize lps[0]
     *               and len as 0. If pat[len] and pat[i] match,
     *               we increment len by 1 and assign the
     *               incremented value to lps[i]. If pat[i]
     *               and pat[len] do not match and len is not 0,
     *               we update len to lps[len-1].
     *               See computeLPSArray () in the below code for details. 
     * 
     * @param pat    The pattern for which LSP is to be created
     * @return       The LSP array.
     */
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
      System.out.println(kmpSearch("abcdedabcdabcedabcdabd", "abd"));
    }
  }