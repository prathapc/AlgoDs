package com.practice.A_ds.G_graphs;

import java.util.*;

/**
 * Created by prathapchowdary on 28/11/21.
 */
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Set<String>>> data = new HashMap<>();

        for (List<String> nameAndemails : accounts) {
            String name = nameAndemails.get(0);
            if (!data.containsKey(name)) {
                List<Set<String>> listOfEmailsSet = new ArrayList<>();
                Set<String> emails = new HashSet<>();
                for (int i=1; i<nameAndemails.size(); i++) {
                    emails.add(nameAndemails.get(i));
                }
                listOfEmailsSet.add(emails);
                data.put(name, listOfEmailsSet);
            } else {
                List<Set<String>> existingSets = data.get(name);
                Set<String> temp = null;
                Set<String> newEmails = new TreeSet<>();
                int index = -1, c=0;
                for (int i=1; i<nameAndemails.size(); i++) {
                    for (Set<String> emailSet : existingSets) {
                        if (emailSet.contains(nameAndemails.get(i))) {
                            temp = new HashSet<>(emailSet);
                            index = c;
                        }
                        c++;
                    }
                    newEmails.add(nameAndemails.get(i));
                }
                if (temp != null) {
                    newEmails.addAll(temp);
                    existingSets.set(index, newEmails);
                } else {
                    existingSets.add(newEmails);
                }
                data.put(name, existingSets);
            }
        }

        List<List<String>> result = new ArrayList<>();
        List<String> temp = null;
        for (Map.Entry<String, List<Set<String>>> entry : data.entrySet()) {
            List<Set<String>> emailSets = entry.getValue();
            for (Set<String> emailSet : emailSets) {
                temp = new ArrayList<>();
                temp.add(entry.getKey());
                for (String email : emailSet) {
                    temp.add(email);
                }
                result.add(temp);
            }
        }
        return result;
    }
}
