class Solution {
    private int index=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildBST(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private TreeNode buildBST(int[] preorder,int lower,int upper){
        if(index==preorder.length)return null;

        int val=preorder[index];
        if(val<lower || val>upper) return null;

        index++;
        TreeNode root=new TreeNode(val);
        root.left=buildBST(preorder,lower,val);
        root.right=buildBST(preorder,val,upper);
        return root;
    }
}