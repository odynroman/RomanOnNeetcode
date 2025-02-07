package com.romanonneetcode.arraysandhashing;

import java.util.*;

/**
 * <a href="https://neetcode.io/problems/anagram-groups">https://neetcode.io/problems/anagram-groups</a>
 */
public class AnagramGroups {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<String, Integer>, List<String>> anagramsMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            Map<String, Integer> result = getCharsMap(strs[i]);

            if (anagramsMap.containsKey(result)) {
                anagramsMap.get(result).add(strs[i]);
            } else {
                List<String> stringList = new ArrayList();
                stringList.add(strs[i]);
                anagramsMap.put(result, stringList);
            }
        }

        return new ArrayList<>(anagramsMap.values());
    }

    public Map<String, Integer> getCharsMap(String s) {
        Map<String, Integer> charsMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (charsMap.containsKey(s.substring(i, i + 1))) {
                charsMap.put(s.substring(i, i + 1), charsMap.get(s.substring(i, i + 1) + 1));
            } else {
                charsMap.put(s.substring(i, i + 1), 1);
            }
        }
        return charsMap;
    }

    public static void main(String[] args) {
        AnagramGroups solution = new AnagramGroups();
        List<List<String>> result = solution.groupAnagrams(new String[]{"act", "pots", "tops", "cat", "stop", "hat"});
    }
}
