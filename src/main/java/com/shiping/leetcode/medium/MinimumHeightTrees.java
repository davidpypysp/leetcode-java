package com.shiping.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by davidpy on 16/2/26.
 */
public class MinimumHeightTrees {
    /*
        first of all, we should find the longest path in this graph. And the medium one or two point can have the
        MHT.

        We use twice BFS to find that point, first start from arbitrary point use BFS, and we can find the longest path from this point, and it
        ends at a point p. than we start from p and do another BFS, find the longest path. This is the right longest path.


     */

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        new MinimumHeightTrees().findMinHeightTrees(n, edges);

    }


    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n < 1) return null;
        List[] list = new List[n];
        for(int i = 0; i < n; i++)
            list[i] = new ArrayList<Integer>();

        for(int i = 0; i < edges.length; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            list[v1].add(v2);
            list[v2].add(v1);


        }
        int p = bfs(list, 0);
        return bfs2(list, p);




    }


     public int bfs(List<Integer> list[], int start) {
         boolean vis[] = new boolean[list.length];
         Queue<Integer> queue = new LinkedList<Integer>();
         queue.add(start);
         int v = 0;
         while(queue.isEmpty() == false) {
             v = queue.poll();
             vis[v] = true;
             for(int k = 0; k < list[v].size(); k++) {
                 int nv = list[v].get(k);
                 if(!vis[nv]) {
                     queue.add(nv);
                 }
             }
         }
         return v;
     }

    public List<Integer> bfs2(List<Integer> list[], int start) {
        boolean vis[] = new boolean[list.length];
        int dis[] = new int[list.length];
        int prev[] = new int[list.length];
        Queue<Integer> queue = new LinkedList<Integer>();
        int v = 0;
        queue.add(start);
        dis[start] = 1;
        prev[start] = start;
        while(queue.isEmpty() == false) {
            v = queue.poll();
            vis[v] = true;
            for(int k = 0; k < list[v].size(); k++) {
                int nv = list[v].get(k);
                if(!vis[nv]) {
                    dis[nv] = dis[v] + 1;
                    prev[nv] = v;
                    queue.add(nv);
                }
            }
        }
        int end = v;
        int len = dis[end];
        List<Integer> ans = new ArrayList<Integer>();
        if(len % 2 == 0) {
            for(int i = 0; i < len / 2 - 1; i++)
                v = prev[v];
            ans.add(v);
            ans.add(prev[v]);
        }
        else {
            for(int i = 0; i < len / 2; i++){
                v = prev[v];
            }
            ans.add(v);
        }
        return ans;

    }
}
