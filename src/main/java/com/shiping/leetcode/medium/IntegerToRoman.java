package com.shiping.leetcode.medium;

/**
 * Created by davidpy on 5/24/16.
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        String ans = "";
        while(num > 0) {
            if(num >= 1000) {
                ans += "M";
                num -= 1000;
            }
            else if(num >= 500) {
                if(num >= 900) {
                    ans += "CM";
                    num -= 900;
                }
                else {
                    ans += "D";
                    num -= 500;
                }
            }
            else if(num >= 100) {
                if(num >= 400) {
                    ans += "CD";
                    num -= 400;
                }
                else {
                    ans += "C";
                    num -= 100;
                }
            }
            else if(num >= 50) {
                if(num >= 90) {
                    ans += "XC";
                    num -= 90;
                }
                else {
                    ans += "L";
                    num -= 50;
                }
            }
            else if(num >= 10) {
                if(num >= 40) {
                    ans += "XL";
                    num -= 40;
                }
                else {
                    ans += "X";
                    num -= 10;
                }
            }
            else if(num >= 5) {
                if(num >= 9) {
                    ans += "IX";
                    num -= 9;
                }
                else {
                    ans += "V";
                    num -= 5;
                }
            }
            else if(num >= 1) {
                if(num >= 4) {
                    ans += "IV";
                    num -= 4;
                }
                else {
                    ans += "I";
                    num -= 1;
                }
            }
        }
        return ans;
    }
}
