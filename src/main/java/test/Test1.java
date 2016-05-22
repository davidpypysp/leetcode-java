package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by davidpy on 5/14/16.
 */
public class Test1 {
    public static void main(String[] args) {
        int nums[] = {3, 1, 3, 2, 4, 5};
        List<int[]> list = Arrays.asList(nums);
        Collections.reverse(list);
        System.out.println("finished");
    }
}
