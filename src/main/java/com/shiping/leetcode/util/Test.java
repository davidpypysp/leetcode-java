package com.shiping.leetcode.util;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

/**
 * Created by shipin on 2015/8/8.
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(5);
        list.add(6);
        List<Integer> list2 = new ArrayList<Integer>(list);
        list2.add(34);
        System.out.println(list);
        System.out.println(list2);
    }
}
