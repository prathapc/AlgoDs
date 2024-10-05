package com.practice.A_ds.G_graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Created by prathapchowdary on 15/12/23.
 *
 * https://leetcode.com/problems/reconstruct-itinerary/
 */
public class J_ReconstructItinerary {

    Map<String, Queue<String>> flights;
    LinkedList<String> path;
    public List<String> findItinerary(List<List<String>> tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();
        for (List<String> ticket : tickets) {
            flights.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            flights.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs("JFK");
        return path;
    }
    public void dfs(String departure) {
        Queue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty())
            dfs(arrivals.poll());
        path.addFirst(departure);
    }



    public static void main(String[] args) {
        List<List<String>> input = new ArrayList<>();
        //String[][] arr = {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
        String[][] arr = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        for (String[] row : arr) {
            input.add(Arrays.asList(row));
        }
        findItinerary1(input);
    }

    //traditional bfs with visited doesn't workf for all cases
    static List<String> result;
    public static List<String> findItinerary1(List<List<String>> tickets) {
        result = new ArrayList<>();
        Set<String> usedTickets = new HashSet<>();

        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            List<String> temp = graph.get(ticket.get(0));
            if (temp == null) {
                temp = new ArrayList<>();
            }
            temp.add(ticket.get(1));
            graph.put(ticket.get(0), temp);
        }

        findItineraryUtil(graph, "JFK", usedTickets);
        return result;
    }
    private static void findItineraryUtil(Map<String, List<String>> graph, String src, Set<String> usedTickets) {
        result.add(src);
        if (!graph.containsKey(src)) return;
        List<String> destinations = graph.get(src);
        List<String> openTickets = new ArrayList<>();

        for (String dest : destinations) {
            openTickets.add(src + ":" + dest);
        }
        openTickets.sort(Comparator.naturalOrder());
        for (String openTicket : openTickets) {
            if (!usedTickets.contains(openTicket)) {
                usedTickets.add(openTicket);
                findItineraryUtil(graph, openTicket.split(":")[1], usedTickets);
            }
        }
    }
}
