class Solution {
  public String getDirections(TreeNode root, int startValue, int destValue) {
      StringBuilder pathToStart=new StringBuilder();
      StringBuilder pathToDest=new StringBuilder();

      getPath(root,startValue,pathToStart);
      getPath(root,destValue,pathToDest);

      int i=0, maxCommon=Math.min(pathToStart.length(), pathToDest.length());
      while(i<maxCommon && pathToStart.charAt(i)==pathToDest.charAt(i)){
          i++;
      }

      StringBuilder result=new StringBuilder();
      for(int j=i;j<pathToStart.length();j++){
          result.append('U');
      }
      result.append(pathToDest.substring(i));
      return result.toString();
  }
  private boolean getPath(TreeNode node, int target,StringBuilder path){
      if(node==null) return false;
      if(node.val==target) return true;

      path.append('L');
      if(getPath(node.left,target,path)) return true;
      path.deleteCharAt(path.length()-1);

      path.append('R');
      if(getPath(node.right,target,path)) return true;
      path.deleteCharAt(path.length()-1);

      return false;
  }
}