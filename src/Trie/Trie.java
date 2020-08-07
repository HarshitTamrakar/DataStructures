/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trie;

/**
 *
 * @author Tanya
 */
public class Trie {

    private TrieNode root;

    Trie() {
        root = new TrieNode('\0');
    }

    public void addWord(String word) {
        TrieNode parent = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (parent.children[c - 'a'] == null) {
                parent.children[c - 'a'] = new TrieNode(c);
            }
            parent = parent.children[c - 'a'];
        }
        parent.isTerminating = true;
    }

    public boolean searchWord(String word) {
        TrieNode parent = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (parent.children[c - 'a'] != null) {
                parent = parent.children[c - 'a'];
            } else {
                return false;
            }
        }
        if (parent.isTerminating) {
            return true;
        } else {
            return false;
        }
    }
    
    public void removeWord(String word){
        TrieNode parent = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(parent.children[c - 'a'] != null){
                parent = parent.children[c - 'a'];
            }else{
                System.out.println(word+" is nor present");
                return;
            }
        }
        if(parent.isTerminating){
            parent.isTerminating = false;
        }
    }
    
    private void printHelper(TrieNode parent, String word) {
        for (int i = 0; i < 26; i++) {
            if (parent.children[i] != null) {
                String tillNow = word + parent.children[i].data;
                if (parent.children[i].isTerminating) {
                    System.out.println(tillNow);
                }
                printHelper(parent.children[i], tillNow);
            }
        }
    }

    public void printTrie() {
        printHelper(root, "");
    }
}
