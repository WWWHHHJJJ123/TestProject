package com.whj.LeetCode;

import java.util.*;

/**
 * @Author JieSir
 * @Date 2023/10/11 10:30
 * @Version 1.0
 */

public class Test10 {
    List<ListNode> list = new ArrayList();
    public ListNode reverseList(ListNode head) {
        if(head == null){
            ListNode result = new ListNode();
            result.next = head;
            for(int i=list.size();i>list.size();i--){
                result.next=result.next.next;
            }

            return result;
        }else{
            list.add(head);
            reverseList(head.next);
        }
        return null;
    }
}
