package com.shiping.leetcode.medium;

/**
 * Created by shipingci on 8/4/16.
 */
public class AddAndSearchWord {



    class WordDictionary {

        Trie trie = new Trie();

        // Adds a word into the data structure.
        public void addWord(String word) {
            trie.insert(word);
        }

        // Returns if the word is in the data structure. A word could
        // contain the dot character '.' to represent any one letter.
        public boolean search(String word) {
            return trie.search(word);

        }


    }

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
            if(w[index] == '.') {
                for(int i = 0; i < 26; i++) {
                    if(node.child[i] != null) {
                        if(searchNode(node.child[i], w, index+1)) return true;
                    }
                }
                return false;
            }
            int k = w[index] - 'a';
            if(node.child[k] == null) return false;
            return searchNode(node.child[k], w, index+1);
        }


    }

}











