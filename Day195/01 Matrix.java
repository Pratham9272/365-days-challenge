class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length, n=mat[0].length;
        int[][] dist=new int[m][n];
        boolean[][] visited=new boolean[m][n];
        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    visited[i][j]=true;
                    q.offer(new int[]{i,j});
                }
            }
        }

        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] cell=q.poll();
            for(int[] d:dirs){
                int ni=cell[0]+d[0],nj=cell[1]+d[1];
                if(ni>=0 && nj>=0 && ni<m && nj<n && !visited[ni][nj]){
                    dist[ni][nj]=dist[cell[0]][cell[1]]+1;
                    visited[ni][nj]=true;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
        return dist;
    }
}