package _201__250._203;

import _1__50._2.ListNode;
import org.junit.Test;

public class Demo01 {

    @Test
    public void test() {
        System.out.println(removeElements(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1)))), 2));
        System.out.println(removeElements(new ListNode(1), 1));
        System.out.println(removeElements(new ListNode(1,
                new ListNode(2, new ListNode(6, new ListNode(3)))), 6));
    }


    private ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val)
            head = head.next;
        ListNode tmp = head;
        while (tmp != null && tmp.next != null)
            if (tmp.next.val == val) tmp.next = tmp.next.next;
            else tmp = tmp.next;
        return head;
    }
}
