# 题目链接

https://leetcode.cn/problems/swap-nodes-in-pairs/

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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        
        while (temp.next != null && temp.next.next != null) {
			ListNode node1 = temp.next;
			ListNode node2 = temp.next.next;
			temp.next = node2;
			node1.next = node2.next;
			node2.next = node1;
			temp = node1;
		}
        return dummy.next;
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
    ListNode* swapPairs(ListNode* head) {
        ListNode * dummyNode = new ListNode(-1);
        dummyNode->next = head;
        ListNode * curr = dummyNode;

        while (curr->next != nullptr && curr->next->next != nullptr) {
            ListNode * temp = curr->next;
            ListNode * temp1 = curr->next->next->next;

            curr->next = curr->next->next;
            curr->next->next = temp;
            temp->next = temp1;
            curr = curr->next->next;
        }
        
        return dummyNode->next;
    }
};
```
