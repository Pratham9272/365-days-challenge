class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack=new Stack<>();
        pushLeftBranch(root);    
    }
    
    public int next() {
        TreeNode node=stack.pop();
        if(node.right!=null){
            pushLeftBranch(node.right);
        }
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushLeftBranch(TreeNode node){
        while(node!=null){
            stack.push(node);
            node=node.left;
        }
    }
}