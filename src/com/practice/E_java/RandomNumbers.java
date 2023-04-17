package com.practice.E_java;

import java.util.Random;

/**
 * Created by prathapchowdary on 12/04/22.
 */
public class RandomNumbers {
    public static void main(String args[]) {
        // 1 way
        for (int i=0; i<10; i++) {
            //Math.random() generates random number from 0.0 to 0.999
            //Hence, Math.random()*5 will be from 0.0 to 4.999
            System.out.println((int) (Math.random() * 5));
        }

        //another way
        Random random = new Random();
        System.out.println(random.nextInt(10)); //0-9
        System.out.println(random.nextDouble() * 100); //0.00 to 99.99
    }
}
