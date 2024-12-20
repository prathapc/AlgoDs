package com.practice.D_design.lld;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prathapchowdary on 08/22/23.
 */
public class B1_LFUCache_plain {
    class Node {
        int key, val, cnt;
        Node prev, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            cnt = 1;
        }
    }

    class DLList {
        Node head, tail;
        int size;
        DLList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        void add(Node node) {
            head.next.prev = node;
            node.next = head.next;
            node.prev = head;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size > 0) {
                Node node = tail.prev;
                remove(node);
                return node;
            }
            else return null;
        }
    }

    int capacity, size, min;
    Map<Integer, Node> nodeMap;
    Map<Integer, DLList> countToDllMap;
    public B1_LFUCache_plain(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        countToDllMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node == null) return -1;
        update(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        Node node;
        if (nodeMap.containsKey(key)) {
            node = nodeMap.get(key);
            node.val = value;
            update(node);
        }
        else {
            node = new Node(key, value);
            nodeMap.put(key, node);
            if (size == capacity) {
                DLList lastList = countToDllMap.get(min);
                nodeMap.remove(lastList.removeLast().key);
                size--;
            }
            size++;
            min = 1;
            DLList newList = countToDllMap.getOrDefault(node.cnt, new DLList());
            newList.add(node);
            countToDllMap.put(node.cnt, newList);
        }
    }

    private void update(Node node) {
        DLList oldList = countToDllMap.get(node.cnt);
        oldList.remove(node);
        if (node.cnt == min && oldList.size == 0) min++;
        node.cnt++;
        DLList newList = countToDllMap.getOrDefault(node.cnt, new DLList());
        newList.add(node);
        countToDllMap.put(node.cnt, newList);
    }
}