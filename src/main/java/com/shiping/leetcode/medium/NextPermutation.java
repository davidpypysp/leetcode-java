package com.shiping.leetcode.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by davidpy on 5/20/16.
 */
public class NextPermutation {
    public static void main(String[] args) {
        int nums[] = {1,3,2};
        new NextPermutation().nextPermutation(nums);
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int prev = Integer.MIN_VALUE;
        for(int i = n-1; i >= 0; i--) {
            if(nums[i] < prev) {
                for(int j = n-1; j > i; j--) {
                    if(nums[j] > nums[i]) {
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        break;
                    }
                }
                for(int left = i+1, right = n-1; left < right; left++, right--) { //reverse
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }
                return;
            }
            prev = nums[i];
        }

        for(int left = 0, right = n-1; left < right; left++, right--) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return;

    }
}
