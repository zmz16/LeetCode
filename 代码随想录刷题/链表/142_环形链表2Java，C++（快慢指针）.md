# 题目链接

https://leetcode.cn/problems/linked-list-cycle-ii/description/

## Java

```java
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
```

## C++

```C++
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        ListNode * slow = head;;
        ListNode * fast = head;

        while (fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
            if (fast == slow) {
                while (slow != head) {
                    slow = slow->next;
                    head = head->next;
                }
                return slow;
            }
        }
        return nullptr;
    }
};
```

