package com.practice.companyQA.spreadsheet_calculator_redmart_test;

import java.util.Set;


public class SpreadSheetOperations {

	/**
	 * -1: for not calculated <br>
	 * 0 : CyclicDependencies is calculated no cycle found<br>
	 * +1: CyclicDependencies is calculated cycle found<br>
	 */
	int[][] cyclicMem;

	public SpreadSheetOperations(int n, int m) {
		cyclicMem = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cyclicMem[i][j] = -1; // default value .
			}
		}
	}

	public boolean hasCyclicDependencies(int n, int m, String[][] spreadsheet, Set<String> VisitedCell) {
		if (cyclicMem[n][m] == -1) {
			if (spreadsheet[n][m].matches(".*[A-Z]+.*")) {
				String[] token = spreadsheet[n][m].trim().split(" ");
				// in case A35
				// Util.getRowIndexByChar(token[i].charAt(0)) ==> 0
				// Integer.parseInt(token[0].substring(1)) 35
				if (VisitedCell.contains(Util.getRowNameByNum(n) + "" + (m + 1))) {
					cyclicMem[n][m] = 1;
					return true;
				}
				VisitedCell.add(Util.getRowNameByNum(n) + "" + (m + 1));

				for (int i = 0; i < token.length; i++) {
					if (token[i].matches(".*[A-Z]+.*")) {
						if (hasCyclicDependencies(Util.getRowIndexByChar(token[i].charAt(0)),
								Integer.parseInt(token[i].substring(1)) - 1, spreadsheet, VisitedCell)) {
							cyclicMem[n][m] = 1;
							return true;
						} else {
							token[i] = spreadsheet[Util.getRowIndexByChar(token[i].charAt(0))][Integer
									.parseInt(token[i].substring(1)) - 1];

						}
					}
				}
				cyclicMem[n][m] = 0;
				spreadsheet[n][m] = String.format("%.5f", Util.postFixCalc(token)) + "";
				return false;

			} else {
				cyclicMem[n][m] = 0;
				spreadsheet[n][m] = String.format("%.5f", Util.postFixCalc(spreadsheet[n][m].trim().split(" "))) + "";
				return false;
			}
		} else if (cyclicMem[n][m] == 0) {
			return false;
		} else {
			return true;
		}
	}
}
