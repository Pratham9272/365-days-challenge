class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        root.val=0;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            Map<TreeNode,Integer> childSum=new HashMap<>();
            int total=0;
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                int sum=0;
                if(node.left!=null){
                    sum+=node.left.val;
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    sum+=node.right.val;
                    queue.offer(node.right);
                }
                childSum.put(node,sum);
                total+=sum;
            }
            for(TreeNode node:childSum.keySet()){
                if(node.left!=null) node.left.val=total-childSum.get(node);
                if(node.right!=null) node.right.val=total-childSum.get(node);
            }
        }
        return root;
    }
}