class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);
        for(int i=1;i<n;i++){
            if(color[i]==-1 && !dfs(graph,color,i,0)){
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int[][] graph,int[] color,int node,int c){
        color[node]=c;
        for(int neighbor:graph[node]){
            if(color[neighbor]==-1){
                if(!dfs(graph,color,neighbor,1-c)) return false;
            }else if(color[neighbor]==c){
                return false;
            }
        }
        return true;
    }
}