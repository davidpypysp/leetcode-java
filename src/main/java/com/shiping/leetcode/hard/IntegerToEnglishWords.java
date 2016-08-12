package com.shiping.leetcode.hard;

/**
 * Created by shipingci on 8/11/16.
 */
public class IntegerToEnglishWords {
    String[] nums = {
            "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    String[] nums10 = {
            "Zero", "Ten", "Twenty",  "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        String res = "";
        if(num >= 1000000000) {
            res += helper(num / 1000000000) + " Billion ";
            num %= 1000000000;
        }
        if(num >= 1000000) {
            res += helper(num / 1000000) +  " Million ";
            num %= 1000000;
        }
        if(num >= 1000) {
            res += helper(num / 1000) + " Thousand ";
            num %= 1000;
        }
        if(num > 0) {
            res += helper(num);
        }
        if(res.charAt(res.length()-1) == ' ')
            res = res.substring(0, res.length()-1);
        return res;

    }

    public String helper(int num) {
        if(num == 0) return "Zero";
        String res = "";
        if(num >= 100) {
            res += nums[num/100] + " Hundred ";
            num = num % 100;
        }
        if(num >= 20) {
            res += nums10[num/10] + " ";
            num = num % 10;

        }
        if(num > 0){
            res += nums[num];
        }
        if(res.charAt(res.length()-1) == ' ')
            res = res.substring(0, res.length()-1);
        return res;

    }
}
