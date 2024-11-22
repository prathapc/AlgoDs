package com.practice.D_design.lld.deliveryfleetapp.models;

import com.practice.D_design.lld.deliveryfleetapp.enums.EmployeePosition;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {

  private List<Employee> reportees;

  public Manager(String name, int id, double salary, int rating, String city, EmployeePosition employeePosition) {
    super(name, id, salary, rating, city, employeePosition);
  }

  @Override
  public void printHierarchy() {
    System.out.println();
    System.out.println(this.getEmployeePosition() +" "+ this.getName());
    System.out.println("--------------------");
    this.getReportees().stream().forEach(reportee -> System.out.println(reportee.getEmployeePosition().name()+" : "+ reportee.getName()));
  }

  public List<Employee> getReportees() {
    return reportees;
  }

  public void addReporter(Employee reportiee) {
    if(this.reportees == null) {
      this.reportees = new ArrayList<>();
    }
    reportees.add(reportiee);
  }
}
