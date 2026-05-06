class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        int[] inDeg = new int[numCourses];
        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];

            adj.get(v).add(u);
            inDeg[u]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i<inDeg.length; i++){
            if(inDeg[i] == 0){
                //add in queue
                queue.offer(i);
            }
        }
        int completed = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            completed++;
            for(int neigh : adj.get(curr)){
                inDeg[neigh]--;
                if(inDeg[neigh] == 0){
                    queue.offer(neigh);
                }
            }
        }

    return completed == numCourses;
    }
}