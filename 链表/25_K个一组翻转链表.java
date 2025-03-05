/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
    	if (head == null) {
    		return null;
    	}
    	
    	ListNode pre = head, index = head.next;
    	int m = 0;
    	while (++m < k && index != null) {
    		pre.next = index.next;
    		index.next = head;
    		head = index;
    		index = pre.next;
    	}
    	
    	if (m < k) {
    		return reverseKGroup(head, m);
    	}
    	
    	pre.next = reverseKGroup(index, k);
    	
    	return head;
    }
}