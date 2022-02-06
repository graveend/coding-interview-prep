package models;

import java.util.Map;

public class TrieNode {
    public TrieNode[] childrens;
    public boolean isEnd;

    public TrieNode() {
        this.childrens = new TrieNode[26];
        this.isEnd = false;
    }
}
