package com.shiping.leetcode.easy;

import com.shiping.leetcode.util.ListNode;

public class RemoveLinkedListElements {
	
	public ListNode removeElements(ListNode head, int val) {
		ListNode cur = head, pre = head;
		while(cur != null) {
			
			if(cur.val == val) {
				if(cur == head) {
					head = head.next;
					pre = head;
				}
				else {
					pre.next = cur.next;
				}
			}
			else {
				pre = cur;
			}
			cur = cur.next;
		}
		return head;
	}

}
