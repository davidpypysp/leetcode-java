package com.shiping.leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by shipingci on 8/4/16.
 */
public class WordSearchII {
    Trie trie = new Trie();
    List<String> res = new ArrayList<String>();
    Set<String> set = new HashSet<String>();

    int dy[] = {1, 0, -1, 0};
    int dx[] = {0, 1, 0, -1};

    public List<String> findWords(char[][] board, String[] words) {
        if(board.length == 0) return res;
        for(String word : words) {
            set.add(word);
            trie.insert(word);
        }

        if(trie.root.hasChild == false) return res;
        int count = set.size();

        for(int y = 0; y < board.length; y++) {
            for(int x = 0; x < board[y].length; x++) {
                int k = board[y][x] - 'a';
                if(trie.root.child[k] != null) {
                    dfs(board, y, x, trie.root.child[k]);
                }
                if(res.size() == count) return res;
            }
        }
        return res;
    }

    void dfs(char[][] board, int y, int x, TrieNode node) {
        char original = board[y][x];

        if(node.isWord) {
            if(set.contains(node.word)) {
                res.add(node.word);
                set.remove(node.word);
            }
        }

        if(!node.hasChild) return;
        board[y][x] = '.';
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i], nx = x + dx[i];
            if(ny < 0 || ny >= board.length || nx < 0 || nx >= board[0].length) continue;
            char c = board[ny][nx];
            if(c != '.') {
                int k = c - 'a';
                if(node.child[k] != null) {
                    dfs(board, ny, nx, node.child[k]);
                }
            }
        }
        board[y][x] = original;

    }
}

class TrieNode {
    char nodeChar;
    TrieNode child[];
    boolean isWord;
    String word;
    boolean hasChild;
    // Initialize your data structure here.
    public TrieNode() {
        child = new TrieNode[26];
        isWord = false;
        hasChild = false;
    }

}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        insertNode(root, word.toCharArray(), 0);
    }

    public void insertNode(TrieNode node, char[] w, int index) {
        if(index == w.length) {
            node.isWord = true;
            node.word = new String(w);
            return;
        }
        int k = w[index] - 'a';
        if(node.child[k] == null) {
            node.child[k] = new TrieNode();
            node.child[k].nodeChar = w[index];
            node.hasChild = true;
        }
        insertNode(node.child[k], w, index+1);
    }

}
