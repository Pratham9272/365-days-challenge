class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result=new ArrayList<>();
        if(n<=0) return result;
        if(n==1){
            result.add(0);
            return result;
        }
        List<Set<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new HashSet<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        List<Integer> leaves=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(graph.get(i).size()==1){
                leaves.add(i);
            }
        }
        while(n>2){
            n-=leaves.size();
            List<Integer> newLeaves=new ArrayList<>();
            for(int leaf:leaves){
                int neighbor=graph.get(leaf).iterator().next();
                graph.get(neighbor).remove(leaf);
                if(graph.get(neighbor).size()==1){
                    newLeaves.add(neighbor);
                }
            }
            leaves=newLeaves;
        }
        result.addAll(leaves);
        return result;
    }
}