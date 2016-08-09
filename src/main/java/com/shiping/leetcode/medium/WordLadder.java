package com.shiping.leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by shipingci on 8/9/16.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        wordList.remove(beginWord);
        wordList.remove(endWord);
        Queue<Node> queue = new LinkedList<Node>();
        Node startNode = new Node(beginWord, 1);
        queue.add(startNode);
        while(queue.isEmpty() == false) {
            Node cur = queue.remove();
            String word = cur.str;
            int step = cur.step;
            if(accesible(word, endWord)) {
                return step + 1;
            }
            char[] arr = word.toCharArray();
            for(int i = 0; i < arr.length; i++) {
                char original = arr[i];
                for(char c = 'a'; c <= 'z'; c++) {
                    if(c != original) {
                        arr[i] = c;
                        String nextWord = new String(arr);
                        if(wordList.contains(nextWord)) {
                            Node next = new Node(nextWord, step+1);
                            queue.add(next);
                            wordList.remove(nextWord);
                        }
                    }
                }
                arr[i] = original;
            }
        }
        return 0;
    }

    boolean accesible (String s1, String s2) {
        int count = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                count += 1;
                if(count > 1) return false;
            }
        }
        if(count == 1) return true;
        return false;
    }

    class Node {
        String str;
        int step;
        Node(String str, int step) {
            this.str = str;
            this.step = step;
        }
    }
}
