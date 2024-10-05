package com.practice.E_java;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by prathapchowdary on 21/11/23.
 *
 * LinkedIn@21Nov2023
 */
public class ImplementCacheByRank {

    /*public class RetainBestCache<K, V extends Rankable> {
        // Add any fields you need here

        *//**
         * Constructor with a data source (assumed to be slow) and a cache size
         * @param ds the persistent layer of the the cache
         * @param capacity the number of entries that the cache can hold
         *//*
        Queue<Data> rankPriorityQueue = null;
        Map<Integer, Data> dataMap = null;
        int capacity;
        DataSource<K, V> ds = null;
        public RetainBestCache(DataSource<K, V> ds, int capacity) {
            // Implementation here
            rankPriorityQueue = new PriorityQueue<>((d1, d2) -> (d1.rank-d2.rank));
            dataMap = new HashMap<>();
            capacity = this.capacity;
            ds = this.ds;
        }

        *//**
         * Gets some data. If possible, retrieves it from cache to be fast. If the data is not cached,
         * retrieves it from the data source and, if possible, cache it. If the cache is full, attempt
         to cache the returned data,
         * evicting the V with lowest rank among the ones that it has available
         * If there is a tie, the cache may choose any V with lowest rank to evict.
         * @param key the key of the cache entry being queried
         * @return the Rankable value of the cache entry
         *//*
        public V get(K key) {
            // Implementation here
            //get(2) - 2
            //get(1) - 1 -> low rank
            //get(5) - 5
            //get(3) - 3

            if (dataMap.containsKey(key)) {
                return dataMap.get(key).value;
            } else {
                //get data from ds
                V sourceData = ds.get(key);

                //insert into queue & map
                Data d = new Data(key, sourceData.getVal(), sourceData.getRank());

                synchronized(rankPriorityQueue) {
                    rankPriorityQueue.offer(d);

                    //check capacity breach
                    //evict if required
                    if (rankPriorityQueue.size() > capacity) {
                        Data evictedData = evict();
                        dataMap.remove(evictedData.key);
                    }
                }

                //synchronized
                dataMap.put(key, d);

                //return data
                if (dataMap.containsKey(key)) {
                    return dataMap.get(key).value;
                } else {
                    return sourceData.getVal();
                }

            }



        }

        private Data evict() {
            Data toBeEvicted = rankPriorityQueue.poll();
            return toBeEvicted;
        }

        class Node {
            Data data;
            long timestamp;

        }
        class Data {
            int key;
            int value;
            long rank;

            public Data(int key, int value, long rank) {
                this.key = key;
                this.value = value;
                this.rank = rank;
            }
        }

    }

    *//*
     * For reference, here are the Rankable and DataSource interfaces.
     * You do not need to implement them, and should not make assumptions
     * about their implementations.
     *//*

    public interface Rankable {
        *//**
         * Returns the Rank of this object, using some algorithm and potentially
         * the internal state of the Rankable.
         *//*
        long getRank();
        int getVal();
    }

    public interface DataSource<K, V extends Rankable> {
        V get (K key);
    }*/
}
