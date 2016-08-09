package com.shiping.leetcode.easy;

public class StrStr {

    public static void main(String[] args) {
        String s = "mississippi";
        String p = "issip";
        new StrStr().strStr(s, p);
    }

    public int strStr(String haystack, String needle) {
		if(haystack.length() == 0) {

            if(needle.length() == 0) return 0;
            return -1;
        }
        if(needle.length() == 0) return 0;
        /*
		for(int i = 0; i < haystack.length() - needle.length() + 1; i++) {
			if(haystack.substring(i, i + needle.length()).equals(needle)) return i;
		}
		return -1;
		*/

        return kmpSolution(haystack, needle);
	}

	public int kmpSolution(String haystack, String needle) {
        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();
        int[] next = getNext(p);
        int i = 0;
        int j = 0;
        while(i < s.length) {
            if(j == -1 || s[i] == p[j]) {
                i++;
                j++;
                if(j == p.length) {
                    return i-j;
                }
            } else {
                j = next[j];
            }
        }
        return -1;
    }

    public int[] getNext(char[] arr) {
        int len = arr.length;
        int[] next = new int[len];
        next[0] = -1;
        int i = 0;
        int k = -1;
        while(i < len-1) {
            if(k == -1 || arr[i] == arr[k]) next[++i] = ++k;
            else k = next[k];
        }
        return next;

    }

}
