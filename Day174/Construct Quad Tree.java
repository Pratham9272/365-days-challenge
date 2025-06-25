class Solution {
    public Node construct(int[][] grid) {
        return build(grid,0,0,grid.length);
    }
    private Node build(int[][] grid,int row,int col,int size){
        if(isUniform(grid,row,col,size)){
            return new Node(grid[row][col]==1,true);
        }
        int newSize=size/2;
        Node topLeft=build(grid,row,col,newSize);
        Node topRight=build(grid,row,col+newSize,newSize);
        Node bottomLeft=build(grid,row+newSize,col,newSize);
        Node bottomRight=build(grid,row+newSize,col+newSize,newSize);
        return new Node(false,false,topLeft,topRight,bottomLeft,bottomRight);
    }
    private boolean isUniform(int[][] grid,int row,int col,int size){
        int val=grid[row][col];
        for(int i=row;i<row+size;i++){
            for(int j=col;j<col+size;j++){
                if(grid[i][j]!=val) return false;
            }
        }
        return true;
    }
}