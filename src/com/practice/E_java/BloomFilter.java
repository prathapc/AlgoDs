package com.practice.E_java;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;

/**
 * Created by prathapchowdary on 01/09/23.
 *
 * A Bloom filter is a space-efficient probabilistic data structure that’s used to test whether an element is a member of a set.
 * When you ask a Bloom filter if it remembers a specific item, it will answer either “probably yes” or “definitely no.”
 *
 * real world ex:
 * 1. Big data systems like Apache Cassandra and HBase use Bloom filters for quick data retrieval.
 * Instead of doing a slow disk read every time they need to check if specific data exists, these databases use a Bloom filter for a quick first check.
 * The Bloom filter has a smaller memory footprint, which makes this operation much faster.
 *
 * 2. Google Chrome uses a Bloom filter to protect you from harmful URLs. Whenever you try to access a URL,
 * Google Chrome first checks with a local Bloom filter in your browser. This filter is filled with a list of hashed malicious URLs.
 * If the Bloom filter returns “probably yes,” Chrome reaches out to Google’s servers for further verification.
 * If the Bloom filter says “definitely no,” Chrome doesn’t bother with the server check, saving you time and preserving server resources.
 */
public class BloomFilter {
    private BitSet bitSet;
    private int bitSetSize;
    private int numOfHashFunctions;

    public BloomFilter(int size, int numOfHashFunctions) {
        this.bitSetSize = size;
        this.numOfHashFunctions = numOfHashFunctions;
        this.bitSet = new BitSet(bitSetSize);
    }

    // Add element to Bloom Filter
    public void add(String url) throws NoSuchAlgorithmException {
        for (int i = 0; i < numOfHashFunctions; i++) {
            int hashCode = getHash(url, i);
            bitSet.set(Math.abs(hashCode % bitSetSize));
        }
    }

    // Check if element is present in Bloom Filter
    public boolean mightContain(String url) throws NoSuchAlgorithmException {
        for (int i = 0; i < numOfHashFunctions; i++) {
            int hashCode = getHash(url, i);
            if (!bitSet.get(Math.abs(hashCode % bitSetSize))) {
                return false; // Definite NO
            }
        }
        return true;  //Probable YES
    }

    // Computes the i-th hash function for the given URL
    private int getHash(String url, int i) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i).array());
        md5.update(url.getBytes());
        byte[] digest = md5.digest();
        int hash = ByteBuffer.wrap(digest).getInt();
        return hash;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        BloomFilter bloomFilter = new BloomFilter(1000000, 3);

        // Add some URLs to the Bloom filter
        bloomFilter.add("http://example1.com");
        bloomFilter.add("http://example2.com");

        // Check if URLs are present in the Bloom filter
        System.out.println(bloomFilter.mightContain("http://example1.com")); // Outputs: true
        System.out.println(bloomFilter.mightContain("http://example3.com")); // Outputs: false
    }
}
