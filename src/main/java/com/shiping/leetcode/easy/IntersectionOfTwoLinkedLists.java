package com.shiping.leetcode.easy;

import com.shiping.leetcode.util.ListNode;

public class IntersectionOfTwoLinkedLists {
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null) return null;
		int numA = 0, numB = 0;
		ListNode curA = headA, curB = headB;
		while(curA != null) {
			numA++;
			curA = curA.next;
		}
		while(curB != null) {
			numB++;
			curB = curB.next;
		}
		curA = headA;
		curB = headB;
		int num = numA;
		if(numA > numB) {
			for(int i = 0; i < numA - numB; i++) curA = curA.next;
			num = numB;
		}
		else {
			for(int i = 0; i < numB - numA; i++) curB = curB.next;
			num = numA;
		}
		ListNode ans = null;
		for(int i = 0; i < num; i++) {
			if(curA == curB) {
				ans = curA;
				break;
			}
			curA = curA.next;
			curB = curB.next;
		}
		return ans;
	}

}
