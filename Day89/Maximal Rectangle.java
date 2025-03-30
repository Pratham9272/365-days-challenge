class Solution {
  public int maximalRectangle(char[][] matrix) {
      if(matrix.length==0){
          return 0;
      }
      int heights[]=new int[matrix[0].length];
      int largest=0;
      for(int i=0;i<matrix.length;i++){
          for(int j=0;j<matrix[i].length;j++){
              int val=matrix[i][j]-'0';
              if(val==0){
                  heights[j]=0;
              }else{
                  heights[j]+=val;
              }
          }
          int maxArea=largestRectangleArea(heights);
          if(largest<maxArea){
              largest=maxArea;
          }
      }
      return largest;
  }
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