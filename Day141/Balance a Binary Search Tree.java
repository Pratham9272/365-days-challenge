class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sorted=new ArrayList<>();
        inorder(root,sorted);
        return buildBalancedBST(sorted,0,sorted.size()-1);
    }
    private void inorder(TreeNode root,List<Integer> list){
        if(root==null)return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    private TreeNode buildBalancedBST(List<Integer> list,int low,int high){
        if(low>high) return null;
        int mid=(low+high)/2;
        TreeNode node=new TreeNode(list.get(mid));
        node.left=buildBalancedBST(list,low,mid-1);
        node.right=buildBalancedBST(list,mid+1,high);
        return node;
    }
}