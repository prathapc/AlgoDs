package com.practice.E_java;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by prathapchowdary on 23/12/21.
 *
 * Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.
 *
 * The words in paragraph are case-insensitive and the answer should be returned in lowercase.
 *
 *
 *
 * Example 1:
 *
 * Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 *
 * https://leetcode.com/problems/most-common-word/
 */
public class StreamsDemo {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = Arrays.stream(banned)
                .collect(Collectors.toSet());

        Map<String,Integer> count = new HashMap<>();

        Arrays.stream(paragraph.replaceAll("[^a-zA-Z0-9]+"," ").split(" "))
                .map(String::toLowerCase)
                // .peek(System.out::println)
                .filter(word -> !bannedSet.contains(word))
                .forEach(word -> count.put(word, count.getOrDefault(word,0)+1) );

        return count.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("");

    }
}
