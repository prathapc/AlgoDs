package com.practice.A_ds.D_heap;

import java.util.*;

/**
 * Created by prathapchowdary on 10/09/22.
 */
public class E_TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        //build count map
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        //add to list and sort
        List<WordCount> candidates = new ArrayList<>();
        for (var entry : count.entrySet()) {
            candidates.add(new WordCount(entry.getKey(), entry.getValue()));
        }

        //pick top k
        Queue<WordCount> h = new PriorityQueue<>(candidates);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(h.poll().word);
        }
        return result;
    }

    class WordCount implements Comparable<WordCount> {
        String word;
        Integer count;

        public WordCount(String word, Integer count) {
            this.word = word;
            this.count = count;
        }

        public int compareTo(WordCount other) {
            if (this.count == other.count) {
                return this.word.compareTo(other.word);
            }
            return other.count-this.count;
        }
    }
}
