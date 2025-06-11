class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return dfs(root,root.val);
    }
    private boolean dfs(TreeNode node,int val){
        if(node==null) return true;
        if(node.val!=val) return false;
        return dfs(node.left,val) && dfs(node.right,val);
    }
}