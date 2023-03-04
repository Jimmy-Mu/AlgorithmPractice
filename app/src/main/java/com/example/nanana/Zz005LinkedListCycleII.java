package com.example.nanana;

/**
 * 题目描述
 * 给定一个链表，如果有环路，找出环路的开始点。
 * <p>
 * 输入输出样例
 * 输入是一个链表，输出是链表的一个节点。如果没有环路，返回一个空指针。
 *
 * @see ListNode
 * <p>
 * 对于链表找环路的问题，有一个通用的解法——快慢指针(Floyd 判圈法)。
 * 给定两个指针， 分别命名为 slow 和 fast，起始位置在链表的开头。
 * 每次 fast 前进两步，slow 前进一步。如果 fast 可以走到尽头，那么说明没有环路;
 * 如果 fast 可以无限走下去，那么说明一定有环路，且一定存在一个时刻 slow 和 fast 相遇。
 * 当 slow 和 fast 第一次相遇时，我们将 fast 重新移动到链表开头，并 让 slow 和 fast 每次都前进一步。
 * 当 slow 和 fast 第二次相遇时，相遇的节点即为环路的开始点。
 */
public class Zz005LinkedListCycleII {

    private ListNode root;

    public Zz005LinkedListCycleII(ListNode root) {
        this.root = root;
    }

    public ListNode circleStartNode() {
        ListNode slow = root;
        ListNode fast = root;

        while (fast.next != null) {
            if (fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                fast = root;
                break;
            }
        }
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
