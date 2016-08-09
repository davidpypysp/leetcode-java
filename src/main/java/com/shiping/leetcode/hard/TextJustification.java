package com.shiping.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shipingci on 8/6/16.
 */
public class TextJustification {
    public static void main(String[] args) {
        String words[] = {"Listen","to","many,","speak","to","a","few."};
        int maxWidth = 6;
        new TextJustification().fullJustify(words, maxWidth);
    }


    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        if(words.length == 0) {
            return res;
        }
        int l = 0;
        while(l < words.length) {
            int width = words[l].length();
            int wordLen = width;
            int r = l+1;
            while(r < words.length && width+words[r].length()+1 <= maxWidth) {
                width += words[r].length() + 1;
                wordLen += words[r].length();
                r++;
            }
            res.add(justify(words, l, r, wordLen, maxWidth, r == words.length));
            l = r;
        }
        return res;
    }


    public String justify(String[] words, int l, int r, int wordLen, int maxWidth, boolean last) {
        if(last == true || r-l == 1) {
            String res = words[l];
            for(int i = l+1; i < r; i++) {
                res += " " + words[i];
            }
            int len = res.length();
            for(int i = 0; i < maxWidth-len; i++)
                res += " ";
            return res;
        }
        int spaceIntervalNum = r-l-1;
        int spaceTotalNum = maxWidth - wordLen;
        int spaceNumEachInterval = spaceTotalNum / spaceIntervalNum;
        int addOneNum = spaceTotalNum % spaceIntervalNum;
        String spaceInterval = "";
        for(int i = 0; i < spaceNumEachInterval; i++) {
            spaceInterval += " ";
        }
        String res = words[l];
        for(int i = 0; i < spaceIntervalNum; i++) {
            res += spaceInterval;
            if(addOneNum > 0) {
                res += " ";
                addOneNum--;
            }
            res += words[l + 1 + i];
        }
        return res;
    }

}
