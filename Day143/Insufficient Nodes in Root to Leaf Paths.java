class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return dfs(root,0,limit);
    }

    private TreeNode dfs(TreeNode node,int sum,int limit){
        if(node==null) return null;

        if(node.left==null && node.right==null){
            return(sum+node.val>=limit)?node:null;
        }

        node.left=dfs(node.left,sum+node.val,limit);
        node.right=dfs(node.right,sum+node.val,limit);

        if(node.left==null && node.right==null){
            return null;
        }
        return node;
    }
}