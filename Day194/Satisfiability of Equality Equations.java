class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] parent=new int[26];
        for(int i=0;i<26;i++) parent[i]=i;

        for(String eq:equations){
            if(eq.charAt(1)=='='){
                union(parent,eq.charAt(0)-'a',eq.charAt(3)-'a');
            }
        }

        for(String eq:equations){
            if(eq.charAt(1)=='!'){
                if(find(parent,eq.charAt(0)-'a')==find(parent,eq.charAt(3)-'a')){
                    return false;
                }
            }
        }
        return true;
    }
    private int find(int[] parent,int x){
        return parent[x]==x ? x:(parent[x]=find(parent,parent[x]));
    }
    private void union(int[] parent,int a,int b){
        parent[find(parent,a)]=find(parent,b);
    }
}