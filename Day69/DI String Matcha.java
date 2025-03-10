class Solution {
  public int[] diStringMatch(String s) {
      int n = s.length(), low = 0, high = n;
      int[] perm = new int[n + 1];
      for (int i = 0; i < n; i++) {
          if (s.charAt(i) == 'I') perm[i] = low++;
          else perm[i] = high--;
      }
      perm[n] = low;
      return perm;
  }
}
