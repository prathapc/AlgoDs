package com.practice.companyQA.spreadsheet_calculator_redmart_test;

import java.util.HashSet;
import java.util.Scanner;

public class Spreadsheet {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();//dummhy
		String[][] inputSpreadsheet = new String[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				inputSpreadsheet[i][j] = sc.nextLine();
			}
		}

		SpreadSheetOperations spreadSheetOperations = new SpreadSheetOperations(m, n);

		for (int row = 0; row < m; row++) {
			for (int cal = 0; cal < n; cal++) {
				if (spreadSheetOperations.hasCyclicDependencies(row, cal, inputSpreadsheet, new HashSet<String>())) {
					System.out.print("t \t");
					// System.exit(1);
				} else {
					System.out.println(inputSpreadsheet[row][cal]);
				}

			}
		}

	}

}
