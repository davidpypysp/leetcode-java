package com.shiping.leetcode.easy;

/**
 * Created by davidpy on 5/16/16.
 */
public class FirstBadVersion {

    boolean isBadVersion(int version) {
        return true;
    }

    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while(l < r) {
            int mid = l + (r-l) / 2;
            if(isBadVersion(mid)) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return l;
    }
}
