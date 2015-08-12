package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.ListNode;
import com.shiping.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shipin on 2015/8/8.
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        int nums[] = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            nums[i] = list.get(i);

        return dfs(nums, 0, nums.length);
    }

    public TreeNode dfs(int[] nums, int left, int right) {
        if(left >= right) return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfs(nums, left, mid);
        node.right = dfs(nums, mid+1, right);
        return node;
    }
}
