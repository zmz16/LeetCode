# 题目链接

https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/

## Java

```java
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
```

## C++

```C++
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode * dummyNode = new ListNode(-1);
        dummyNode->next = head;
        ListNode * fast = dummyNode;
        ListNode * slow = dummyNode;

        while (n--) {
            fast = fast->next;
        }
        while (fast->next != nullptr) {
            slow = slow->next;
            fast = fast->next;
        }
        ListNode * del = slow->next;
        slow->next = slow->next->next;
        delete del;

        return dummyNode->next;
    }
};
```

- 时间复杂度: O(n)
- 空间复杂度: O(1)
