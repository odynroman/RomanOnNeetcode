package com.romanonneetcode.arraysandhashing;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a href="https://neetcode.io/problems/top-k-elements-in-list">https://neetcode.io/problems/top-k-elements-in-list</a>
 */
public class TopKElementsInListViaPriorityQueue {

    private record Pair(int key, int value) {
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length <= k) {
            return nums;
        }

        Map<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], numsMap.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Pair> topNums = new PriorityQueue<>((x, y) -> x.value() - y.value());

        numsMap.forEach((key, val) -> {
            topNums.add(new Pair(key, val));
            if (topNums.size() > k) {
                topNums.poll();
            }
        });

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topNums.poll().key;
        }

        return result;
    }

    public static void main(String[] args) {
        TopKElementsInListViaPriorityQueue solution = new TopKElementsInListViaPriorityQueue();
        int[] result = solution.topKFrequent(new int[]{1, 2, 2, 3, 3, 3}, 2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
