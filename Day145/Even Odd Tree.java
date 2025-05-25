class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        if (root==null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size=queue.size();
            int prev=(level%2==0) ? Integer.MIN_VALUE:Integer.MAX_VALUE;

            for (int i=0;i<size;i++) {
                TreeNode node=queue.poll();
                int val=node.val;

                if (level%2==0) {
                    if(val%2==0 || val<=prev) return false;
                } else {
                    if(val%2!=0 || val>=prev) return false;
                }
                prev = val;

                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            level++;
        }
        return true;
    }
}