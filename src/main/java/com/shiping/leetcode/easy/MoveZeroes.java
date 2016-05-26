package com.shiping.leetcode.easy;

/**
 * Created by davidpy on 5/21/16.
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int nums[] = {0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes(nums);
    }
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i < n) {
            if(nums[i] == 0) {
                int l = i;
                int zero = 0;
                while(l < n && nums[l] == 0) {
                    l++;
                    zero++;
                }
                while(l < n && nums[l] != 0) {
                    nums[i++] = nums[l++];
                }
                l = i;
                while(zero > 0) {
                    nums[l++] = 0;
                    zero--;
                }
                if(l >= n) break;

            }
            else {
                i++;
            }
        }
        return;
    }
}
