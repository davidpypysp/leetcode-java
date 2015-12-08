package com.shiping.leetcode.medium;

/**
 * Created by shipin on 2015/9/23.
 */
public class HIndexII {
    public int hIndex(int[] citations) {
        if(citations.length == 0) return 0;
        int left = 0, right = citations.length;
        int ans = 0;
        while(left < right) {
            int mid = (left + right) / 2;
            int num = citations.length - mid;
            if(citations[mid] >= num) {
                ans = Math.max(ans, num);
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
