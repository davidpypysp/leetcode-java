package com.shiping.leetcode.medium;

import java.util.*;

/**
 * Created by davidpy on 4/6/16.
 */
public class Test {
    public static void main(String[] args) {

        String s = "  30";
        int val = Integer.parseInt(s);
        System.out.println(val);
        return;
    }


    public static class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer x, Integer y) {
            return x - y;
        }
    }
}
