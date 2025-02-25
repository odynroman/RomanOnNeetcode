package com.romanonneetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://neetcode.io/problems/daily-temperatures">https://neetcode.io/problems/daily-temperatures</a>
 */
public class DailyTemperatures {
    private record Pair(int temp, int day) { }

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Pair> st = new LinkedList<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!st.isEmpty() && temperatures[i] > st.peek().temp) {
                Pair t = st.peek();
                res[t.day] = i - t.day;
                st.pop();
            }
            st.push(new Pair(temperatures[i], i));
        }

        return res;
    }

    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();

        int[] result = solution.dailyTemperatures(new int[] {30, 38, 30, 36, 35, 40, 28});
        for (int x : result) {
            System.out.print(x + ", ");
        }
    }
}
