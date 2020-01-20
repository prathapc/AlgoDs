package com.practice.companyQA.booking;

import java.util.*;

public class SortHotelReviews {

    public static void main(String args[]) {
        String pasitiveKeywords = "breakfast beach citycenter location metro view staff price";
        String negativeKeywords = "not";
        List<Integer> hotelIds = new ArrayList<>(); //1 2 1 1 2
        hotelIds.add(1);
        hotelIds.add(2);
        hotelIds.add(1);
        hotelIds.add(1);
        hotelIds.add(2);
        List<String> reviews = new ArrayList<>();
        reviews.add("This hotel has a nice view of the citycenter. The location is perfect.");
        reviews.add("The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.");
        reviews.add("Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.");
        reviews.add("They said I couldn't take my dog and there were other guests with dogs! That is not fair.");
        reviews.add("Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.");

        int k = 2;

        Set<String> pasitiveKeywordsSet = new HashSet<>();
        Set<String> negativeKeywordsSet = new HashSet<>();

        String[] pasitiveKeywordsArray = pasitiveKeywords.split(" ");
        String[] negativeKeywordsArray = negativeKeywords.split(" ");

        for (String str : pasitiveKeywordsArray) {
            str = str.replace(",", "").replace(".", "");
            pasitiveKeywordsSet.add(str.trim().toLowerCase());
        }
        for (String str : negativeKeywordsArray) {
            str = str.replace(",", "").replace(".", "");
            negativeKeywordsSet.add(str.trim().toLowerCase());
        }

        Map<Integer, Integer> scores = new HashMap<>();
        for (int i=0; i<hotelIds.size(); i++) {
            int score = 0;
            if (scores.containsKey(hotelIds.get(i))) {
                score = scores.get(hotelIds.get(i));
            }
            String review = reviews.get(i);
            String[] wordsInReview = review.split(" ");
            Map<String, Integer> pasitiveKeywordsAndCountMap = new HashMap<>();
            Map<String, Integer> negativeKeywordsAndCountMap = new HashMap<>();
            for (String wordInReview : wordsInReview) {
                int c;
                wordInReview = wordInReview.replace(",", "").replace(".", "");
                wordInReview = wordInReview.trim().toLowerCase();
                if (pasitiveKeywordsSet.contains(wordInReview)) {
                    if (!pasitiveKeywordsAndCountMap.containsKey(wordInReview)) {
                        c = 0;
                    } else {
                        c = pasitiveKeywordsAndCountMap.get(wordInReview);
                    }
                    pasitiveKeywordsAndCountMap.put(wordInReview, c+1);
                    continue;
                }
                if (negativeKeywordsSet.contains(wordInReview)) {
                    if (!negativeKeywordsAndCountMap.containsKey(wordInReview)) {
                        c = 0;
                    } else {
                        c = negativeKeywordsAndCountMap.get(wordInReview);
                    }
                    negativeKeywordsAndCountMap.put(wordInReview, c+1);
                    continue;
                }
            }

            int tempScore = 0;
            for (Map.Entry<String, Integer> entry : pasitiveKeywordsAndCountMap.entrySet()) {
                tempScore += (3 * entry.getValue());
            }

            for (Map.Entry<String, Integer> entry : negativeKeywordsAndCountMap.entrySet()) {
                tempScore += (-1 * entry.getValue());
            }
            scores.put(hotelIds.get(i), score + tempScore);


        }

        scores = sortByValue(scores);

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : scores.entrySet()) {
            if (k-- == 0) {
                break;
            }
            System.out.println(entry.getKey() + " : " + entry.getValue());
            result.add(entry.getKey()); //in progress...
        }
    }

    private static Map<Integer, Integer> sortByValue(Map<Integer, Integer> unsortMap) {

        List<Map.Entry<Integer, Integer>> list =
                new LinkedList<Map.Entry<Integer, Integer>>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
