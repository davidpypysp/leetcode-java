package com.shiping.leetcode.hard;

/**
 * Created by shipingci on 8/6/16.
 */
public class ValidNumber {
    public static void main(String[] args) {
        String s = "-.3e6";
        new ValidNumber().isNumber(s);
    }


    public boolean isNumber(String s) {
        if(s.length() == 0) return false;
        int len = s.length();
        int l = 0;
        while(l < len && s.charAt(l) == ' ') l++;
        s = s.substring(l);
        if(s.length() == 0) return false;
        int r = s.length()-1;
        while(r >= 0 && s.charAt(r) == ' ') r--;
        s = s.substring(0, r+1);
        boolean hasNeg = false;
        if(s.charAt(0) == '-') {
            s = s.substring(1);
            hasNeg = true;
        } else if(s.charAt(0) == '+') {
            s = s.substring(1);
        }
        if(s.length() == 0) return false;


        boolean hasE = false;
        boolean hasDot = false;
        boolean valid = true;
        boolean hasLeftNum = false;
        boolean hasRightNum = false;
        boolean hasERightNum = false;
        boolean hasDotRightNum = false;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                hasLeftNum = true;
                if(hasDot) {
                    hasDotRightNum = true;
                }
                if(hasE) {
                    hasERightNum = true;
                }
                continue;
            } else if(c == '.') {
                if(hasDot == false) {
                    if(hasE) return false;
                    else {
                        hasDot = true;
                    }
                } else{
                    return false;
                }
            } else if(c == 'e') {
                if(hasE == false) {
                    if(hasLeftNum == false) return false;
                    else {
                        hasE = true;
                    }
                } else {
                    return false;
                }
            } else if(c == '+' || c == '-') {
                if(hasE == false) return false;
                if(i-1 < 0 || s.charAt(i-1) != 'e') return false;
            } else {
                return false;
            }
        }
        if( (hasE) && (!hasERightNum) ) return false;
        if(hasDot && !hasLeftNum && !hasDotRightNum) return false;
        return true;
    }

}
