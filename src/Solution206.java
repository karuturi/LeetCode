/**
 * https://leetcode.com/problems/reverse-linked-list/ 
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        
        ListNode prev = null;
		ListNode list = head;
		while( list != null) {
			ListNode current = list.next;
            list.next = prev;
            prev = list;
            list = current;
		}
		return prev;
    }
}
