# 题目链接

https://leetcode.cn/problems/reverse-linked-list/description/

## Java

```java
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
