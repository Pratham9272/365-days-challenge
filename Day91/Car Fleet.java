class Solution {
  public int carFleet(int target, int[] position, int[] speed) {
      // Array to hold the time taken by each car to reach the target
      int n = position.length;
      double[] time = new double[n];

      // Step 1: Calculate the time for each car to reach the target
      for (int i = 0; i < n; i++) {
          time[i] = (double) (target - position[i]) / speed[i];
      }

      // Step 2: Sort the cars based on their positions (in descending order)
      Integer[] indices = new Integer[n];
      for (int i = 0; i < n; i++) {
          indices[i] = i;
      }

      Arrays.sort(indices, (a, b) -> position[b] - position[a]);

      // Step 3: Use a stack to simulate the fleets
      Stack<Double> stack = new Stack<>();
      for (int i = 0; i < n; i++) {
          // Get the time for the current car
          double currentTime = time[indices[i]];

          // If the current car takes more time than the car ahead, it forms a new fleet
          if (stack.isEmpty() || currentTime > stack.peek()) {
              stack.push(currentTime);
          }
      }

      // The number of fleets is the size of the stack
      return stack.size();
  }
}

public class CarFleet {
  public static void main(String[] args) {
      Solution solver = new Solution();
      int target = 12;
      int[] position = {10, 8, 0, 5, 3};
      int[] speed = {2, 4, 1, 1, 3};
      System.out.println("Number of fleets: " + solver.carFleet(target, position, speed));
  }
}
