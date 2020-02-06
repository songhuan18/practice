package com.sh.leetcode;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 示例：
 *
 * 输入:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * 输出: "ball"
 * 解释:
 * "hit" 出现了3次，但它是一个禁用的单词。
 * "ball" 出现了2次 (同时没有其他单词出现2次)，所以它是段落里出现次数最多的，且不在禁用列表中的单词。
 * 注意，所有这些单词在段落里不区分大小写，标点符号需要忽略（即使是紧挨着单词也忽略， 比如 "ball,"），
 * "hit"不是最终的答案，虽然它出现次数更多，但它在禁用单词列表中。
 *
 *
 * 说明：
 *
 * 1 <= 段落长度 <= 1000.
 * 1 <= 禁用单词个数 <= 100.
 * 1 <= 禁用单词长度 <= 10.
 * 答案是唯一的, 且都是小写字母 (即使在 paragraph 里是大写的，即使是一些特定的名词，答案都是小写的。)
 * paragraph 只包含字母、空格和下列标点符号!?',;.
 * 不存在没有连字符或者带有连字符的单词。
 * 单词里只包含字母，不会出现省略号或者其他标点符号。
 */
public class Solution2 {

    public static void main(String[] args) {
        String[] banned = new String[] {};
        String paragraph = "a, a, a, a, b,b,b,c, c";
//        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
//        String paragraph = "a.";
//        String paragraph = "Bob";
        String s = mostCommonWord(paragraph, banned);
        System.out.println(s);
    }

    private static String mostCommonWord(String paragraph, String[] banned) {
//        String regEx = "[!?',;.]";
//        Pattern pattern = Pattern.compile(regEx);
//        Matcher matcher = pattern.matcher(paragraph);
//        String s = matcher.replaceAll("");
//        String s = paragraph.replaceAll("!", "@")
//                .replaceAll("\\?", "@")
//                .replaceAll("'", "@")
//                .replaceAll(",", "@")
//                .replaceAll(";", "@")
//                .replaceAll("\\.", "@");
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < paragraph.length(); i++) {
//
//        }
        List<String> list = new ArrayList<>();
        String s = "";
        List<Character> specialStr = Arrays.asList('!', '?', '\'', ',', ';', '.', ' ');

        char[] chars = paragraph.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (specialStr.contains(chars[i])) {
                if (!"".equals(s)) {
                    list.add(s);
                }
                s = "";
            } else {
                s += chars[i];
            }
            if (i == chars.length - 1) {
                if (!"".equals(s)) {
                    list.add(s);
                }
            }
        }
        Map<String, Integer> map = new HashMap<>();
        for (String str : list) {
            map.put(str.toLowerCase(), map.getOrDefault(str.toLowerCase(), 0) + 1);
        }
        Map<String, Integer> result = map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (oldValue, newValue) -> newValue, LinkedHashMap::new));
        for (Map.Entry<String, Integer> m : result.entrySet()) {
            if (banned.length == 0) {
                return m.getKey();
            }
            for (int i = 0; i < banned.length; i++) {
                if (m.getKey().equals(banned[i])) {
                    break;
                } else if (i == banned.length - 1) {
                    return m.getKey();
                }
            }
        }
        return "";
    }
}
