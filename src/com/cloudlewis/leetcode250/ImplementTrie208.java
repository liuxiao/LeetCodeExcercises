package com.cloudlewis.leetcode250;

/**
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * @author xiao
 *
 */
public class ImplementTrie208 {
	private TrieNode root;

	/** Initialize your data structure here. */
	public ImplementTrie208() {
		root = new TrieNode(' ');
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode ws = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (ws.children[c - 'a'] == null) {
				ws.children[c - 'a'] = new TrieNode(c);
			}
			ws = ws.children[c - 'a'];
		}
		ws.isWord = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode ws = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (ws.children[c - 'a'] == null)
				return false;
			ws = ws.children[c - 'a'];
		}
		return ws.isWord;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given
	 * prefix.
	 */
	public boolean startsWith(String prefix) {
		TrieNode ws = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (ws.children[c - 'a'] == null)
				return false;
			ws = ws.children[c - 'a'];
		}
		return true;
	}

	public class TrieNode {
		public char val;
		public boolean isWord;
		public TrieNode[] children = new TrieNode[26];

		TrieNode(char c) {
			val = c;
		}
	}
	
	public static void main(String[] args) {
		ImplementTrie208 t = new ImplementTrie208();
		t.insert("abc");
		t.insert("abcd");
		t.insert("abdd");
		System.out.println(t.search("abcd"));
		System.out.println(t.startsWith("ab"));
		System.out.println(t.startsWith("ac"));
		
	}
}
