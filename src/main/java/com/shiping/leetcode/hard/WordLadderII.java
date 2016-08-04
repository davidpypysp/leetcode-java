package com.shiping.leetcode.hard;

import java.util.*;

/**
 * Created by shipingci on 8/3/16.
 */
public class WordLadderII {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] arr = new String[] {
                "hot","cog","dot","dog","hit","lot","log"
        };
        Set<String> wordList = new HashSet<String>();
        for(String s : arr) {
            wordList.add(s);
        }

        new WordLadderII().findLadders(beginWord, endWord, wordList);


    }


    Map<String, List<String>> map = new HashMap<String, List<String>>();
    List<List<String>> res = new ArrayList<List<String>>();

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {

        if(wordList.contains(beginWord)) {
            wordList.remove(beginWord);
        }
        if(wordList.contains(endWord)) {
            wordList.remove(endWord);
        }

        Set<String> set = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(endWord);
        List<String> beginList = new ArrayList<String>();
        Queue<String> nextQueue = new LinkedList<String>();



        while(queue.isEmpty() == false) {
            boolean startFlag = false;
            while(queue.isEmpty() == false) {
                String cur = queue.remove();

                if(accesible(cur, beginWord)) {
                    startFlag = true;
                    beginList.add(cur);
                    continue;
                }
                if(!startFlag) {
                    char[] curArray = cur.toCharArray();
                    for(int i = 0; i < curArray.length; i++) {
                        char original = curArray[i];
                        for(char c = 'a'; c <= 'z'; c++) {
                            curArray[i] = c;
                            String word = new String(curArray);
                            if(curArray[i] != original && wordList.contains(word) && !set.contains(word)) {
                                if (!map.containsKey(word)) {
                                    List<String> list = new ArrayList<String>();
                                    list.add(cur);
                                    map.put(word, list);
                                    nextQueue.add(word);
                                } else {
                                    map.get(word).add(cur);
                                }

                            }
                        }
                        curArray[i] = original;
                    }
                }
            }

            if(startFlag) break;
            while(!nextQueue.isEmpty()) {
                String next = nextQueue.remove();
                set.add(next);
                queue.add(next);
            }
        }

        if(beginList.isEmpty()) {
            return res;
        }

        map.put(beginWord, beginList);
        List<String> startList = new ArrayList<String>();
        startList.add(beginWord);
        dfs(beginWord, startList, endWord);
        return res;


    }

    void dfs(String cur, List<String> list, String endWord) {
        if(cur.equals(endWord)) {
            res.add(new ArrayList<String>(list));
            return;
        }

        List<String> nextList = map.get(cur);

        for(String next : nextList) {
            list.add(next);
            dfs(next, list, endWord);
            list.remove(list.get(list.size()-1));

        }
        return;
    }

    boolean accesible (String s1, String s2) {
        int count = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                count++;
                if(count > 1) return false;
            }
        }
        if(count == 1) return true;
        return false;
    }
}
