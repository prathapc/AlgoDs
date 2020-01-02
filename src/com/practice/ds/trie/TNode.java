package com.practice.ds.trie;

public class TNode {

	char ch;
	TNode[] children;
	boolean isWord;

	public TNode(char ch) {
		this.ch = ch;
		children = new TNode[26];
		isWord = false;
	}

	public static void insert(TNode troot, String s) {
		int i;
		if (troot == null)
			return;
		TNode root = troot;
		TNode[] children = root.children;
		for (i = 0; i < s.length(); i++) {
			if (children[s.charAt(i) - 'A'] == null) {
				// children does not exist
				TNode node = new TNode(s.charAt(i));
				children[s.charAt(i) - 'A'] = node;
				root = node;
				children = node.children;
			} else {
				root = children[s.charAt(i) - 'A'];
				children = children[s.charAt(i) - 'A'].children;
			}

		}
		root.isWord = true;
	}

}
