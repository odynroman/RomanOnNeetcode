package com.romanonneetcode.arraysandhashing;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://neetcode.io/problems/top-k-elements-in-list">https://neetcode.io/problems/top-k-elements-in-list</a>
 */
public class TopKElementsInList {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(nums[i])) {
                numsMap.put(nums[i], numsMap.get(nums[i]) + 1);
            } else {
                numsMap.put(nums[i], 1);
            }
        }

        int[] result = numsMap.entrySet().stream()
                .sorted((x1, x2) -> -1 * x1.getValue().compareTo(x2.getValue()))
                .limit(k)
                .map(x -> x.getKey())
                .mapToInt(x -> x.intValue())
                .toArray();

        return result;
    }

    public static void main(String[] args) {
        TopKElementsInList solution = new TopKElementsInList();
        int[] result = solution.topKFrequent(new int[]{1, 2, 2, 3, 3, 3}, 2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
