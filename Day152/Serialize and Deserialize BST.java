public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString().trim();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root==null) return;
        sb.append(root.val).append(" ");
        serializeHelper(root.left,sb);
        serializeHelper(root.right,sb);
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] values=data.split(" ");
        int[] index=new int[1];
        return buildTree(values,index,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private TreeNode buildTree(String[] values, int[] index, int min, int max) {
        if (index[0]==values.length) return null;
        int val = Integer.parseInt(values[index[0]]);
        if (val < min || val > max) return null;

        TreeNode root = new TreeNode(val);
        index[0]++;
        root.left = buildTree(values, index, min, val);
        root.right = buildTree(values, index, val, max);
        return root;
    }
}
