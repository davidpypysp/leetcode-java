package com.shiping.leetcode.hard;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by shipingci on 7/29/16.
 */
public class FindMedianFromDataStream {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, Collections.<Integer>reverseOrder());
        pq.add(3);
        pq.add(4);
        int res = pq.peek();
        pq.add(2);
        res = pq.peek();
    }

    PriorityQueue<Integer> left = new PriorityQueue<Integer>(10, Collections.<Integer>reverseOrder());
    PriorityQueue<Integer> right = new PriorityQueue<Integer>();
    // Adds a number into the data structure.
    public void addNum(int num) {
        if(left.size() == 0) {
            left.add(num);
            return;
        }
        if(num >= left.peek()) {
            if(left.size() == right.size()) {
                if(num > right.peek()) {
                    int val = right.poll();
                    left.add(val);
                    right.add(num);
                } else {
                    left.add(num);
                }
            } else {
                right.add(num);
            }
        } else {
            if(left.size() == right.size()) {
                left.add(num);
            } else {
                int val = left.poll();
                right.add(val);
                left.add(num);
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(left.size() == right.size()) return (double)(left.peek() + right.peek()) / 2.0;
        return left.peek();
    }
}
