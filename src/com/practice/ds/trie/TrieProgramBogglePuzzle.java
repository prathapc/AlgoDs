package com.practice.ds.trie;

public class TrieProgramBogglePuzzle {

	TNode troot;

	public static void main(String[] args) {
		String dictionary[] = { "CAT", "CAP" };
		int n = dictionary.length;
		char ch = '\0';
		TNode troot = new TNode(ch);

		for (int i = 0; i < n; i++)
			TNode.insert(troot, dictionary[i]);

		char[][] boggle = { { 'C', 'A', 'P' }, { 'A', 'N', 'D' }, { 'T', 'I', 'E' } };

		findWords(boggle, troot);

	}

	private static void findWords(char[][] boggle, TNode root) {

		int m = boggle.length;
		int n = boggle[0].length;
		boolean[][] vis = new boolean[m][n];
		int i, j;
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++)
				vis[i][j] = false;
		}
		TNode[] child = root.children;
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				char ch = boggle[i][j];
				String str = "";
				if (child[ch - 'A'] != null) {
					findWordsUtil(boggle, child[ch - 'A'], str + ch, vis, i, j, m, n);
				}
			}
		}

	}

	private static void findWordsUtil(char[][] boggle, TNode child, String str, boolean[][] vis, int i, int j, int m,
			int n) {
		if (child.isWord) {
			System.out.println(str);
		}
		TNode[] node = child.children;
		vis[i][j] = true;
		int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
		for (int k = 0; k < 8; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			if (isValid1(x, y, m, n) && !vis[x][y]) {
				if (node[boggle[x][y] - 'A'] != null) {
					findWordsUtil(boggle, node[boggle[x][y] - 'A'], str + boggle[x][y], vis, x, y, m, n);
				}
			}
		}
		vis[i][j] = false;

	}

	private static boolean isValid1(int x, int y, int m, int n) {
		return (x >= 0 && y >= 0 && x < m && y < n);
	}
}
