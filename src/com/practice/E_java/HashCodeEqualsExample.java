package com.practice.E_java;

/**
 * Created by prathap on 11/07/17.
 */
public class HashCodeEqualsExample {
  public static void main(String[] args) {
    Employee student1 = new Employee("pratap", 27);
    Employee student2 = new Employee("pratap", 27);
    System.out.print(student1.equals(student2));
  }

  static class Employee {
    private String name;
    private Integer age;

    public Employee(String name, int age) {
      this.name = name;
      this.age = age;
    }

    public int getAge() { return age;}

    public String getName() { return name;}

    public String toString() {
      return name + ":" + age;
    }

    @Override
    public int hashCode() {
      int result = 17;
      result = 31 * result + age;
      result = 31 * result + name.hashCode();
      return result;
    }

    @Override
    public boolean equals(Object object) {
      if(object == this) return true;
      if(!(object instanceof Employee)) return false;
      Employee employee = (Employee) object;
      return (employee.getAge() == this.getAge() && employee.getName().equals(this.getName()));
    }
  }
}



