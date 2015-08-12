package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.TreeNode;

/**
 * Created by shipin on 2015/8/7.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0) return null;
        int val = postorder[postorder.length - 1];
        TreeNode node = new TreeNode(val);
        if(postorder.length == 1) return node;

        int pos = 0;
        for(int i = 0; i < inorder.length; i++) {
            if(val == inorder[i]) {
                pos = i;
            }
        }

        int left_len = pos, right_len = inorder.length - pos - 1;
        if(left_len != 0) node.left = buildTree( subArray(inorder, 0, pos), subArray(postorder, 0, left_len));
        if(right_len != 0) node.right = buildTree( subArray(inorder, pos + 1, inorder.length), subArray(postorder, left_len, postorder.length - 1) );
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
