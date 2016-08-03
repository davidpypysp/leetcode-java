package com.shiping.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shipingci on 8/2/16.
 */
public class LetterCombinationsOfAPhoneNumber {
    String[] mapping = new String[] {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };
    List<String> res = new ArrayList<String>();


    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return res;
        }
        dfs(digits, "", 0);
        return res;

    }

    void dfs(String digits, String present, int index) {
        if(index == digits.length()) {
            res.add(present);
            return;
        }
        int digit = digits.charAt(index) - '0';
        for(int i = 0; i < mapping[digit].length(); i++) {
            dfs(digits, present + mapping[digit].charAt(i), index+1);
        }
    }


}
