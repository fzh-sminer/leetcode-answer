package base;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class BASE0019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (n == 0 || head == null) {
            return head;
        }

        head = new ListNode(0, head);

        ListNode cur = head.next;
        ListNode pre = head;

        int idx = 1;

        while (cur != null && idx < n) {
            idx++;
            cur = cur.next;
        }

        if (cur == null) {
            return head.next;
        }

        while (cur.next != null) {
            cur = cur.next;
            pre = pre.next;
        }

        if (pre.next != null) {
            pre.next = pre.next.next;
        }

        return head.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,3,4,5};

        ListNode head = new ListNode(1);
        ListNode node = head;

        for (int n : nums) {
            node.next = new ListNode(n);
            node = node.next;
        }

        head = new BASE0019().removeNthFromEnd(head, 6);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
