package com.romanonneetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://neetcode.io/problems/minimum-stack">https://neetcode.io/problems/minimum-stack</a>
 */
public class MinStack {
    private Deque<Integer> stack = new LinkedList<Integer>();
    private Deque<Integer> minStack = new LinkedList<>();

    public MinStack() {
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<>();
    }

    public void push(int val) {
        stack.push(val);
        if (!minStack.isEmpty()) {
            int min = minStack.peek();
            minStack.push(val < min ? val : min);
        } else {
            minStack.push(val);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
