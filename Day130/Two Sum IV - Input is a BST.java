class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set=new HashSet<>();
        return dfs(root,set,k);
    }
    private boolean dfs(TreeNode node,Set<Integer> set,int k){
        if(node==null) return false;

        if(set.contains(k-node.val)){
            return true;
        }
        set.add(node.val);

        return dfs(node.left,set,k) || dfs(node.right,set,k);
    }
}