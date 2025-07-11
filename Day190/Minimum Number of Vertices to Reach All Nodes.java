class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] isComing=new boolean[n];
        for(List<Integer> edge:edges){
            isComing[edge.get(1)]=true;
        }
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!isComing[i]) result.add(i);
        }
        return result;
    }
}