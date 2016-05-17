package test;

import java.util.TreeMap;

/**
 * Created by davidpy on 5/14/16.
 */
public class Test1 {
    public static void main(String[] args) {
        int nums[] = {3, 1, 3, 2, 4, 5};
        TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            tm.put(nums[i], i);
        }
    }
}
