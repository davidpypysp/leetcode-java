package com.shiping.leetcode.hard;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shipingci on 7/29/16.
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return nums;
        Deque<Integer> queue = new LinkedList<Integer>();
        int len = nums.length;
        int[] res = new int[len - k + 1];
        for(int i = 0; i < len; i++) {
            if(!queue.isEmpty() && queue.peekFirst() == i-k) queue.removeFirst();
            while(!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) queue.removeLast();
            queue.addLast(i);
            if(i+1 >= k) res[i+1-k] = nums[queue.peekFirst()];
        }
        return res;
    }
}
