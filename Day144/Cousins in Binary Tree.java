class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size=queue.size();
            boolean foundX=false,foundY=false;
            TreeNode parentX=null,parentY=null;

            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();

                if(node.left!=null){
                    if(node.left.val==x){
                        foundX=true;
                        parentX=node;
                    }
                    if(node.left.val==y){
                        foundY=true;
                        parentY=node;
                    }
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    if(node.right.val==x){
                        foundX=true;
                        parentX=node;
                    }
                    if(node.right.val==y){
                        foundY=true;
                        parentY=node;
                    }
                    queue.offer(node.right);
                }
            }
            if(foundX && foundY){
                return parentX!=parentY;
            }
            if(foundX || foundY){
                return false;
            }
        }
        return false;
    }
}