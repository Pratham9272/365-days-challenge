class TreeNode {
  int val;
  TreeNode left, right;
  TreeNode(int x) { val = x; }
}

class Solution {
  private Map<Integer, Integer> inorderIndexMap;
  private int postIndex;

  public TreeNode buildTree(int[] inorder, int[] postorder) {
      inorderIndexMap = new HashMap<>();
      postIndex = postorder.length - 1;
      for (int i = 0; i < inorder.length; i++) {
          inorderIndexMap.put(inorder[i], i);
      }
      return build(inorder, postorder, 0, inorder.length - 1);
  }

  private TreeNode build(int[] inorder, int[] postorder, int inStart, int inEnd) {
      if (inStart > inEnd) return null;

      int rootVal = postorder[postIndex--];
      TreeNode root = new TreeNode(rootVal);
      int inIndex = inorderIndexMap.get(rootVal);
      root.right = build(inorder, postorder, inIndex + 1, inEnd);
      root.left = build(inorder, postorder, inStart, inIndex - 1);

      return root;
  }
}