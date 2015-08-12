package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.TreeNode;

/**
 * Created by shipin on 2015/8/7.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        int val = preorder[0];
        TreeNode node = new TreeNode(val);
        if(preorder.length == 1) return node;

        int pos = 0;
        for(int i = 0; i < inorder.length; i++) {
            if(val == inorder[i]) {
                pos = i;
            }
        }

        int left_len = pos, right_len = inorder.length - pos - 1;
        if(left_len != 0) node.left = buildTree( subArray(preorder, 1, 1 + left_len), subArray(inorder, 0, pos));
        if(right_len != 0) node.right = buildTree( subArray(preorder, 1 + left_len, preorder.length), subArray(inorder, pos + 1, inorder.length) );
        return node;
    }

    int[] subArray(int A[], int m, int n) {
        int result[] = new int[n - m];
        int cnt = 0;
        for(int i = m; i < n; i++) {
            result[cnt++] = A[i];
        }
        return result;
    }



}
