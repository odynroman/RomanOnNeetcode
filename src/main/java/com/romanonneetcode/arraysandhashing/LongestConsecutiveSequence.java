package com.romanonneetcode.arraysandhashing;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://neetcode.io/problems/longest-consecutive-sequence">https://neetcode.io/problems/longest-consecutive-sequence</a>
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numsSet.add(nums[i]);
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!numsSet.contains(nums[i] - 1)) {
                boolean present = true;
                int current = 0;
                int j = 0;
                while (present) {
                    if (numsSet.contains(nums[i] + j)) {
                        current++;
                        j++;
                        if (max < current) {
                            max = current;
                        }
                    } else {
                        present = false;
                    }
                }
            }
        }

        return max;
    }
}
