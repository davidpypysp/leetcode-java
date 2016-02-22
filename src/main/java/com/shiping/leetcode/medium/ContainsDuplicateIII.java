package com.shiping.leetcode.medium;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by davidpy on 16/2/21.
 */
public class ContainsDuplicateIII {
    public static void main(String[] args) {
        int[] nums = {1, 3, 1};
        containsNearbyAlmostDuplicate(nums, 2, 1);
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        IndexValue[] array = new IndexValue[nums.length];
        for(int i = 0; i < nums.length; i++) {
            IndexValue indexVallue = new IndexValue(i, nums[i]);
            array[i] = indexVallue;
        }

        Arrays.sort(array);

        /*
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i].index + ": " + array[i].value);
        }
        */

        for(int i = 0; i < array.length - 1; i++) {
            for(int j = i + 1; j < array.length ; j++) {
                if(Math.abs(array[i].value - array[j].value) <= t) {
                    if(Math.abs(array[i].index - array[j].index) <= k) return true;
                }
                else break;
            }
        }


        return false;

    }

}

class IndexValue implements Comparable<IndexValue>
{
    int index;
    long value;

    IndexValue(int index, long value) {
        this.index = index;
        this.value = value;
    }

    public int compareTo(IndexValue indexvalue) {
        return (int)(this.value - indexvalue.value);
    }
}
