package com.shiping.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> pre = new ArrayList<Integer>();
		pre.add(1);
		if(rowIndex == 0) return pre;
		List<Integer> cur = new ArrayList<Integer>();
		for(int i = 0; i < rowIndex; i++) {
			cur.clear();
			cur.add(1);
			for(int j = 0; j < i; j++) {
				int num = pre.get(j) + pre.get(j+1);
				cur.add(num);
			}
			cur.add(1);
			pre.clear();
			for(int j = 0; j < cur.size(); j++) pre.add(cur.get(j));
		}
		return cur;

	}
}
