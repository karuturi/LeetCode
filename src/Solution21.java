/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */

public class Solution21 {
    public static void main(String[] args) {
        // ListNode l1 = createList(new int[]{1,3,4});
        // ListNode l2 = createList(new int[]{1,2,4});

        ListNode l1 = ListNode.createList(new int[] { 1, 3, 4 });
        ListNode l2 = ListNode.createList(new int[] { 1, 2, 4, 5 });

        // ListNode l1 = createList(new int[]{});
        // ListNode l2 = createList(new int[]{1,2,4,5});

        // ListNode l1 = createList(new int[]{});
        // ListNode l2 = createList(new int[]{});

        ListNode l = new Solution21().mergeTwoLists(l1, l2);
        ListNode.printList(l);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        }

        if (l2 != null) {
            current.next = l2;
        }
        return dummy.next;

    }

}
