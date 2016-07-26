package com.shiping.leetcode.hard;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by shipingci on 7/25/16.
 */
public class TheSkylineProblem {

    List<int[]> ans = new LinkedList<int[]>();
    public List<int[]> getSkyline(int[][] buildings) {
        if(buildings.length == 0) return ans;
        int leftBound = buildings[0][0], rightBound = 0;
        for(int i = 0; i < buildings.length; i++) {
            if(buildings[i][1] > rightBound) rightBound = buildings[i][1];
        }

        SegmentTree root = new SegmentTree(leftBound, rightBound-1, 0);
        for(int i = 0; i < buildings.length; i++) {
            insertTree(root, buildings[i][0], buildings[i][1] - 1, buildings[i][2]);
        }

        inorderTraversal(root);
        ans.add(new int[]{rightBound, 0});
        return ans;



    }


    class SegmentTree {
        int l, r;
        int val;
        boolean isFlat;
        SegmentTree left, right;

        SegmentTree(int l, int r, int val) {
            this.l = l;
            this.r = r;
            this.val = val;
            isFlat = true;
            left = null;
            right = null;
        }
    }

    void insertTree(SegmentTree node, int l, int r, int val) {
        if(node.l == l && node.r == r) {
            if(node.left == null && node.right == null) {
                if (val > node.val) {
                    node.val = val;
                }
            } else {
                if(node.left != null) {
                    insertTree(node.left, node.left.l, node.left.r, val);
                }
                if(node.right != null) {
                    insertTree(node.right, node.right.l, node.right.r, val);
                }
            }
            return;
        }

        int mid = node.l + (node.r - node.l) / 2;
        if(node.left == null) node.left = new SegmentTree(node.l, mid, node.val);
        if(node.right == null) node.right = new SegmentTree(mid+1, node.r, node.val);
        if(r <= mid) {
            insertTree(node.left, l, r, val);

        } else if(l > mid) {
            insertTree(node.right, l, r, val);

        } else {
            insertTree(node.left, l, mid, val);
            insertTree(node.right, mid+1, r, val);
        }
    }

    void inorderTraversal(SegmentTree node) {
        if(node == null) return;
        inorderTraversal(node.left);
        if(node.left == null && node.right == null) { //leaf
            if(ans.size() == 0 || ans.get(ans.size() - 1)[1] != node.val) {
                int arr[] = {node.l, node.val};
                ans.add(arr);
            }
        }
        inorderTraversal(node.right);
    }
}
