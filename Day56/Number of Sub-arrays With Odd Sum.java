class Solution {
  public int numOfSubarrays(int[] arr) {
      int odd = 0, even = 1, sum = 0, count = 0;
      int mod = 1000000007; 
      
      for (int i = 0; i < arr.length; i++) {
          sum += arr[i];
          if (sum % 2 == 0) {
              count += odd;
              even++;
          } else {
              count += even;
              odd++;
          }
          count %= mod; 
      }
      
      return count;
  }
}
