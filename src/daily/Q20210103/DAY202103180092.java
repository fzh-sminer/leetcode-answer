package daily.Q20210103;

/**
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class DAY202103180092 {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode h = new ListNode();
        h.next = head;
        head = h;
        ListNode p = head.next, t;
        int idx = 1;

        while (p != null && idx < left) {
            h = p;
            p = p.next;
            idx++;
        }

        while (p != null && idx < right) {
            t = p.next;
            p.next = t.next;
            t.next = h.next;
            h.next = t;
            idx++;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 2; i <= 5; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }

        head = new DAY202103180092().reverseBetween(head, 2, 3);

        p = head;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

}
