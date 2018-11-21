package com.practice.ds.trie;

public class TNode {
	char ch;

	TNode[] child;

	boolean isWord;

	public TNode(char ch) {
		this.ch = ch;
		child = new TNode[26];
		isWord = false;

	}

	public static void insert(TNode troot, String s) {
		int i;
		if (troot == null)
			return;
		TNode root = troot;
		TNode[] children = root.child;
		for (i = 0; i < s.length(); i++) {
			if (children[s.charAt(i) - 'A'] == null) {
				// child does not exist
				TNode node = new TNode(s.charAt(i));
				children[s.charAt(i) - 'A'] = node;
				root = node;
				children = node.child;
			} else {
				root = children[s.charAt(i) - 'A'];
				children = children[s.charAt(i) - 'A'].child;
			}

		}
		root.isWord = true;
	}

}
