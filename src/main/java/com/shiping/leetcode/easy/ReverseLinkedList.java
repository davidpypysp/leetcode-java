package com.shiping.leetcode.easy;

import com.shiping.leetcode.util.ListNode;

import java.util.Scanner;

public class ReverseLinkedList {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		ListNode head = new ListNode(0), prev = head, p = null;
		for(int i = 0; i < n; i++) {
			int val = scanner.nextInt();
			p = new ListNode(val);
			prev.next = p;
			prev = p;
		}
		head = head.next;
		ListNode nh = reverseList(head);
		while(nh != null) {
			System.out.print(nh.val + " ");
			nh = nh.next;
		}
		
		
	}
	
	public static ListNode reverseList(ListNode head) {
		ListNode h = null, last = null, p = head;
		while(p != null) {
			h = new ListNode(p.val);
			h.next = last;
			last = h;
			p = p.next;
		}
		return h;
	}

}

/*
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}
*/