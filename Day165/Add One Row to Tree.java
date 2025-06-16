class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode newRoot=new TreeNode(val);
            newRoot.left=root;
            return newRoot;
        }
        insert(root,val,1,depth);
        return root;
    }
    private void insert(TreeNode node,int val,int currDepth,int targetDepth){
        if(node==null)return;
        if(currDepth==targetDepth-1){
            TreeNode tempLeft=node.left;
            TreeNode tempRight=node.right;
            node.left=new TreeNode(val);
            node.right=new TreeNode(val);
            node.left.left=tempLeft;
            node.right.right=tempRight;
        }else{
            insert(node.left,val,currDepth+1,targetDepth);
            insert(node.right,val,currDepth+1,targetDepth);
        }
    }
}