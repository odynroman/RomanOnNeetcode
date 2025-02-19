package com.romanonneetcode.arraysandhashing;

import java.util.*;

/**
 * <a href="https://neetcode.io/problems/valid-sudoku">https://neetcode.io/problems/valid-sudoku</a>
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        List<Set<String>> rows = new ArrayList<>();
        List<Set<String>> cols = new ArrayList<>();
        Map<String, Set<String>> rects = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                rects.put(i + "," + j, new HashSet<>());
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (rows.get(i).contains(String.valueOf(board[i][j]))
                            || cols.get(j).contains(String.valueOf(board[i][j]))
                            || rects.get(i / 3 + "," + j / 3).contains(String.valueOf(board[i][j]))) {
                        return false;
                    } else {
                        rows.get(i).add(String.valueOf(board[i][j]));
                        cols.get(j).add(String.valueOf(board[i][j]));
                        rects.get(i / 3 + "," + j / 3).add(String.valueOf(board[i][j]));
                    }
                }
            }
        }

        return true;
    }
}
