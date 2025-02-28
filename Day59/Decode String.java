class Solution {
  public String decodeString(String s) {
      Stack<Integer> counts = new Stack<>();
      Stack<StringBuilder> result = new Stack<>();
      StringBuilder currString = new StringBuilder();
      int currNum = 0;

      for (char c : s.toCharArray()) {
          if (Character.isDigit(c)) {
              currNum = currNum * 10 + (c - '0');
          } else if (c == '[') {
              counts.push(currNum);
              result.push(currString);
              currString = new StringBuilder();
              currNum = 0;
          } else if (c == ']') {
              StringBuilder temp = currString;
              currString = result.pop();
              for (int i = counts.pop(); i > 0; i--) {
                  currString.append(temp);
              }
          } else {
              currString.append(c);
          }
      }

      return currString.toString();
  }
}
