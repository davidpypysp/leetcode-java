package com.shiping.leetcode.hard;

import com.shiping.leetcode.util.Point;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shipingci on 8/2/16.
 */
public class MaxPointsOnALine {
    public static void main(String[] args) {
        Point a1 = new Point(2, 3);
        Point a2 = new Point(3, 3);
        Point a3 = new Point(-5, 3);
        new MaxPointsOnALine().maxPoints(new Point[]{a1, a2, a3});
    }

    public int maxPoints(Point[] points) {
        if(points.length == 0) return 0;
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        int ans = 1;
        for(int i = 0; i < points.length; i++) {
            map.clear();
            int vertical = 1;
            int repeat = 0;
            int max = 1;
            for(int j = i+1; j < points.length; j++) {
                if(points[i].x == points[j].x && points[i].y == points[j].y) {
                    repeat++;

                } else if(points[i].x == points[j].x) {
                    vertical++;
                } else {
                    double k = (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                    if(k == -0.0) k = Math.abs(k);
                    if(map.containsKey(k) == false) {
                        map.put(k, 2);
                    } else {
                        map.put(k, map.get(k)+1);
                    }
                    max = Math.max(max, map.get(k));
                }
            }
            max = Math.max(max, vertical);
            ans = Math.max(ans, max + repeat);
        }
        return ans;
    }
}
