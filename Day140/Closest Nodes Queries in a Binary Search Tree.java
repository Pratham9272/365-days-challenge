class Solution {
    public List<List<Integer>> closestNodes(TreeNode root,List<Integer> queries) {
        List<Integer> inorderList=new ArrayList<>();
        inorderTraversal(root,inorderList);

        List<List<Integer>> result=new ArrayList<>();

        for (int query:queries) {
            int large=findLarge(inorderList,query);
            int small=findSmall(inorderList,query);
            result.add(Arrays.asList(large,small));
        }
        return result;
    }

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if(root==null) return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    private int findLarge(List<Integer> list, int target) {
        int left=0,right=list.size()-1;
        int ans=-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(list.get(mid)<=target) {
                ans=list.get(mid);
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return ans;
    }

    private int findSmall(List<Integer> list, int target) {
        int left=0,right=list.size()-1;
        int ans=-1;
        while(left<=right) {
            int mid=(left+right)/2;
            if(list.get(mid)>=target) {
                ans=list.get(mid);
                right=mid - 1;
            }else{
                left=mid + 1;
            }
        }
        return ans;
    }
}