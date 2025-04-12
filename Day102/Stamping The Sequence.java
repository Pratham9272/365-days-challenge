class Solution {
  public int[] movesToStamp(String stamp, String target) {
      char[] S = stamp.toCharArray();
      char[] T = target.toCharArray();
      boolean[] visited = new boolean[T.length];
      List<Integer> result = new ArrayList<>();
      int totalReplaced = 0;

      while (totalReplaced < T.length) {
          boolean didReplace = false;

          for (int i = 0; i <= T.length - S.length; i++) {
              if (!visited[i] && canReplace(T, i, S)) {
                  totalReplaced += doReplace(T, i, S.length);
                  visited[i] = true;
                  didReplace = true;
                  result.add(i);
              }
          }

          if (!didReplace) return new int[0];
      }

      Collections.reverse(result);
      return result.stream().mapToInt(i -> i).toArray();
  }

  private boolean canReplace(char[] T, int pos, char[] S) {
      for (int i = 0; i < S.length; i++) {
          if (T[pos + i] != '?' && T[pos + i] != S[i]) {
              return false;
          }
      }
      return true;
  }

  private int doReplace(char[] T, int pos, int len) {
      int replaced = 0;
      for (int i = 0; i < len; i++) {
          if (T[pos + i] != '?') {
              T[pos + i] = '?';
              replaced++;
          }
      }
      return replaced;
  }
}
