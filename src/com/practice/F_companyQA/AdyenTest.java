package com.practice.F_companyQA;

/**
 * Created by Prathap on 12 Jan, 2020
 */
public class AdyenTest {
    /*int A[] = new int[]{1, 1, 3, 3, 4, 5, 5, 9};
        int Y = 3;
        Map<Integer, Integer> nails = new HashMap<>();
        for (int i=0; i<A.length; i++) {
            nails.put(A[i], nails.getOrDefault(A[i], 0)+1);
        }

        int result = 0, max = -1;
        for (Map.Entry<Integer, Integer> entry : nails.entrySet()) {
            int weight = entry.getValue() > Y ? Y*entry.getKey(): entry.getValue()*entry.getKey();
            if (weight > max) {
                max = weight;
                result = entry.getKey();;
            }
        }

        System.out.println(result);*/


        /*
        SELECT t.name, sum(t.deposits) as sum_of_deposits, sum(t.withdrawls) as  sum_of_withdrawals from (
                select name,
                CASE WHEN money > 0 THEN money ELSE 0 END as deposits,
                CASE WHEN money < 0 THEN money*-1 ELSE 0 END as withdrawls
        from transfers) t group by t.name order by t.name;
        */

        /*
        -- Code review and fix bug
        Stream<PendingTransaction> reconcile(Stream<PendingTransaction> pending, Stream<Stream<ProcessedTransaction>> processed) {
        if(pending == null || processed == null) {
            return Stream.empty();
        }
        Stream<Long>  filteredProcessedId = processed
                .flatMap(p -> p)
                .filter(Objects::nonNull)
                .filter(p -> p.getStatus() != null && "DONE".equalsIgnoreCase(p.getStatus().orElse(null)))
                .filter(p -> p.getId() != null && p.getId().length() > 0)
                .map(p -> Long.parseLong(p.getId()));

        if(filteredProcessedId == null) {
            return Stream.empty();
        }

        Set<Long> processedIds = filteredProcessedId.collect(Collectors.toSet());
        //return pending.filter(p -> filteredProcessedId.anyMatch(pr -> pr.equals(p.getId())));

        return pending.filter(p -> processedIds.contains(p.getId()));
        }
         */

}
