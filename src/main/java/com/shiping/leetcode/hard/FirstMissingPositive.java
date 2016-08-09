package com.shiping.leetcode.hard;

/**
 * Created by shipingci on 8/8/16.
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        int nums[] = {-4,24,32,25,16,-8,3,-5,-6,30,3,3,29,-5,6,-3,1,29,-2,4,4,7,14,20,5,0,25,2,13,26,-9,7,6,33};
        new FirstMissingPositive().firstMissingPositive(nums);
    }


    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) return 1;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0 && nums[i] <= nums.length) {
                while(nums[i] > 0 && nums[i] <= nums.length) {
                    int index = nums[i] - 1;
                    if (nums[index] == nums[i]) break;

                    int tmp = nums[index];
                    nums[index] = nums[i];
                    nums[i] = tmp;
                }
            }
        }


        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1) return i+1;
        }
        return nums.length+1;
    }
}
