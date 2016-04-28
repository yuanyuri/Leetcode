/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;      
 *     }
 * }
 */
public class Solution {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
        	return null;
        }
        if (l1 == null) {
        	return l2;
        }
        if (l2 == null) {
        	return l1;
        }
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode head = addLists(l1, l2);
        head = reverse(head);
        return head;
    }

    private ListNode reverse(ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
    	ListNode pre = null;
    	while (head != null) {
    		ListNode temp = head.next;
    		head.next = pre;
    		pre = head;
    		head = temp;
    	}
    	return pre;
    }

    private ListNode addLists(ListNode l1, ListNode l2) {
    	int carry = 0;
    	ListNode dummy = new ListNode(0);
    	ListNode tail = dummy;
    	while (l1 != null && l2 != null) {
    		int val = l1.val + l2.val + carry;
    		tail.next = new ListNode(val % 10);
    		carry = val / 10;
    		l1 = l1.next;
    		l2 = l2.next;
    		tail = tail.next;
    	}
    	while(l1 != null) {
    		int val = l1.val + carry;
    		tail.next = new ListNode(val % 10);
    		carry = val / 10;
    		tail = tail.next;
    	}

    	while (l2 != null) {
    		int val = l2.val + carry;
    		tail.next = new ListNode(val % 10);
    		carry = val / 10;
    		tail = tail.next;
    	}
    	if (carry != 0) {
    		tail.next = new ListNode(carry);
    		tail = tail.next;
    	}
    	return dummy.next;
    }  
}