class Solution {
  public int maxResult(int[] nums, int k) {
      int n = nums.length;
      Deque<Integer> deque = new LinkedList<>();
      int[] dp = new int[n];
      dp[0] = nums[0];
      deque.add(0);
      
      for (int i = 1; i < n; i++) {
          if (deque.peekFirst() < i - k) {
              deque.pollFirst();
          }
          dp[i] = nums[i] + dp[deque.peekFirst()];
          while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
              deque.pollLast();
          }
          
          deque.addLast(i);
      }
      
      return dp[n - 1];
  }
}
