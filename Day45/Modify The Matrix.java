class Solution {
  public int[][] modifiedMatrix(int[][] matrix) {
      int m = matrix.length, n = matrix[0].length;
      int[] maxInColumn = new int[n];
      
      for (int j = 0; j < n; j++) {
          for (int i = 0; i < m; i++) {
              if (matrix[i][j] != -1) {
                  maxInColumn[j] = Math.max(maxInColumn[j], matrix[i][j]);
              }
          }
      }
      
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              if (matrix[i][j] == -1) {
                  matrix[i][j] = maxInColumn[j];
              }
          }
      }
      
      return matrix;
  }
}
