package com.shiping.leetcode.hard;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created by davidpy on 5/14/16.
 */
public class CreateMaximumNumber {

    public static void main(String[] args) {
        CreateMaximumNumber cm = new CreateMaximumNumber();
        int nums1[] = {3, 9};
        int nums2[] = {8, 9};
        cm.maxNumber(nums1, nums2, 3);
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int ans[] = new int[k];
        for(int i = Math.max(0, k - n2); i <= k && i <= n1; i++) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k-i), k);
            if(greater(candidate, 0, ans, 0)) ans = candidate;
        }
        return ans;
    }

    public int[] merge(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for(int i = 0, j = 0, r = 0; r < k; r++) {
            ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return ans;
    }

    public boolean greater(int[] arr1, int i, int[] arr2, int j) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        while(i < n1 && j < n2 && arr1[i] == arr2[j]) {
            i++;
            j++;
        }
        return (j == n2) || (i < n1 && arr1[i] > arr2[j]);
    }

    public int[] maxArray(int[] arr, int k) {
        int ans[] = new int[k];
        int n = arr.length;
        for(int i = 0, j = 0; i < n; i++) {
            while(k - j < n - i && j > 0 && ans[j-1] < arr[i]) j--;
            if(j < k) ans[j++] = arr[i];
        }
        return ans;
    }

}
