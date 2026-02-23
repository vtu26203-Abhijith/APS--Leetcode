class Solution {
    int n1;
    int n2;

    // Next Greater Element to the Right for nums2
    public int[] getNGR(int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] NGR = new int[n2];

        for (int i = n2 - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] >= nums2[stack.peek()]) {
                stack.pop();
            }

            NGR[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return NGR;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        n1 = nums1.length;
        n2 = nums2.length;

        int[] NGR = getNGR(nums2);
        Map<Integer, Integer> map = new HashMap<>();

        // Map each element in nums2 to its next greater element
        for (int i = 0; i < n2; i++) {
            if (NGR[i] == -1) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], nums2[NGR[i]]);
            }
        }

        // Build result for nums1
        int[] result = new int[n1];
        for (int i = 0; i < n1; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}