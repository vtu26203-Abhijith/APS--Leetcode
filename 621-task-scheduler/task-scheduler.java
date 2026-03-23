class Solution {
    public int leastInterval(char[] tasks, int n) {
        int total_task=tasks.length;
        int[] arr=new int[26];
        for(char ch:tasks){
            arr[ch-'A']++;
        }
        List<Integer> li=new ArrayList<>();
        for(int x:arr){
            if(x!=0){
                li.add(x);
            }
        }
        Collections.sort(li,(a,b)->b-a);
        int spot=li.get(0)-1;
        int idle_spot=spot*n;
        for(int i=1;i<li.size();i++){
            if(idle_spot<=0){
                return total_task;
            }
            idle_spot-=Math.min(spot,li.get(i));
        }
        return idle_spot+total_task;
    }
}