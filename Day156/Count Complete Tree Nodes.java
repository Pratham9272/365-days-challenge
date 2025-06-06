class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int left=getHeight(root.left);
        int right=getHeight(root.right);
        if(left==right){
            return(1<<left)+countNodes(root.right);
        }else{
            return(1<<right)+countNodes(root.left);
        }
    }
    private int getHeight(TreeNode node){
        int height=0;
        while(node!=null){
            node=node.left;
            height++;
        }
        return height;
    }
}