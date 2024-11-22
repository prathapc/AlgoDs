package com.practice.D_design.lld.deliveryfleetapp.models;

import com.practice.D_design.lld.deliveryfleetapp.enums.EmployeePosition;

public abstract class Employee {
  private String name;
  private int id;
  private double salary;
  private int rating;
  private String city;
  private EmployeePosition employeePosition;
  private double bonus;

  public Employee(String name, int id, double salary, int rating, String city,
      EmployeePosition employeePosition) {
    this.name = name;
    this.id = id;
    this.salary = salary;
    this.rating = rating;
    this.city = city;
    this.employeePosition = employeePosition;
  }

  public abstract void printHierarchy();

  public abstract void addReporter(Employee employee);

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public double getSalary() {
    return salary;
  }

  public int getRating() {
    return rating;
  }

  public String getCity() {
    return city;
  }

  public EmployeePosition getEmployeePosition() {
    return employeePosition;
  }

  public double getBonus() {
    return bonus;
  }

  public void setBonus(double bonus) {
    this.bonus = bonus;
  }

}
