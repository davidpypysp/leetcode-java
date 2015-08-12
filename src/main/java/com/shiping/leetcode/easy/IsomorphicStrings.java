package com.shiping.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsomorphicStrings {
	Map<String, Integer> map = new HashMap<String, Integer>();
	List<String> list = new ArrayList<String>();
	
	public boolean isIsomorphic(String s, String t) {
		if(t.length() != s.length()) return false;
		int arr[] = new int[s.length()];
		for(int i = 0; i < s.length(); i++) {
			arr[i] = id(s.charAt(i) + "");
		}
		map.clear();
		list.clear();
		for(int i = 0; i < t.length(); i++) {
			if(arr[i] != id(t.charAt(i) + "")) return false;
		}
		return true;
		
	}
	
	public int id(String s) {
		if(map.containsKey(s)) return map.get(s);
		list.add(s);
		int n = list.size() - 1;
		map.put(s, n);
		return n;
	}

}
