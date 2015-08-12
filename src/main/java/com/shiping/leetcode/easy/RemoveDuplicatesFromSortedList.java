package com.shiping.leetcode.easy;

import com.shiping.leetcode.util.ListNode;

public class RemoveDuplicatesFromSortedList {
	
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) return head;
		ListNode cur = head, pre = head;
		int v = cur.val;
		cur = cur.next;
		while(cur != null) {
			if(cur.val == v) {
				pre.next = cur.next;
			}
			else {
				v = cur.val;
				pre = pre.next;
			}
			cur = cur.next;
		}
		return head;
	}

}
