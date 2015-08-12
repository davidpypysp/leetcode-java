package com.shiping.leetcode.easy;

/**
 * Created by shipin on 2015/8/4.
 */
public class ValidAnagram {
    public static void main(String[] args) {
        String s = "cat";
        String t = "tar";
        System.out.println(new ValidAnagram().isAnagram(s, t));
    }



    public boolean isAnagram(String s, String t) {
        int vis[] = new int[26];
        int vis2[] = new int[26];

        for(int i = 0; i < s.length(); i++) {
            vis[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++) {
            vis2[t.charAt(i) - 'a']++;
        }

        boolean flag = true;
        for(int i = 0; i < 26; i++) {
            if(vis[i] != vis2[i]) {
                flag = false;
                break;
            }
        }
        return flag;

    }

}
