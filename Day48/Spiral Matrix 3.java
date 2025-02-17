class Solution {
  public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
      int[][] result = new int[rows * cols][2];
      int index = 0;
      int[] directions = {0, 1, 1, 0, 0, -1, -1, 0};
      int length = 1, d = 0;
      result[index++] = new int[]{rStart, cStart};
      while (index < rows * cols) {
          for (int i = 0; i < 2; i++) {
              for (int j = 0; j < length; j++) {
                  rStart += directions[d];
                  cStart += directions[d + 1];
                  if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                      result[index++] = new int[]{rStart, cStart};
                  }
              }
              d = (d + 2) % 8;
          }
          length++;
      }
      return result;
  }
}
