package com.shiping.leetcode.util;

import com.shiping.leetcode.easy.IntersectionOfTwoLinkedLists;

import java.util.*;

/**
 * Created by shipin on 2015/8/8.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("Test");
        Set<Integer> hashset = new HashSet<Integer>();
        hashset.add(10);
        hashset.add(3);
        hashset.add(133);
        Iterator<Integer> it = hashset.iterator();
        for (int i = it.next(); it.hasNext(); i = it.next()) {
            System.out.println(i);
        }



    }
}
