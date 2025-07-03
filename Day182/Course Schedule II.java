class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            graph.get(pre[1]).add(pre[0]);
        }
        int[] visited=new int[numCourses];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<numCourses;i++){
            if(hasCycle(graph,visited,i,stack)) return new int[0];
        }
        int[] order=new int[numCourses];
        int index=0;
        while(!stack.isEmpty()){
            order[index++]=stack.pop();
        }
        return order;
    }
    private boolean hasCycle(List<List<Integer>> graph,int[] visited,int course,Stack<Integer> stack){
        if(visited[course]==1) return true;
        if(visited[course]==2) return false;
        visited[course]=1;
        for(int neighbor:graph.get(course)){
            if(hasCycle(graph,visited,neighbor,stack)) return true;
        }
        visited[course]=2;
        stack.push(course);
        return false;
    }
}