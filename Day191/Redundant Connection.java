class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent=new int[1001];
        for(int i=0;i<parent.length;i++) parent[i]=i;
        for(int[] edge:edges){
            int u=edge[0],v=edge[1];
            if(find(parent,u)==find(parent,v)) return edge;
            union(parent,u,v);
        }
        return new int[0];
    }
    private int find(int[] parent,int x){
        if(parent[x]!=x) parent[x]=find(parent,parent[x]);
        return parent[x];
    }
    private void union(int[] parent,int x,int y){
        parent[find(parent,x)]=find(parent,y);
    }
}