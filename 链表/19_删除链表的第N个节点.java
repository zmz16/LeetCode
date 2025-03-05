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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        
        while (cur != null) {
        	stack.push(cur);
        	cur = cur.next;
        }
        
        for (int i = 0; i < n; i++) {
        	stack.pop();
        }
        
        ListNode pre = stack.peek();
        pre.next = pre.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}