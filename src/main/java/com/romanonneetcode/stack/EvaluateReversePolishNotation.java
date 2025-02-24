package com.romanonneetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://neetcode.io/problems/evaluate-reverse-polish-notation">https://neetcode.io/problems/evaluate-reverse-polish-notation</a>
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> nums = new LinkedList<>();

        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i])) {
                Integer x2 = nums.pop();
                Integer x1 = nums.pop();

                nums.push(x1 + x2);

            } else if ("-".equals(tokens[i])) {
                Integer x2 = nums.pop();
                Integer x1 = nums.pop();

                nums.push(x1 - x2);
            } else if ("/".equals(tokens[i])) {
                Integer x2 = nums.pop();
                Integer x1 = nums.pop();

                nums.push(x1 / x2);
            } else if ("*".equals(tokens[i])) {
                Integer x2 = nums.pop();
                Integer x1 = nums.pop();

                nums.push(x1 * x2);
            } else {
                nums.push(Integer.parseInt(tokens[i]));
            }
        }

        return nums.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation solution = new EvaluateReversePolishNotation();
        System.out.println(solution.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }
}
