package com.shiping.leetcode.util;

/**
 * Created by shipin on 2015/8/8.
 */
public class UnionFind {
    int size = 500;
    int uset[] = new int[size];

    public static void main(String[] args) {

    }

    void makeSet(int size) {
        for(int i = 0; i < size; i++)
            uset[i] = i;
    }

    int find(int x) {
        if(x != uset[x]) {
            uset[x] = find(uset[x]);
        }
        return uset[x];
    }

    void union(int x, int y) {
        uset[x] = find(y);
    }
}
