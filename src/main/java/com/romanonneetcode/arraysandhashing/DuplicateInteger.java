package com.romanonneetcode.arraysandhashing;

import java.util.Set;
import java.util.HashSet;

/**
 * <a href="https://neetcode.io/problems/duplicate-integer">https://neetcode.io/problems/duplicate-integer</a>
 */
public class DuplicateInteger {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (numsSet.contains(nums[i])) {
                return true;
            }
            numsSet.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        DuplicateInteger solution = new DuplicateInteger();
        System.out.println(solution.hasDuplicate(new int[]{1, 2, 3, 3}));
        System.out.println(solution.hasDuplicate(new int[]{1, 2, 3, 4}));
    }
}
