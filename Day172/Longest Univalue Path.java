class Solution {
    private int maxLen=0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return maxLen;
    }
    private int dfs(TreeNode node){
        if(node==null) return 0;
        int left=dfs(node.left);
        int right=dfs(node.right);
        int leftPath=0,rightPath=0;
        if(node.left!=null && node.left.val==node.val){
            leftPath=left+1;
        }
        if(node.right!=null && node.right.val==node.val){
            rightPath=right+1;
        }
        maxLen=Math.max(maxLen,leftPath+rightPath);
        return Math.max(leftPath,rightPath);
    }
}