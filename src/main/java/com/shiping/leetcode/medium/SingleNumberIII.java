package com.shiping.leetcode.medium;

/**
 * Created by davidpy on 16/2/23.
 */
public class SingleNumberIII {
    public int[] singleNumber(int nums[]) {
        /*
        1. Use XOR to store the difference among these numbers, if XOR all elements, the result is the difference between two number like result = 3^5

            then 3^result = 5 , 5^ result = 3

        2. Find one digit 1 in the result, which can be used to distinguish 3 and 5. depends on this, XOR elements will be equal to 3^result = 5 , 5^ result = 3

            O(n) use constant space
         */

        int AXORB = 0;
        for(int i = 0; i < nums.length; i++) {
            AXORB ^= nums[i];
        }

        int diff = AXORB & (~(AXORB - 1));

        int A = 0, B = 0;
        for(int i = 0; i < nums.length; i++) {
            if((diff & nums[i]) != 0)
                A ^= nums[i];
            else
                B ^= nums[i];

        }
        int ans[] = {A, B};
        return ans;

    }
}
