class Solution {  
  public boolean checkValidString(String s) {  
      int leftMin = 0, leftMax = 0;  
      for (char c : s.toCharArray()) {  
          if (c == '(') {  
              leftMin++;  
              leftMax++;  
          } else if (c == ')') {  
              leftMin = Math.max(leftMin - 1, 0);  
              leftMax--;  
          } else {  
              leftMin = Math.max(leftMin - 1, 0);  
              leftMax++;  
          }  
          if (leftMax < 0) return false;  
      }  
      return leftMin == 0;  
  }  
}
