package com.shiping.leetcode.hard;

import com.shiping.leetcode.util.TreeNode;
import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shipingci on 7/27/16.
 */
public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        String s = "5,2,3,null,null,2,4,3,1";
        TreeNode root = new SerializeAndDeserializeBinaryTree().deserialize(s);
        String s1 = new SerializeAndDeserializeBinaryTree().serialize(root);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        StringBuilder str = new StringBuilder();

        int count = 0;
        while(queue.isEmpty() == false) {

            TreeNode node = queue.remove();

            if(node == null) {
                str.append("null,");
                continue;
            }

            str.append(Integer.toString(node.val)).append(",");
            queue.add(node.left);
            queue.add(node.right);

        }
        return str.substring(0, str.length()-1);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        if(data.contains(",") == false) {
            return new TreeNode(Integer.parseInt(data));
        }
        String dataArr[] = data.split(",");
        return buildTree(dataArr);
    }

    TreeNode buildTree(String[] dataArr) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(dataArr[0]));
        int index = 1;
        queue.add(root);
        while(queue.isEmpty() == false) {
            TreeNode node = queue.remove();
            if(index < dataArr.length && !dataArr[index].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(dataArr[index]));
                node.left = left;
                queue.add(left);

            }
            index++;
            if(index < dataArr.length && !dataArr[index].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(dataArr[index]));
                node.right = right;
                queue.add(right);

            }
            index++;

        }
        return root;
    }


}
