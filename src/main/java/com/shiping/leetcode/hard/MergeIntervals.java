package com.shiping.leetcode.hard;

import com.shiping.leetcode.util.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by shipingci on 8/8/16.
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {

        List<Interval> res = new ArrayList<Interval>();

        if(intervals.size() == 0) return res;
        Comparator<Interval> cmp = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        };

        Collections.sort(intervals, cmp);
        Interval cur = null;
        for(Interval itv : intervals) {
            if(cur == null || itv.start > cur.end) {
                cur = itv;
                res.add(cur);
            } else {
                if(itv.end > cur.end) {
                    cur.end = itv.end;
                }
            }

        }
        return res;

    }
}
