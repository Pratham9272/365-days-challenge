class Solution {
    private int leftCount=0,rightCount=0;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        countNodes(root,x);
        int parentNodes=n-(leftCount+rightCount+1);
        int maxRegion=Math.max(parentCount,Math.max(leftCount,rightCount));
        return maxRegion>n/2;
    }
    private int countNodes(TreeNode node,int x){
        if(node==null) return 0;
        int left=countNodes(node.left,x);
        int right=countNodes(node.right,x);
        if(node.val==x){
            leftCount=left;
            rightCount=right;
        }
        return left+right+1;
    }
}