package com.shiping.leetcode.easy;

import com.shiping.leetcode.util.ListNode;

public class RemoveNthNodeFromEndOfList {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head.next == null) return null;
		ListNode cur = head;
		int cnt = 0;
		while(cur != null) {
			cur = cur.next;
			cnt++;
		}
		cnt = cnt - n;
		cur = head;
		ListNode pre = new ListNode(0);
		pre.next = head;
		for(int i = 0; i < cnt; i++) {
			pre = cur;
			cur = cur.next;
		}
		if(pre.next == head) {
			return head.next;
		}
		pre.next = pre.next.next;
		return head;
	}

}
