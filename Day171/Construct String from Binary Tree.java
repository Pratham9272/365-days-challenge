class Solution {
    public String tree2str(TreeNode root) {
        if(root==null) return "";
        StringBuilder sb=new StringBuilder();
        buildString(root,sb);
        return sb.toString();
    }
    private void buildString(TreeNode node,StringBuilder sb){
        if(node==null) return;
        sb.append(node.val);
        if(node.left!=null || node.right!=null){
            sb.append("(");
            buildString(node.left,sb);
            sb.append(")");
        }
        if(node.right!=null){
            sb.append("(");
            buildString(node.right,sb);
            sb.append(")");
        }
    }
}