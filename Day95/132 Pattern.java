class Solution {
  public boolean find132pattern(int[] nums) {
      if(nums.length < 3) return false;

      Stack<Integer> stack=new Stack<>();
      int secondMax=Integer.MIN_VALUE;

      for(int i=nums.length-1;i>=0;i--){
          if(nums[i]<secondMax) return true;

          while(!stack.isEmpty() && stack.peek()<nums[i]){
              secondMax=stack.pop();
          }
          stack.push(nums[i]);
      }
      return false;
  }
}