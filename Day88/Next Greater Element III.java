class Solution {
  public int nextGreaterElement(int n) {
      char[] digits=Integer.toString(n).toCharArray();
      int i=digits.length-2;
      while(i>=0&&digits[i]>=digits[i+1]){
          i--;
      }
      if(i==-1) return -1;
      int j=digits.length-1;
      while(digits[j]<=digits[i]){
          j--;
      }
      char temp=digits[i];
      digits[i]=digits[j];
      digits[j]=temp;
      reverse(digits,i+1,digits.length-1);
      long result=Long.parseLong(new String(digits));
      return(result>Integer.MAX_VALUE)?-1:(int) result;
  }
  private void reverse(char[] arr,int start,int end){
      while(start<end){
          char temp=arr[start];
          arr[start]=arr[end];
          arr[end]=temp;
          start++;
          end--;
      }
  }
}