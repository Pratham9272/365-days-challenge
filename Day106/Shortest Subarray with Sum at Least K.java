class Solution {
  public int shortestSubarray(int[] nums, int k) {
      int n = nums.length;
      long[] prefix = new long[n + 1];
      for (int i = 0; i < n; i++) {
          prefix[i + 1] = prefix[i] + nums[i];
      }

      Deque<Integer> deque = new LinkedList<>();
      int result = Integer.MAX_VALUE;

      for (int i = 0; i < prefix.length; i++) {
          while (!deque.isEmpty() && prefix[i] - prefix[deque.peekFirst()] >= k) {
              result = Math.min(result, i - deque.pollFirst());
          }

          while (!deque.isEmpty() && prefix[i] <= prefix[deque.peekLast()]) {
              deque.pollLast();
          }

          deque.offerLast(i);
      }
      return result == Integer.MAX_VALUE ? -1 : result;
  }
}
