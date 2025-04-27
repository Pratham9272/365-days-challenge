class Solution {
  public:
      TreeNode* prev = nullptr;
      int count = 0, maxCount = 0;
      vector<int> modes;
  
      void inorder(TreeNode* node) {
          if (!node) return;
          inorder(node->left);
          if (prev && prev->val == node->val) count++;
          else count = 1;
          if (count > maxCount) {
              maxCount = count;
              modes = {node->val};
          } else if (count == maxCount) {
              modes.push_back(node->val);
          }
          prev = node;
          inorder(node->right);
      }
  
      vector<int> findMode(TreeNode* root) {
          inorder(root);
          return modes;
      }
  };
  