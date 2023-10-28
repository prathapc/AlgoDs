package com.practice.E_java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by prathapchowdary on 01/08/23.
 *
 * Implement the RandomizedSet class:
 *
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 *
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 */
public class InsertDeleteGetrandom {

  Set<Integer> set = null;
  List<Integer> list = null;

  public InsertDeleteGetrandom() {
    set = new HashSet<>();
    list = new ArrayList<>();
  }

  public boolean insert(int val) {
    if (set.contains(val)) {
      return false;
    } else {
      set.add(val);
      list.add(val);
      return true;
    }
  }

  public boolean remove(int val) {
    if (set.contains(val)) {
      set.remove(val);
      list.remove(Integer.valueOf(val));
      return true;
    } else {
      return false;
    }
  }

  public int getRandom() {
    Random random = new Random();
    int randomIndex = random.nextInt(list.size());
    return list.get(randomIndex);
  }
}
