package org.practice.tries;

import java.util.Locale;

public class Trie {

    private static class TrieNode {
        char data;
        boolean isTerminal;

        int numberOfChild;
        TrieNode[] children;

        public TrieNode(char data) {
            this(data, false);
        }

        public TrieNode(char data, boolean isTerminal) {
            this.data = data;
            this.numberOfChild = 0;
            this.isTerminal = isTerminal;
            this.children = new TrieNode[257];
        }
    }

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode('\0');
    }

    private static String convert(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c >= 'a' && c <= 'z') {
                sb.append(c);
            }
        }
        return sb.toString().trim().toLowerCase(Locale.ROOT);
    }

    public void add(String word) {
//        word = convert(word);


        TrieNode root = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            int charNum = c;
//            int charNum = c - 'a';

            if (root.children[charNum] == null) {
                root.numberOfChild++;
                root.children[charNum] = new TrieNode(c);
            }

            if (i == word.length() - 1) {
                root.children[charNum].isTerminal = true;
            }

            root = root.children[charNum];
        }
    }

    public boolean search(String word) {
//        word = convert(word);

        TrieNode root = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

//            int charNum = c - 'a';
            int charNum = c;
            root = root.children[charNum];

            if (root == null || root.data != c) {
               return false;
            }
        }
        return root.isTerminal;
    }

    public boolean remove(String word) {
//        return remove(this.root,word);
        if(word.length() == 0) return true;

        TrieNode root = this.root;

        int lastIndex = word.charAt(0);
        TrieNode lastNode = root;

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);

            root = root.children[c];

            if(root == null){
                return false;
            }

            if((root.numberOfChild > 1 || root.isTerminal) && i != word.length() -1){
                lastIndex = word.charAt(i+1);
                lastNode = root;
            }
        }

        if(root.numberOfChild == 0){
            lastNode.children[lastIndex] = null;
            lastNode.numberOfChild--;
        }
        else {
            root.isTerminal = false;
        }
        return true;
    }

    private static boolean remove(TrieNode root, String word) {
        if(word.length() == 0){
            root.isTerminal = false;
            return true;
        }
//        int childIndex = word.charAt(0) - 'a';
        int childIndex = word.charAt(0);

        TrieNode child = root.children[childIndex];

        if(child == null){
            return false;
        }

        return remove(child,word.substring(1));
    }

    public void print() {
        print(this.root);
    }

    private static void print(TrieNode root) {
//        if(root == null) return;

        System.out.print(" { data = " + root.data + ", isTerminal = " + root.isTerminal + " } : ");
        System.out.print(" { ");
        for (TrieNode node : root.children) {
            if (node != null)
                System.out.print(node.data + " ");
        }
        System.out.println("} ");
        for (TrieNode node : root.children) {
            if (node != null)
                print(node);
        }
    }

}
