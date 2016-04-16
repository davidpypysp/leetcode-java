package com.shiping.leetcode.medium;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by davidpy on 4/6/16.
 */
public class Test {
    public static void main(String[] args) {
        Queue<Integer> q = new PriorityQueue<Integer>();
        q.add(5);
        q.add(2);
        q.add(1);
        q.add(10);
        q.add(3);

        if(q.contains(10)) {
            System.out.println("yes");
        }

        while(!q.isEmpty()) {
            System.out.print(q.poll() + ", ");
        }
        System.out.println();
    }


    public static class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer x, Integer y) {
            return x - y;
        }
    }
}
