class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums,0,nums.length-1);
    }
    private TreeNode build(int[] nums,int left,int right){
        if(left>right)return null;
        int maxIndex=left;
        for(int i=left+1;i<=right;i++){
            if(nums[i]>nums[maxIndex]) maxIndex=i;
        }
        TreeNode root=new TreeNode(nums[maxIndex]);
        root.left=build(nums,left,maxIndex-1);
        root.right=build(nums,maxIndex+1,right);
        return root;
    }
}