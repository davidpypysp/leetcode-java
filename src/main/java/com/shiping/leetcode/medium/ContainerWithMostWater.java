package com.shiping.leetcode.medium;

/**
 * Created by shipin on 2015/8/16.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length -1;
        int max = 0;
        while(left < right) {
            max = Math.max( max, getArea(height, left, right) );
            if(height[left] < height[right]) {
                left++;
            }
            else right--;
        }
        return max;
    }

    public int getArea(int[] height, int left, int right) {
        return (right - left) * Math.min(height[left], height[right]);
    }

}
