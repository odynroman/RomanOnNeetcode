package com.romanonneetcode.arraysandhashing;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://neetcode.io/problems/string-encode-and-decode">https://neetcode.io/problems/string-encode-and-decode</a>
 */
public class StringEncodeAndDecode {
    private final static String DELIMITER = "#";

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            result.append(strs.get(i).length())
                    .append(DELIMITER)
                    .append(strs.get(i));
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new LinkedList<>();

        int len = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).equals(DELIMITER)) {
                result.add(str.substring(i + 1, i + len + 1));
                i = i + len;
                len = 0;
            } else {
                len = len * 10 + Integer.parseInt(str.substring(i, i + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> strings = List.of("neet", "code");
        StringEncodeAndDecode solution = new StringEncodeAndDecode();

        boolean result = solution.decode(solution.encode(strings))
                .equals(strings);

        System.out.println(result);
    }
}
