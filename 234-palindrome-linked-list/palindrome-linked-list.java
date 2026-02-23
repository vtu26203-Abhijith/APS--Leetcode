class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
        int i = 0, j = values.size() - 1;
        while (i < j) {
            if (!values.get(i).equals(values.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}