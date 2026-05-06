class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       //we need the frequent elements, means we need the count
       HashMap<Integer, Integer> map = new HashMap<>();
       for(int i = 0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
       }

       List<Integer>[] bucket = new List[nums.length+1];

       for(int num : map.keySet()){
            int freq = map.get(num);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
       }

        int res[] = new int[k];
        int index = 0;
       for(int i = bucket.length - 1; i>= 0; i--){
            if(bucket[i] != null){
                for(int num : bucket[i]){
                    res[index++] = num;
                    if(index == k) return res;
                }
            }
            
       }

       return res;
    }
}



//  HashMap<Integer, Integer> map = new HashMap<>();
//         for(int i = 0; i<nums.length; i++){
//             map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//         }
//         // compares the values and order it in dsec order (max heap)
//         PriorityQueue<Integer> pq = new PriorityQueue<>(
//             (a,b) -> map.get(b) - map.get(a)
//         );

//         pq.addAll(map.keySet());    //pass

//         int count = 0;
//         int res[] = new int[k];
//         while(!pq.isEmpty() && count < k){
//             int curr = pq.poll();
//             res[count++] = curr;
//         }

//         return res;