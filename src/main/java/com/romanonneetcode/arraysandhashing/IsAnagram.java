package com.romanonneetcode.arraysandhashing;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://neetcode.io/problems/is-anagram">https://neetcode.io/problems/is-anagram</a>
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<String, Integer> sMap = charsStatMap(s);
        Map<String, Integer> tMap = charsStatMap(t);

        return sMap.equals(tMap);
    }

    public Map<String, Integer> charsStatMap(String s) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            String c = s.substring(i, i + 1);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        System.out.println(isAnagram.isAnagram("racecar", "carrace"));
        System.out.println(isAnagram.isAnagram("jar", "jam"));
    }
}
