package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shipin on 2015/8/6.
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return g(1, n);
    }

    public List<TreeNode> g(int m, int n) {

        List<TreeNode> list = new ArrayList<TreeNode>();

        if(m > n) {
            list.add(null);
            return list;
        }

        for(int i = m; i <= n; i++) {
            List<TreeNode> left = g(m, i-1);
            List<TreeNode> right = g(i+1, n);

            for(TreeNode l : left) {
                for(TreeNode r : right) {
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    list.add(node);
                }
            }
        }
        return list;
    }

}
