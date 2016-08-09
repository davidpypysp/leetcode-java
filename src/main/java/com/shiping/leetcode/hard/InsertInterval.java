package com.shiping.leetcode.hard;

import com.shiping.leetcode.util.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shipingci on 8/9/16.
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        int size = intervals.size();
        int index = 0;

        while(index < size && intervals.get(index).end < newInterval.start) {
            res.add(intervals.get(index++));
        }
        if(index < size && intervals.get(index).start < newInterval.start) {
            Interval itv = intervals.get(index);
            newInterval.start = itv.start;
            if(itv.end > newInterval.end) newInterval.end = itv.end;
            index++;
        }
        while(index < size && intervals.get(index).start <= newInterval.end) {
            Interval itv = intervals.get(index);
            if(itv.end > newInterval.end) newInterval.end = itv.end;
            index++;
        }
        res.add(newInterval);
        while(index < size) {
            res.add(intervals.get(index++));
        }
        return res;
    }
}
