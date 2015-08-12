package com.shiping.leetcode.easy;

import com.shiping.leetcode.util.ListNode;

public class MergeTwoSortedList {
	
	public static void main(String[] args) {
		
	}
	
	static public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode h = null, cur = null;
		while(l1 != null || l2 != null) {
			int val = 0;
			if(l1 != null && l2 != null) {
				if(l1.val < l2.val) {
					val = l1.val;
					l1 = l1.next;
				}
				else {
					val = l2.val;
					l2 = l2.next;
				}
			}
			else if(l1 != null) {
				val = l1.val;
				l1 = l1.next;
			}
			else if(l2 != null) {
				val = l2.val;
				l2 = l2.next;
			}
			ListNode p = new ListNode(val);
			if(cur != null) {
				cur.next = p;
				cur = cur.next;
			}
			else {
				cur = p;
				h = cur;
			}
		}
		return h;
		
	}

}


