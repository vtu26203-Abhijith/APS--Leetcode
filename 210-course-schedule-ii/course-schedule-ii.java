class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        for(int i = 0; i<numCourses; i++){
            if(inDeg[i] == 0){
                queue.offer(i);
            }
        }
        int res[] = new int[numCourses];
        int count = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            res[count++] = curr;
            for(int neigh : adj.get(curr)){
                inDeg[neigh]--;
                if(inDeg[neigh] == 0){
                    queue.offer(neigh);
                }
            }
        }

        return count == numCourses ? res : new int[]{};
    }
}