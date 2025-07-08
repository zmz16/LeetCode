# 题目链接

https://leetcode.cn/problems/intersection-of-two-linked-lists/description/

## Java

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
        	return null;
        }
        
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
        	pA = (pA == null ? headB : pA.next);
        	pB = (pB == null ? headA : pB.next);
        }
        
        return pA;
    }
}
```

## C++

```C++
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode * p = headA;
        ListNode * q = headB;
        while (p != q) {
            p = p != nullptr ? p->next : headB;
            q = q != nullptr ? q->next : headA;
        }
        return p;
    }
};
```
