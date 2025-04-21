class Solution {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      List<List<Integer>> result=new ArrayList<>();
      if(root==null) return result;

      Queue<TreeNode> queue=new LinkedList<>();
      queue.offer(root);
      boolean leftToRight=true;

      while(!queue.isEmpty()){
          int size=queue.size();
          LinkedList<Integer> level=new LinkedList<>();

          for(int i=0;i<size;i++){
              TreeNode current=queue.poll();

              if(leftToRight){
                  level.addLast(current.val);
              }else{
                  level.addFirst(current.val);
              }
              if(current.left != null) queue.offer(current.left);
              if(current.right != null) queue.offer(current.right);
          }
          result.add(level);
          leftToRight = !leftToRight;
      }
      return result;
  }
}