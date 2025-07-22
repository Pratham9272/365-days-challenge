class Solution {
    public int maxDistance(int[][] grid) {
        int n=grid.length;
        Queue<int[]> queue=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    queue.offer(new int[] {i,j});
                }
            }
        }
        if(queue.isEmpty() || queue.size()==n*n) return -1;
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
        int maxDist=-1;

        while(!queue.isEmpty()){
            int[] cell=queue.poll();
            int x=cell[0], y=cell[1];

            for(int[] dir:directions){
                int newX=x+dir[0],newY=y+dir[1];
                if(newX >= 0 && newY >= 0 && newX<n && newY<n && grid[newX][newY]==0){
                    grid[newX][newY]=grid[x][y]+1;
                    maxDist=Math.max(maxDist,grid[newX][newY]);
                    queue.offer(new int[]{newX,newY});
                }
            } 
        }
        return maxDist-1;
    }
}