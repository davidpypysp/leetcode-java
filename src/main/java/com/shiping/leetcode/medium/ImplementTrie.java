package com.shiping.leetcode.medium;

import com.shiping.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shipingci on 8/4/16.
 */
public class ImplementTrie {

    class TrieNode {
        char nodeChar;
        TrieNode child[];
        boolean isWord;
        // Initialize your data structure here.
        public TrieNode() {
            child = new TrieNode[26];
            isWord = false;
        }

    }

    class Trie {
        private TrieNode root;

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
                return;
            }
            int k = w[index] - 'a';
            if(node.child[k] == null) {
                node.child[k] = new TrieNode();
                node.child[k].nodeChar = w[index];
            }
            insertNode(node.child[k], w, index+1);
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            return searchNode(root, word.toCharArray(), 0);
        }

        public boolean searchNode(TrieNode node, char[] w, int index) {
            if(index == w.length) return node.isWord;
            int k = w[index] - 'a';
            if(node.child[k] == null) return false;
            return searchNode(node.child[k], w, index+1);
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            return startWithNode(root, prefix.toCharArray(), 0);
        }

        public boolean startWithNode(TrieNode node, char[] pre, int index) {
            if(index == pre.length) return true;
            int k = pre[index] - 'a';
            if(node.child[k] == null) return false;
            return startWithNode(node.child[k], pre, index+1);
        }
    }


}


