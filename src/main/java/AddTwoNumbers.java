//Question : https://leetcode.com/problems/add-two-numbers/

import java.util.Objects;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode inputOne = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode inputTwo = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode returnNumber = solution.addTwoNumbers(inputOne, inputTwo);

        if(Objects.nonNull(returnNumber)){
            System.out.println(returnNumber.val);
            while(Objects.nonNull(returnNumber.next)){
                returnNumber = returnNumber.next;
                System.out.println(returnNumber.val);
            }
        }
    }
}

//  Definition for singly-linked list.
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
        return new ListNode();
    }
}