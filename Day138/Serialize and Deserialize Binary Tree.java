public class Codec {
    private static final String SEP=",";
    private static final String NULL="#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "";
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                sb.append(NULL).append(SEP);
            }else{
                sb.append(node.val).append(SEP);
                q.add(node.left);
                q.add(node.right);
            }
        }

        String[] tokens=sb.toString().split(SEP);
        int lastNonNull=tokens.length-1;
        while(lastNonNull>=0 && tokens[lastNonNull].equals(NULL)){
            lastNonNull--;
        }
        return String.join(SEP,Arrays.copyOf(tokens,lastNonNull+1));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.isEmpty()) return null;
        String[] tokens=data.split(SEP);
        TreeNode root=new TreeNode(Integer.parseInt(tokens[0]));
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        int i=1;
        while(i<tokens.length){
            TreeNode parent=q.poll();
            if(!tokens[i].equals(NULL)){
                TreeNode left=new TreeNode(Integer.parseInt(tokens[i]));
                parent.left=left;
                q.add(left);
            }
            i++;

            if(i<tokens.length && !tokens[i].equals(NULL)){
                TreeNode right=new TreeNode(Integer.parseInt(tokens[i]));
                parent.right=right;
                q.add(right);
            }
            i++;
        }
        return root;
    }
}