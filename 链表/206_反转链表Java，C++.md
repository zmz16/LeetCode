# 题目链接

https://leetcode.cn/problems/reverse-linked-list/description/

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
	public ListNode reverseList(ListNode head) {
		ListNode pre = null, curr = head;
		ListNode next = null;
		
		while (curr != null) {
			next = curr.next;
			curr.next = pre;
            pre = curr;
			curr = next;
		}
		
		return pre;
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
    ListNode* reverseList(ListNode* head) {
        ListNode * curr = head;
        ListNode * pre = nullptr;

        while (curr != nullptr) {
            ListNode * next_temp = curr->next;
            curr->next = pre;
            pre = curr;
            curr = next_temp;
        }

        return pre;
    }
};
```

- 时间复杂度: O(n)
- 空间复杂度: O(1)
