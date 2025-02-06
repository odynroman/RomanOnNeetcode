package com.romanonneetcode.arraysandhashing;

/**
 * <a href="https://neetcode.io/problems/two-integer-sum">https://neetcode.io/problems/two-integer-sum</a>
 */
public class TwoIntegerSum {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        // this should never happen according to the task description
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoIntegerSum solution = new TwoIntegerSum();
        solution.twoSum(new int[]{3, 4, 5, 6}, 7);
        solution.twoSum(new int[]{4, 5, 6}, 10);
    }
}
