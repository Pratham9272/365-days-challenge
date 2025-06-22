class Solution {
    private int min;
    private long smin;

    public int findSecondMinimumValue(TreeNode root) {
        if(root==null) return -1;
        min=root.val;
        smin=Long.MAX_VALUE;
        dfs(root);
        return smin==Long.MAX_VALUE?-1:(int) smin;    
    }
    private void dfs(TreeNode node){
        if(node==null) return;
        if(node.val>min && node.val<smin){
            smin=node.val;
        }
        dfs(node.left);
        dfs(node.right);
    }
}