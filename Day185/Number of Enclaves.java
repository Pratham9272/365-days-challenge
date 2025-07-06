class Solution {
    public int numEnclaves(int[][] grid) {
        int rows=grid.length, cols=grid[0].length;
        for(int i=0;i<rows;i++){
            if(grid[i][0]==1) dfs(grid,i,0);
            if(grid[i][cols-1]==1) dfs(grid,i,cols-1);
        }
        for(int j=0;j<cols;j++){
            if(grid[0][j]==1) dfs(grid,0,j);
            if(grid[rows-1][j]==1) dfs(grid,rows-1,j);
        }
        int count=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1) count++;
            }
        }
        return count;
    }
    private void dfs(int[][] grid,int r,int c){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]!=1) return;
        grid[r][c]=0;
        dfs(grid,r+1,c);
        dfs(grid,r-1,c);
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);
    }
}