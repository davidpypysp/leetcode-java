package com.shiping.leetcode.medium;

import java.util.*;

/**
 * Created by davidpy on 4/14/16.
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        Queue<Long> q = new PriorityQueue<Long>();
        q.add(new Long(1));
        q.add(new Long(2));
        q.add(new Long(3));
        q.add(new Long(4));
        q.add(new Long(5));
        Long num = new Long(0);
        for(int i = 0; i < n; i++) {
            num = q.poll();
            if(q.contains(num*2) == false) q.add(num*2);
            if(q.contains(num*3) == false) q.add(num*3);
            if(q.contains(num*5) == false) q.add(num*5);
        }
        return num.intValue();
    }
}
