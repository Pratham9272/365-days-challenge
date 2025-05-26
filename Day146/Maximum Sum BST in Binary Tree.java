class Solution {
    class NodeInfo{
        boolean isBST;
        int min,max,sum;

        NodeInfo(boolean isBST,int min,int max,int sum){
            this.isBST=isBST;
            this.min=min;
            this.max=max;
            this.sum=sum;
        }
    }
    int maxSum=0;
    public int maxSumBST(TreeNode root){
        postOrder(root);
        return maxSum;
    }
    private NodeInfo postOrder(TreeNode node){
        if(node==null){
            return new NodeInfo(true,Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }
        NodeInfo left=postOrder(node.left);
        NodeInfo right=postOrder(node.right);

        if(left.isBST && right.isBST && node.val>left.max && node.val<right.min){
            int sum=left.sum+right.sum+node.val;
            maxSum=Math.max(maxSum,sum);
            int min=Math.min(node.val,left.min);
            int max=Math.max(node.val,right.max);
            return new NodeInfo(true,min,max,sum);
        }else{
            return new NodeInfo(false,0,0,0);
        }
    }
}