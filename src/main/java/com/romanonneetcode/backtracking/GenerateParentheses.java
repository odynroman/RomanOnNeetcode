package com.romanonneetcode.backtracking;

import java.util.*;

/**
 * <a href="https://neetcode.io/problems/generate-parentheses">https://neetcode.io/problems/generate-parentheses</a>
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        return backtracking("", 0, 0, n, new ArrayList<>());
    }

    private List<String> backtracking(String s, int open, int close, int n, List<String> result) {
        if (open == n && close == n) {
            result.add(s);
        }

        if (open < n) {
            backtracking(s + "(", open + 1, close, n, result);
        }

        if (open > close) {
            backtracking(s + ")", open, close + 1, n, result);
        }

        return result;
    }

    public static void main(String[] args) {
        GenerateParentheses solution = new GenerateParentheses();
        System.out.println(solution.generateParenthesis(3));
    }
}
