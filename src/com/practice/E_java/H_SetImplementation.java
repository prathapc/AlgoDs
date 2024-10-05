package com.practice.E_java;

import org.junit.*;
import org.junit.Test;

import java.util.*;

/**
 * Created by prathapchowdary on 17/09/22.
 */
public class H_SetImplementation {
    interface ISet<T> {
        void Push(T t) throws IllegalArgumentException;
        T Pop() throws NoSuchElementException;
        T Remove(T t) throws NoSuchElementException, IllegalArgumentException;
        ISet<T> Intersect(ISet<T> otherSet) throws IllegalArgumentException;
        Iterable<T> Values();
        Iterable<T> OrderedValues(boolean firstToLast);
        Integer Size();
    }

    class MySet<T> implements ISet<T> {
        private final ArrayList<T> store = new ArrayList<>();
        @Override
        public void Push(T t) throws IllegalArgumentException {
            if (t == null)
                throw new IllegalArgumentException();
            if (store.stream().noneMatch(e -> e.equals(t)))
                store.add(t);
        }

        @Override
        public T Pop() throws NoSuchElementException {
            return null;
        }

        @Override
        public T Remove(T t) throws NoSuchElementException, IllegalArgumentException {
            return null;
        }

        @Override
        public ISet<T> Intersect(ISet<T> otherSet) throws IllegalArgumentException {
            return null;
        }

        @Override
        public Iterable<T> Values() {
            return null;
        }

        @Override
        public Iterable<T> OrderedValues(boolean firstToLast) {
            return null;
        }

        @Override
        public Integer Size() {
            return store.size();
        }
    }

    public class FoodPandaTest {
        @org.junit.Test(expected = IllegalArgumentException.class)
        public void Test_Push_Integer_Null() {
            ISet<Integer> set = new MySet<>();
            set.Push(null);
        }
        @org.junit.Test
        public void Test_Push_Integer_Valid() {
            ISet<Integer> set = new MySet<>();
            set.Push(1);
            Assert.assertEquals(Optional.ofNullable(set.Size()), 1);
        }
        @Test
        public void Test_Push_Integer_Uniqueness() {
            ISet<Integer> set = new MySet<>();
            set.Push(1);
            set.Push(1);
            Assert.assertEquals(Optional.ofNullable(set.Size()), 1);
        }
    }
}
