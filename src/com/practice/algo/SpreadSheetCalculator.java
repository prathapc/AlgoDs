package com.practice.algo;

import com.sun.deploy.util.StringUtils;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * Created by prathap on 09/01/18.
 */
public class SpreadSheetCalculator {

  public static void main(String args[]) throws Exception {
    Scanner scanner = new Scanner(System.in);
    int c = scanner.nextInt();
    int r = scanner.nextInt();
    scanner.nextLine();
    String[][] input = new String[r][c];
    for(int i=0; i<r; i++) {
      for(int j=0; j<c; j++) {
        input[i][j] = scanner.nextLine();
      }
    }

    int cellStatus[][] = new int[r][c];
    for(int i=0; i<r; i++) {
      for (int j = 0; j < c; j++) {
        cellStatus[i][j] = -1;
      }
    }

    for(int i=0; i<r; i++) {
      for (int j = 0; j < c; j++) {
        int cellState = SpreadSheetCalculatorUtil.getCellValueState(input, i, j, new HashSet<>(), cellStatus);
        if(cellState == 0) {
          throw new Exception("cycle found");
        } else {
          System.out.println(input[i][j]);
        }
      }
    }

  }

  static class SpreadSheetCalculatorUtil {

    public static int getCellValueState(String[][] input, int i, int j, Set<String> visited, int cellStatus[][]) {
      if(cellStatus[i][j] == -1) {
        if(input[i][j].matches(".*[A-Z]+.*")) {

          String[] tokens = input[i][j].trim().split(" ");

          if(visited.contains((char) ( i + 65)+ "" + j)) {
            cellStatus[i][j] = 0;
            return 0;
          } else {
            visited.add(tokens[i]);
          }

          for(int k=0; k<tokens.length; k++) {
            if(tokens[k].matches(".*[A-Z]+.*")) {
              if(getCellValueState(input, (int )tokens[k].charAt(0) - 65, Integer.parseInt(tokens[k].substring(1)) - 1, visited, cellStatus) == 0) {
                cellStatus[i][j] = 0;
                return 0;
              } else {
                tokens[k] = input[(int) (tokens[k].charAt(0) - 65)][Integer.parseInt(tokens[k].substring(1)) - 1];
              }
            }
          }
          cellStatus[i][j] = 1;
          input[i][j] = String.format("%.5f", postfixEvaluation(tokens));
          return 1;
        } else {
          cellStatus[i][j] = 1;
          input[i][j] = String.format("%.5f", postfixEvaluation(input[i][j].split(" ")));
          return 1;
        }

      } else if(cellStatus[i][j] == 0) {
        return 0;
      }
      return 1;
    }

    public static float postfixEvaluation(String tokens[]) {
      Stack<Float> stack = new Stack();
      for(int i=0; i<tokens.length; i++) {
        if(isNumber(tokens[i])) {
          stack.push(Float.valueOf(tokens[i]));
        } else {
          float num1 = stack.pop();
          float num2 = stack.pop();
          if(tokens[i].equals("+")) {
            stack.push(num2+num1);
          } else if(tokens[i].equals("-")) {
            stack.push(num2-num1);
          } else if(tokens[i].equals("*")) {
            stack.push(num2*num1);
          } else if(tokens[i].equals("/")) {
            stack.push(num2/num1);
          }
        }
      }
      return stack.pop();
    }

    private static boolean isNumber(String str) {
      return str.matches("\\d+(\\.\\d+)?");
    }

  }

}
