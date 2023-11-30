package com.whj.LeetCode;

import java.util.*;

/**
 * @Author JieSir
 * @Date 2023/10/17 10:32
 * @Version 1.0
 */

public class Test11 {

    public static void main(String[] args) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode listNode1 = new ListNode(1, null);
        visited.add(listNode1);
        visited.add(new ListNode(2,null));
        visited.add(listNode1);
        for (ListNode listNode : visited) {
            if (visited.contains(listNode)) {
                System.out.println(listNode.val);
            }
        }
        System.out.println(visited);
    }

    /**
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();

        ListNode curA = headA;
        ListNode curB = headB;
        List<ListNode> nodeList = new ArrayList<>();
        while (curA.next != null) {
            nodeList.add(curA);
            curA = curA.next;
        }
        for (ListNode listNode : nodeList) {
            while (curB.next != null) {
                if (listNode == curB && listNode.val == curB.val) {
                    return curB;
                } else {
                    curB = curB.next;
                }

            }
        }
        return null;
    }
}
