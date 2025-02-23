package com.romanonneetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 <a href=" * https://neetcode.io/problems/validate-parenthe">https://neetcode.io/problems/validate-parentheses</a>ses
 */
public class ValidateParentheses {
    public boolean isValid(String s) {
        Deque<Character> chars = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c.equals('(') || c.equals('[') || c.equals('{')) {
                chars.push(c);
            } else {
                if (chars.isEmpty()) {
                    return false;
                }

                Character t = chars.peek();
                if ((t.equals('(') && c.equals(')'))
                        || (t.equals('[') && c.equals(']'))
                        || (t.equals('{') && c.equals('}'))) {
                    chars.pop();
                } else {
                    return false;
                }
            }
        }

        if (!chars.isEmpty()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidateParentheses solution = new ValidateParentheses();
        System.out.println(solution.isValid("[]"));
    }
}
