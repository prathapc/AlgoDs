package com.practice.E_java;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by prathapchowdary on 21/10/23.
 */
public class Generics {

    /**
     * Adv:
     * 1/ code re-usability
     * 2/ compile time type checking
     * 3/ type safety
     * 4/ usage in collections
     *
     * Java type naming conventions:
     * E -> element
     * K -> key  V -> value
     * T -> type
     * N -> number
     * S, U, V -> 2nd, 3rd, 4th types
     */

    //can we have single class and accpting any type of data? here we go...
    public static class Printer<T> {
        private final T data;
        public Printer(T data) {
            this.data = data;
        }
        public void print() {
            System.out.println("print::: " + data);
        }
    }

    //we can even pass multiple types
    public class MultiPrinter<T, V> {
        private final T data1;
        private final V data2;
        public MultiPrinter(T data1, V data2) {
            this.data1 = data1;
            this.data2 = data2;
        }
        public void print() {
            System.out.println("print::: " + data1 + " : " + data2);
        }
    }

    public static void main(String[] args) {
        Printer<Integer> integerPrinter = new Printer<>(5);
        integerPrinter.print();

        Printer<String> stringPrinter = new Printer<>("Hello");
        stringPrinter.print();
    }

    //--------------------------------------------------------------------------

    //Bounded generics: Let’s say we have an AnimalPrinter class which can only print animal details.
    // No other objects are allowed to be used with it. How to achieve this?
    public static class Animal {
        private final String name;
        private final String color;
        private final Integer age;

        public Animal(String name, String color, Integer age) {
            this.name = name;
            this.color = color;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getColor() {
            return color;
        }

        public Integer getAge() {
            return age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Animal animal = (Animal) o;
            return Objects.equals(name, animal.name) && Objects.equals(color, animal.color) && Objects.equals(age, animal.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, color, age);
        }
    }

    public static class Cat extends Animal {
        public Cat(String name, String color, Integer age) {
            super(name, color, age);
        }
    }

    public static class Dog extends Animal {
        public Dog(String name, String color, Integer age) {
            super(name, color, age);
        }
    }

    public static class AnimalPrinter<T extends Animal> {
        private final T animalData;

        public AnimalPrinter(T animalData) {
            this.animalData = animalData;
        }

        public void print() {
            System.out.println("Name::: " + animalData.getName());
            System.out.println("Color::: " + animalData.getColor());
            System.out.println("Age::: " + animalData.getAge());
        }
    }
    /* we can access animalprinter as below:
    AnimalPrinter<Cat> animalPrinter1 = new AnimalPrinter<>(new Cat("Jim", "brown", 2));
    animalPrinter1.print();
    AnimalPrinter<Dog> animalPrinter2 = new AnimalPrinter<>(new Dog("Rocky", "black", 5));
    animalPrinter2.print();
     */

    //--------------------------------------------------------------------------


    //wildcards with generics:
    //represented by ? mark. we use them to refer to unknown type. This can be used as parameter type
    //with generics. Then it will accept any type.
    public static void printList(List<?> list) {
        System.out.println(list);
    }
    public static class wildCardDemo {
        public static void main(String[] args) {
            printList(
                Arrays.asList(
                    new Cat("Jim", "brown", 2),
                    new Dog("Rocky", "black", 5)
                )
            );
            printList(Arrays.asList(50, 60));
            printList(Arrays.asList(50.45, 60.78));
        }
    }

    //--------------------------------------------------------------------------

    //Generic methods:
    //Imagine we need a method which takes different data types and do something.
    // We can create a Generic method for this and reuse it.
    public static <T> void call(T data) {
        System.out.println(data);
    }
    //call("hello");
    //call(45);
    //call(15.67);
    //call(5L);
    //call(new Dog("Rocky", "black", 5));

    //we can return data as well:
    public static <T> T getData(T data) {
        return data;
    }

    //we can accept multiple data types also in generic method
    public static <T, V> void getMultiData(T data1, V data2) {
        System.out.println("data 1: " + data1);
        System.out.println("data 2: " + data2);
    }
    //getMultiData(50, "Shades of Grey");




}
