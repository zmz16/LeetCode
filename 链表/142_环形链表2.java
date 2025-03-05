/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        HashSet<ListNode> visit = new HashSet<ListNode>();
        
        while (pos != null) {
        	if (visit.contains(pos)) {
        		return pos;
        	}
        	else {
        		visit.add(pos);
        	}

            pos = pos.next;
        }
        
        return null;
    }
}