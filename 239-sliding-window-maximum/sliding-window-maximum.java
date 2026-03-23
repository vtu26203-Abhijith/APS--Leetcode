class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int ind = 0;

        for(int i = 0; i < n; i++)
        {
            while(!dq.isEmpty() && i - dq.peekFirst() >= k)
            {
                dq.removeFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
            {
                dq.removeLast();
            }

            dq.addLast(i);

            if(i - k + 1 >= 0)
            {
                res[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return res;
    }
}