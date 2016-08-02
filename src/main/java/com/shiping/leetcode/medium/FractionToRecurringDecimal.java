package com.shiping.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shipingci on 8/1/16.
 */
public class FractionToRecurringDecimal {
    public static void main(String[] args) {
        new FractionToRecurringDecimal().fractionToDecimal(-2147483648, -1);
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator % denominator == 0) {
            String res =  ((long)numerator / (long)denominator) + "";
            return res;
        }


        boolean neg = false;
        if((double)numerator / (double)denominator < 0) neg = true;
        long numer = (long)numerator;
        long denom = (long)denominator;
        numer = Math.abs(numer);
        denom = Math.abs(denom);
        long left = numer / denom;
        long r = numer % denom;


        List<Long> list = new ArrayList<Long>();
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        int repeat = -1;
        int i = 0;
        while(true) {
            if(map.containsKey(r) == false ) {
                map.put(r, i);
            } else {
                repeat = map.get(r);
                break;
            }
            r *= 10;
            long d = r / denom;
            list.add(d);
            r = r - (d * denom);
            i++;
            if(r == 0) {
                break;
            }
        }

        String res = left + ".";
        if(neg == true) {
            res = "-" + res;
        }
        for(i = 0; i < list.size(); i++) {
            if(repeat == i) {
                res += "(";
            }
            res += list.get(i).toString();
        }
        if(repeat != -1) {
            res += ")";
        }
        return res;

    }
}
