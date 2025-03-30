class Solution {
  public int largestRectangleArea(int[] heights) {
      int n = heights.length;
      int[] left=new int[n];
      int[] right=new int[n];
      Stack<Integer> stack = new Stack<>();

      //Right Smaller
      for(int i=n-1;i>=0;i--){
          while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
              stack.pop();
          }
          right[i]=stack.isEmpty() ? n : stack.peek();
          stack.push(i);
      }
      stack.clear();

      //Left Smaller
      for(int i=0;i<n;i++){
          while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
              stack.pop();
          }
          left[i]=stack.isEmpty() ? -1 : stack.peek();
          stack.push(i);
      }

      //Calculate the area
      int maxArea=0;
      for(int i=0;i<n;i++){
          int width=right[i]-left[i]-1;
          int currArea=heights[i]*width;
          maxArea=Math.max(currArea,maxArea);
      }
      return maxArea;
  }
}