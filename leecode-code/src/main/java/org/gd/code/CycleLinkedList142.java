package org.gd.code;

import org.gd.code.DeleteNode237.ListNode;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 说明：不允许修改给定的链表。

 示例 1：
 输入：head = [3,2,0,-4], pos = 1
 输出：tail connects to node index 1
 解释：链表中有一个环，其尾部连接到第二个节点。

 示例 2：
 输入：head = [1,2], pos = 0
 输出：tail connects to node index 0
 解释：链表中有一个环，其尾部连接到第一个节点。

 示例 3：
 输入：head = [1], pos = -1
 输出：no cycle
 解释：链表中没有环。
 */
public class CycleLinkedList142 {
    /**
     * 假设链表的起始节点为 A，环的入口节点为 B，两个指针（快慢指针） 相交节点为 C，AB 两点之间的长度为 x，BC 两点之间的长度为 y，
     * CB 两点之间的长度为 z。慢指针 slow 走过的长度为 x+y， 快指针
     * fast 为了“赶上”慢指针，应该走过的长度为 x+y+z+y，同时，由于快指针的速度是慢指针的两倍，因此相同时间内，快指针走过的路程
     * 应该是慢指针（走过的路程）的两倍. 2(x+y)=x+y+z+y ->x = z
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null|| head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while(slow !=null && fast != null){
            if(fast.next == null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }
        if(slow == null || fast==null)
            return null;
        //相遇后快指针回到头并且一次走一步
        fast = head;
        while (slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }

    public static void main(String[] args) {

    }
}
