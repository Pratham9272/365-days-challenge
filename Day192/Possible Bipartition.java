class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++) graph.add(new ArrayList<>());
        for(int[] d:dislikes){
            graph.get(d[0]).add(d[1]);
            graph.get(d[1]).add(d[0]);
        }
        int[] color=new int[n+1];
        for(int i=1;i<=n;i++){
            if(color[i]==0 && !dfs(graph,color,i,1)) return false;
        }
        return true;
    }
    private boolean dfs(List<List<Integer>> graph,int[] color,int node,int c){
        color[node]=c;
        for(int neighbor:graph.get(node)){
            if(color[neighbor]==c) return false;
            if(color[neighbor]==0 && !dfs(graph,color,neighbor,-c)) return false;
        }
        return true;
    }
}