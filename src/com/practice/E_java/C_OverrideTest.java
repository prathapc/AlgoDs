package com.practice.E_java;

/**
 * Created by prathapchowdary on 10/08/22.
 */
class Animal {
    public void displayInfo() {
        System.out.println("I am an animal.");
    }
}

class Dog extends Animal {
    @Override
    public void displayInfo() {
        System.out.println("I am a dog.");
    }
}

class C_OverrideTest {
    public static void main(String[] args) {
        Dog d1 = new Dog();
        d1.displayInfo(); //I am a dog.

        Animal a1 = new Dog();
        a1.displayInfo(); //I am a dog.

        Animal a2 = new Animal();
        a2.displayInfo(); //I am an animal.

        /**
         * Note: to call super class method you need to use super.displayInfo()
         */
    }
}
