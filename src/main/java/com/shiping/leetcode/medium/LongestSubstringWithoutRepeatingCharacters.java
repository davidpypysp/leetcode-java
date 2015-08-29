package com.shiping.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shipin on 2015/8/29.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        Map<Character, Boolean> map = new HashMap<Character, Boolean>();
        int len = 0;
        int ans = 0;
        int l = 0, r = -1;
        while(r < s.length()) {
            if(r+1 == s.length()) break;
            r++;
            char c = s.charAt(r);
            if(map.containsKey(c) == false) {
                map.put(c, true);
                len++;
                ans = Math.max(ans, len);
            }
            else {
                while(s.charAt(l) != c) {
                    map.remove(s.charAt(l));
                    l++;
                    len--;
                }
                l++;
            }
        }
        return ans;
    }
}
