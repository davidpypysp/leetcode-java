package com.shiping.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shipingci on 7/26/16.
 */
public class CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        int nums[] = new int[]{5, 2, 6, 1};
        new CountOfSmallerNumbersAfterSelf().countSmaller(nums);
    }

    List<Integer> res = new ArrayList<Integer>();
    public int arr[];

    public List<Integer> countSmaller(int[] nums) {
        if(nums.length == 0) return res;
        int len = nums.length;
        arr = new int[len];
        BST root = new BST(nums[len-1]);
        for(int i = len - 2; i >= 0; i--) {
            buildTree(root, nums[i], i);
        }
        for(int i = 0; i < len; i++) {
            res.add(arr[i]);
        }
        return res;

    }

    void buildTree(BST root, int val, int index) {
        root.count++;
        if(val <= root.val) {
            if(root.left == null) {
                root.left = new BST(val);
            }
            else {
                buildTree(root.left, val, index);
            }
        }
        else {
            arr[index]++;
            if(root.left != null) arr[index] += root.left.count;
            if(root.right == null) {
                root.right = new BST(val);
            }
            else {
                buildTree(root.right, val, index);
            }
        }
    }




    class BST{
        int val;
        int count;
        BST left, right;
        BST(int val) {
            this.val = val;
            count = 1;
            left = null;
            right = null;
        }
    }
}
