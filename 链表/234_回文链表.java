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
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        ListNode currNode = head;
        while (currNode != null) {
        	list.add(currNode.val);
        	currNode = currNode.next;
        }
        
        int l = 0, r = list.size() - 1;
        while (l < r) {
			if (list.get(l) != list.get(r)) {
				return false;
			}
			l++;
			r--;
		}
        
        return true;
    }
}