package leetcode;

public class AddTwoNumbers {
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode();
        ListNode head = curr;
        int carry = 0;
        int num;
        while (l1 != null && l2 != null) {
            num = l1.val + l2.val + carry;
            curr.val = num % 10;
            carry = num / 10;
            curr.next = new ListNode();
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            num = l1.val + carry;
            curr.val = num % 10;
            carry = num / 10;
            curr.next = new ListNode();
            curr = curr.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            num = l2.val + carry;
            curr.val = num % 10;
            carry = num / 10;
            curr.next = new ListNode();
            curr = curr.next;
            l2 = l2.next;
        }
        if (carry == 0) {
            curr = null;
        } else {
            curr.val = 1;
        }
        return head;
    }
}