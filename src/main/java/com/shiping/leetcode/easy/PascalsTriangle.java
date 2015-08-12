package com.shiping.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public static void main(String[] args) {
		List<List<Integer>> list = generate(5);
		return;
	}
	
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(numRows == 0) return list;
		List<Integer> first = new ArrayList<Integer>();
		first.add(1);
		list.add(first);
		for(int i = 1; i < numRows; i++) {
			List<Integer> line = new ArrayList<Integer>();
			line.add(1);
			for(int j = 1; j < i; j++) {
				int num = list.get(i-1).get(j-1) + list.get(i-1).get(j);
				line.add(num);
			}
			line.add(1);
			list.add(line);
		}
		return list;
	}

}
