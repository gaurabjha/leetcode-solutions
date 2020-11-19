//Question : https://leetcode.com/problems/add-two-numbers/

import java.util.Objects;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new Solution();

        //ListNode inputOne = new ListNode(2, new ListNode(4, new ListNode(3)));
        //ListNode inputTwo = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode inputOne ;//= new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode inputTwo ;//= new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

        inputOne = new ListNode(2, new ListNode(4 , new ListNode(3)));
        inputTwo = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode returnNumber = solution.addTwoNumbers(inputOne, inputTwo);
        System.out.println("============================================================================================================");

        if (Objects.nonNull(returnNumber)) {
            System.out.print(returnNumber.val);
            while (Objects.nonNull(returnNumber.next)) {
                returnNumber = returnNumber.next;
                System.out.print(", " + returnNumber.val);
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
        return addTwoNumbers(l1, l2, 0);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int remainder) {
        l1 = Objects.nonNull(l1) ? l1 : new ListNode();
        l2 = Objects.nonNull(l2) ? l2 : new ListNode();
        ListNode answer = new ListNode();
        int sum;
        sum = l1.val + l2.val + remainder;
        if (sum > 9) {
            remainder = sum / 10;
            sum = sum % 10;
        }
        else
            remainder = 0;
        answer.val = sum;
        ListNode returnNumber = answer;
        if (Objects.nonNull(returnNumber)) {
            while (Objects.nonNull(returnNumber.next)) {
                returnNumber = returnNumber.next;
            }
        }
        if (Objects.nonNull(l1.next) || Objects.nonNull(l2.next)) {
            answer.next = addTwoNumbers(l1.next, l2.next, remainder);
        } else if (remainder > 0) {
            answer.next = new ListNode(remainder);
        }
        return answer;
    }
}