class Solution {
    private TreeNode first=null;
    private TreeNode second=null;
    private TreeNode prev=new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }

    private void inorder(TreeNode node){
        if(node==null) return;
        inorder(node.left);

        if(first==null && prev.val>node.val){
            first=prev;
        }
        if(first!=null && prev.val>node.val){
            second=node;
        }
        prev=node;
        inorder(node.right);
    }
}