class Solution {
  public int carFleet(int target, int[] position, int[] speed) {
      int n = position.length;
      double[] time = new double[n];

      for (int i = 0; i < n; i++) {
          time[i] = (double) (target - position[i]) / speed[i];
      }

      Integer[] indices = new Integer[n];
      for (int i = 0; i < n; i++) {
          indices[i] = i;
      }

      Arrays.sort(indices, (a, b) -> position[b] - position[a]);
      Stack<Double> stack = new Stack<>();
      for (int i = 0; i < n; i++) {
          double currentTime = time[indices[i]];
          if (stack.isEmpty() || currentTime > stack.peek()) {
              stack.push(currentTime);
          }
      }
      return stack.size();
  }
}
