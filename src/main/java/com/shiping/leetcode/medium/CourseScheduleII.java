package com.shiping.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidpy on 16/2/27.
 */
public class CourseScheduleII {
    int UNMARKED = 0;
    int TEMPORARY = 1;
    int PERMERNANT = 2;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return new int[]{};
        List<Integer> vertex[] = new List[numCourses];
        for(int i = 0; i < numCourses; i++) {
            vertex[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < prerequisites.length; i++) {
            int p = prerequisites[i][1];
            int q = prerequisites[i][0];
            vertex[p].add(q);
        }

        List<Integer> inverse = new ArrayList<Integer>();
        int[] vis = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(vis[i] == UNMARKED) {
                if(dfs(vertex, vis, inverse, i) == false) return new int[]{};
            }
        }
        int[] ans = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            ans[i] = inverse.get(numCourses - 1 - i);
        }
        return ans;
    }

    boolean dfs(List<Integer>[] vertex, int[] vis, List<Integer> inverse, int v) {
        if(vis[v] == TEMPORARY) return false; // has cycle
        if(vis[v] == PERMERNANT) return true; //has been identified that no cycle
        vis[v] = TEMPORARY;
        for(int i = 0; i < vertex[v].size(); i++) {
            int nv = vertex[v].get(i);
            if(dfs(vertex, vis, inverse, nv) == false) return false;
        }
        vis[v] = PERMERNANT;
        inverse.add(v);
        return true;
    }




}
