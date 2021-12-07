package com.practice.E_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by prathap on 11/07/17.
 */
public class ComparatorExample {
  public static void main(String[] args) {
    Student student1 = new Student("pratap", 27);
    Student student2 = new Student("abc", 25);
    List<Student> listOfStudents = new ArrayList<>();
    listOfStudents.add(student1);
    listOfStudents.add(student2);

    System.out.print(listOfStudents.toString());
    Collections.sort(listOfStudents, new AgeComparer());
    System.out.print(listOfStudents.toString());
  }

}

class Student {
  private String name;
  private Integer age;

  public Student(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public int getAge() { return age;}

  public String getName() { return name;}

  public String toString() {
    return name + ":" + age;
  }
}

class AgeComparer implements Comparator<Student> {

  public int compare(Student student1, Student student2) {
    return student1.getAge() - student2.getAge();
  }
}

class NameComparer implements Comparator<Student> {

  public int compare(Student student1, Student student2) {
    return student1.getName().compareTo(student2.getName());
  }
}
