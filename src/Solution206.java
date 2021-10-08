/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class Solution206 {
    public static void main(String[] args) {
        // ListNode l = ListNode.createList(new int[]{});
        // ListNode l = ListNode.createList(new int[]{1,2,3,4});
        // ListNode l = ListNode.createList(new int[]{1});
        ListNode l = ListNode.createList(new int[] { 1, 2 });

        ListNode reversed = new Solution206().reverseList(l);
        ListNode.printList(reversed);
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode list = head;
        while (list != null) {
            ListNode current = list.next;
            list.next = prev;
            prev = list;
            list = current;
        }
        return prev;
    }
}
