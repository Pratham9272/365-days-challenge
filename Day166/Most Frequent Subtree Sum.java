class Solution {
    private Map<Integer,Integer>countMap=new HashMap<>();
    private int maxCount=0;

    public int[] findFrequentTreeSum(TreeNode root){
        postOrder(root);
        List<Integer> result=new ArrayList<>();
        for(int sum:countMap.keySet()){
            if(countMap.get(sum)==maxCount){
                result.add(sum);
            }
        }
        int[] res=new int[result.size()];
        for(int i=0;i<result.size();i++){
            res[i]=result.get(i);
        }
        return res;
    }

    private int postOrder(TreeNode node){
        if(node==null) return 0;
        int left=postOrder(node.left);
        int right=postOrder(node.right);
        int sum=node.val+left+right;
        countMap.put(sum,countMap.getOrDefault(sum,0)+1);
        maxCount=Math.max(maxCount,countMap.get(sum));
        return sum;
    }
}
