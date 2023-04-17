package com.practice.A_ds.G_graphs.DisjointSets;

import java.util.*;

/**
 * Created by prathapchowdary on 14/01/22.
 *
 * https://leetcode.com/problems/accounts-merge/
 *
 * Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
 * Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
 */
public class F_AccountsMerge {

    Set<String> visited = new HashSet<>();
    Map<String, List<String>> adjacent = new HashMap<String, List<String>>();

    private void DFS(List<String> mergedAccount, String email) {
        visited.add(email);
        // Add the email vector that contains the current component's emails
        mergedAccount.add(email);

        if (!adjacent.containsKey(email)) {
            return;
        }

        for (String neighbor : adjacent.get(email)) {
            if (!visited.contains(neighbor)) {
                DFS(mergedAccount, neighbor);
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accountList) {
        int accountListSize = accountList.size();

        for (List<String> account : accountList) {
            int accountSize = account.size();

            // Building adjacency list
            // Adding edge between first email to all other emails in the account
            String accountFirstEmail = account.get(1);
            for (int j = 2; j < accountSize; j++) {
                String accountEmail = account.get(j);

                if (!adjacent.containsKey(accountFirstEmail)) {
                    adjacent.put(accountFirstEmail, new ArrayList<String>());
                }
                adjacent.get(accountFirstEmail).add(accountEmail);

                if (!adjacent.containsKey(accountEmail)) {
                    adjacent.put(accountEmail, new ArrayList<String>());
                }
                adjacent.get(accountEmail).add(accountFirstEmail);
            }
        }

        // Traverse over all th accounts to store components
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (List<String> account : accountList) {
            String accountName = account.get(0);
            String accountFirstEmail = account.get(1);

            // If email is visited, then it's a part of different component
            // Hence perform DFS only if email is not visited yet
            if (!visited.contains(accountFirstEmail)) {
                List<String> mergedAccount = new ArrayList<>();
                // Adding account name at the 0th index
                mergedAccount.add(accountName);

                DFS(mergedAccount, accountFirstEmail);
                Collections.sort(mergedAccount.subList(1, mergedAccount.size()));
                mergedAccounts.add(mergedAccount);
            }
        }

        return mergedAccounts;
    }

    //another solution - union find
    public List<List<String>> accountsMerge1(List<List<String>> accounts) {
        int size = accounts.size();

        UnionFind uf = new UnionFind(size);

        // prepare a hash with unique email address as key and index in accouts as value
        HashMap<String, Integer> emailToId = new  HashMap<>();
        for(int i = 0; i < size; i++) {
            List<String> details = accounts.get(i);
            for(int j = 1; j < details.size(); j++) {
                String email = details.get(j);

                // if we have already seen this email before, merge the account  "i" with previous account
                // else add it to hash
                if (emailToId.containsKey(email)) {
                    uf.union(i, emailToId.get(email));
                } else  {
                    emailToId.put(email, i);
                }
            }
        }

        // prepare a hash with index in accounts as key and list of unique email address for that account as value
        HashMap<Integer, List<String>> idToEmails = new HashMap<>();
        for(String key : emailToId.keySet()) {
            int root = uf.root(emailToId.get(key));

            if (!idToEmails.containsKey(root)) {
                idToEmails.put(root, new ArrayList<String>());
            }

            idToEmails.get(root).add(key);
        }

        // collect the emails from idToEmails, sort it and add account name at index 0 to get the final list to add to final return List
        List<List<String>> mergedDetails =  new ArrayList<>();
        for(Integer id : idToEmails.keySet()) {
            List<String> emails =  idToEmails.get(id);
            Collections.sort(emails);
            emails.add(0, accounts.get(id).get(0));

            mergedDetails.add(emails);
        }

        return  mergedDetails;
    }

    class UnionFind {
        int[] parent;
        int[] weight;

        public UnionFind(int num) {
            parent = new int[num];
            weight = new int[num];

            for(int i =  0; i < num; i++) {
                parent[i] = i;
                weight[i] = 1;
            }
        }

        public void union(int a, int  b) {
            int rootA = root(a);
            int rootB = root(b);

            if (rootA == rootB) {
                return;
            }

            if (weight[rootA] > weight[rootB]) {
                parent[rootB] = rootA;
                weight[rootA] += weight[rootB];
            } else {
                parent[rootA] = rootB;
                weight[rootB] += weight[rootA];
            }
        }

        public int root(int a) {
            if (parent[a] == a) {
                return a;
            }

            parent[a] = root(parent[a]);
            return parent[a];
        }
    }
}
