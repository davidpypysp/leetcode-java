package com.shiping.leetcode.hard;

import com.shiping.leetcode.util.ListNode;

/**
 * Created by shipingci on 7/25/16.
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        int l = 0, r = lists.length;
        return mergeK(lists, l, r);



    }

    public ListNode mergeK(ListNode[] lists, int l, int r) {
        if(l == r-1) return lists[l];
        int mid = (l+r) / 2;
        ListNode listL = mergeK(lists, l, mid);
        ListNode listR = mergeK(lists, mid, r);
        return merge2Lists(listL, listR);

    }

    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        ListNode pre = null;
        while(true) {
            ListNode node = new ListNode(0);
            if(l1 != null && l2 != null) {
                if(l1.val < l2.val) {
                    node.val = l1.val;
                    l1 = l1.next;
                } else {
                    node.val = l2.val;
                    l2 = l2.next;
                }

            } else if(l1 != null && l2 == null) {
                node.val = l1.val;
                l1 = l1.next;

            } else if(l1 ==null && l2 != null) {
                node.val = l2.val;
                l2 = l2.next;

            } else {
                break;
            }

            if(pre == null) {
                pre = node;
                l3 = pre;
            }
            else {
                pre.next = node;
                pre = node;
            }
        }
        return l3;
    }



}
