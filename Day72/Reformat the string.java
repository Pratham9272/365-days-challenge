class Solution {
  public String reformat(String s) {
      StringBuilder letters = new StringBuilder();
      StringBuilder digits = new StringBuilder();
      
      for (char c : s.toCharArray()) {
          if (Character.isLetter(c)) {
              letters.append(c);
          } else {
              digits.append(c);
          }
      }
      
      if (Math.abs(letters.length() - digits.length()) > 1) {
          return "";
      }
      
      StringBuilder result = new StringBuilder();
      boolean letterFirst = letters.length() >= digits.length();
      int i = 0, j = 0;
      
      while (i < letters.length() || j < digits.length()) {
          if (letterFirst && i < letters.length()) {
              result.append(letters.charAt(i++));
          }
          if (!letterFirst && j < digits.length()) {
              result.append(digits.charAt(j++));
          }
          letterFirst = !letterFirst;
      }
      
      return result.toString();
  }
}
