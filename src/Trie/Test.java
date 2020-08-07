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
public class Test {
    
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.addWord("dot");
        trie.addWord("not");
        trie.addWord("do");
        trie.printTrie();
        trie.removeWord("do");
        trie.printTrie();
        trie.removeWord("dot");
        trie.printTrie();
    }
    
}
