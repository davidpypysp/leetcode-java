package com.shiping.leetcode.medium;

/**
 * Created by shipingci on 7/25/16.
 */
public class RangeSumQueryMutable {

}

class NumArray {
    class SegmentTree {
        int l, r;
        int sum;
    }

    SegmentTree tree[];

    public NumArray(int[] nums) {
        if(nums.length == 0) return;
        tree = new SegmentTree[nums.length * 4];
        buildTree(nums, 0, nums.length-1, 1);
    }

    void update(int i, int val) {
        updateTree(i, val, 1);

    }

    public int sumRange(int i, int j) {
        return query(i, j, 1);
    }


    void buildTree(int nums[], int l, int r, int k) {
        tree[k] = new SegmentTree();
        tree[k].l = l;
        tree[k].r = r;
        if(l == r) {
            tree[k].sum = nums[l];
            return;
        }
        int mid = (l + r) / 2;
        buildTree(nums, l, mid, k*2);
        buildTree(nums, mid+1, r, k*2+1);
        tree[k].sum = tree[k*2].sum + tree[k*2+1].sum;
    }

    void updateTree(int i, int val, int k) {
        if(tree[k].l == tree[k].r) {
            tree[k].sum = val;
            return;
        }

        int mid = (tree[k].l + tree[k].r) / 2;
        if(i <= mid) {
            updateTree(i, val, k*2);
        }
        else {
            updateTree(i, val, k*2 + 1);
        }
        tree[k].sum = tree[k*2].sum + tree[k*2 + 1].sum;
    }

    int query(int l, int r, int k) {
        if(tree[k].l == l && tree[k].r == r) {
            return tree[k].sum;
        }
        int mid = (tree[k].l + tree[k].r) / 2;
        if(l > mid) return query(l, r, k*2 + 1);
        else if(r <= mid) return  query(l, r, k*2);
        else return query(l, mid, k*2) + query(mid+1, r, k*2+1);
    }


}




