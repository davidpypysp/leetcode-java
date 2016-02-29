package com.shiping.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by davidpy on 2/28/16.
 */
public class LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };
        int max = new LongestIncreasingPathInAMatrix().longestIncreasingPath(matrix);
        System.out.println(max);
    }


    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        List<Node> list = new ArrayList<Node>();
        int row = matrix.length, col = matrix[0].length;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                Node node = new Node(matrix[i][j], i, j);
                list.add(node);
            }
        }
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                Node node = list.get(i * col + j);
                if(j + 1 < col && matrix[i][j+1] > matrix[i][j]) node.children.add(list.get(i * col + j + 1));
                if(j - 1 >= 0 && matrix[i][j-1] > matrix[i][j]) node.children.add(list.get(i * col + j - 1));
                if(i + 1 < row && matrix[i+1][j] > matrix[i][j]) node.children.add(list.get((i+1) * col + j));
                if(i - 1 >= 0 && matrix[i-1][j] > matrix[i][j]) node.children.add(list.get((i-1) * col + j));
            }
        }
        Map<Node, Integer> map = new HashMap<Node, Integer>();
        int max = 0;
        for(int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            max = Math.max(max, dfs(node, map));

        }
        return max;
    }


    int dfs(Node node, Map<Node, Integer> map) {
        if(map.containsKey(node)) return map.get(node);
        int max = 1;
        for(int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            max = Math.max(max, 1 + dfs(child, map));
        }
        map.put(node, max);
        return max;
    }

    class Node {
        int val;
        int y, x;
        List<Node> children;
        Node(int val, int y, int x) {
            this. val = val;
            this.y = y;
            this.x = x;
            children = new ArrayList<Node>();
        }
    }
}
