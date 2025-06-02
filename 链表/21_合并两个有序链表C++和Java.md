## 题目链接

https://leetcode.cn/problems/merge-two-sorted-lists/

## 思路

创建一个哨兵节点，作为合并后的新链表头节点的前一个节点。这样可以避免单独处理头节点，也无需特判链表为空的情况，从而简化代码。

比较 ``list1``和 ``list2``的节点值，如果 ``list1``的节点值小，则把 ``list1``加到新链表的末尾，然后把 ``list1``替换成它的下一个节点。如果 ``list2``的节点值小则同理。如果两个节点值一样，那么把谁加到新链表的末尾都是一样的，不妨规定把 ``list2``加到新链表末尾。

重复上述过程，直到其中一个链表为空。

循环结束后，其中一个链表可能还有剩余的节点，将剩余部分加到新链表的末尾。

最后，返回新链表的头节点，即哨兵节点的下一个节点。

作者：灵茶山艾府
链接：https://leetcode.cn/problems/merge-two-sorted-lists/solutions/2373691/liang-chong-fang-fa-die-dai-di-gui-pytho-wf75/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    	ListNode prehead = new ListNode(-1);
    	
    	ListNode pre = prehead;
        while (list1 != null && list2 != null) {
        	if (list1.val <= list2.val) {
        		pre.next = list1;
        		list1 = list1.next;
        	}
        	else {
				pre.next = list2;
				list2 = list2.next;
			}
        	pre = pre.next;
        }
        
        pre.next = list1 == null ? list2 : list1;
        
        return prehead.next;
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
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        ListNode *new_head = new ListNode(-1);
        ListNode *pre = new_head;

        while (list1 && list2) {
            if (list1->val <= list2->val) {
                pre->next = list1;
                list1 = list1->next;
            }
            else {
                pre->next = list2;
                list2 = list2->next;
            }
            pre = pre->next;
        }

        pre->next = list1 == nullptr ? list2 : list1;

        return new_head->next;
    }
};
```
