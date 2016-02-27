package com.shiping.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidpy on 16/2/27.
 */
public class CourseSchedule {
    public static void main(String[] args) {
        int pre[][] = new int[][]{{0, 1}};
        int n = 2;
        new CourseSchedule().canFinish(n, pre);
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 1) return true;
        List<Integer> vertex[] = new List[numCourses];
        for(int i = 0; i < numCourses; i++)
            vertex[i] = new ArrayList<Integer>();
        for(int i = 0; i < prerequisites.length; i++) {
            int p = prerequisites[i][1], q = prerequisites[i][0];
            vertex[p].add(q);
        }

        boolean vis[] = new boolean[numCourses];
        boolean nocycle[] = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(nocycle[i] == false) {
                if(dfs(vertex, vis, nocycle, i) == false) return false;
            }
        }
        return true;
    }

    boolean dfs(List<Integer>[] vertex, boolean[] vis, boolean[] nocycle, int v) {
        if(nocycle[v] == true) return true;
        if(vis[v]) return false;
        vis[v] = true;
        for(int i = 0; i < vertex[v].size(); i++) {
            int nv = vertex[v].get(i);
            if(dfs(vertex, vis, nocycle, nv) == false) {
                return false;
            }
        }
        nocycle[v] = true;
        return true;
    }
}
