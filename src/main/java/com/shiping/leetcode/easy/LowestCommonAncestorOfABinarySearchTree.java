package com.shiping.leetcode.easy;

import com.shiping.leetcode.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shipin on 2015/8/8.
 */
public class LowestCommonAncestorOfABinarySearchTree {
    Map<TreeNode, Boolean> checked = new HashMap<TreeNode, Boolean>();
    Map<TreeNode, TreeNode> ancestor = new HashMap<TreeNode, TreeNode>();
    TreeNode target = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca(root, p, q);
        return target;
    }

    public void lca(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return;
        ancestor.put(root, root);
        checked.put(root, true);

        if(root.left != null) {
            lca(root.left, p, q);
            ancestor.put(root.left, root);
        }
        if(root.right != null) {
            lca(root.right, p, q);
            ancestor.put(root.right, root);
        }

        if(root == p) {
            if(checked.containsKey(q) && checked.get(q) == true) {
                target = find(q);
            }
        }
        else if(root == q) {
            if(checked.containsKey(p) && checked.get(p) == true) {
                target = find(p);
            }
        }
    }

    TreeNode find(TreeNode node) {
        if(ancestor.get(node) != node) {
            ancestor.put( node, find(ancestor.get(node)) );
        }
        return ancestor.get(node);
    }




}
