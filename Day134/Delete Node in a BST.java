class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        
        if(key<root.val){
            root.left=deleteNode(root.left,key);
        }else if(key>root.val){
            root.right=deleteNode(root.right,key);
        }else{
            if(root.left==null && root.right==null){
                return null;
            }else if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }else{
                TreeNode succ=findMin(root.right);
                root.val=succ.val;
                root.right=deleteNode(root.right,succ.val);
            }
        }
        return root;
    }
    private TreeNode findMin(TreeNode node){
        while(node.left!=null){
            node=node.left;
        }
        return node;
    }
}