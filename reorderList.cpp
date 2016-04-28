/**
 * Definition of ListNode
 * class ListNode {
 * public:
 *     int val;
 *     ListNode *next;
 *     ListNode(int val) {
 *         this->val = val;
 *         this->next = NULL;
 *     }
 * }
 */
class Solution {
public:
    /**
     * @param head: The first node of linked list.
     * @return: void
     */
    void reorderList(ListNode *head) {
        if (head == NULL) {
            return;
        }
        ListNode *head2 = findMiddle(head);
        ListNode *tail2 = head2->next;
        tail2 = reverse(tail2);
        head2->next = NULL;
        ListNode *tail1 = head;
        
        int count = 1;
        ListNode *dummy = new ListNode(0);
        ListNode *tail = dummy;
        while (tail1 != NULL && tail2 != NULL) {
        	if (count % 2 != 0) {
        		tail->next = tail1;
        		tail1 = tail1->next;
        		tail = tail->next;
        		++count;
        	} else {
        		tail->next = tail2;
        		tail2 = tail2->next;
        		tail = tail->next;
        		++count;
        	}
        }
        if (tail1 != NULL) {
        	tail->next = tail1;
        } else {
        	tail->next = tail2;
        }
    }

    ListNode* reverse(ListNode *head) {
    	if (head == NULL || head->next == NULL) {
    		return head;
    	}
    	ListNode *newHead = NULL;
    	while (head) {
    		ListNode *temp = head->next;
    		head->next = newHead;
    		newHead =  head;
    		head = temp;
    	}
    	return newHead;
    }

    ListNode* findMiddle(ListNode *head) {
    	if (head == NULL || head->next == NULL) {
    		return head;
    	}
    	ListNode *slow = head;
    	ListNode *fast = head->next;
    	while (fast != NULL && fast->next != NULL) {
    		slow = slow->next;
    		fast = fast->next->next;
    	}
    	return slow;
    }

};


