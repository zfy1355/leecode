package org.gd.code;

/*
给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL
示例 2:

输入: 0->1->2->NULL, k = 4
输出: 2->0->1->NULL
解释:
向右旋转 1 步: 2->0->1->NULL
向右旋转 2 步: 1->2->0->NULL
向右旋转 3 步: 0->1->2->NULL
向右旋转 4 步: 2->0->1->NULL
 */
public class RotateRight61 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = rotateRight(node1,2);
        System.out.println(node);
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || k==0)
            return head;
        ListNode tempHead =head;
        ListNode oldHead = head;
        int len = 1;
        while(tempHead.next != null){
            len++;
            tempHead = tempHead.next;
        }
        k = len- k%len;
        int i =0;
        tempHead.next = head;
        ListNode res =null;
        while(oldHead.next != null){
            if (i == k-1) {
                res = oldHead.next;
                oldHead.next = null;
                break;
            }
            oldHead = oldHead.next;
            i++;
        }

        return res;
    }

     public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
