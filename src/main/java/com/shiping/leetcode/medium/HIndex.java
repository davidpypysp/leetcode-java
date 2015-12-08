package com.shiping.leetcode.medium;

import java.util.Arrays;

/**
 * Created by shipin on 2015/9/29.
 */
public class HIndex {
        public int hIndex(int[] citations) {
            if (citations == null || citations.length == 0) return 0;
            Arrays.sort(citations);
            int len = citations.length;
            for (int i = 0; i < citations.length; i++) {
                if (len <= citations[i])
                    return len;
                else
                    len--;
            }
            return len;
        }
}
