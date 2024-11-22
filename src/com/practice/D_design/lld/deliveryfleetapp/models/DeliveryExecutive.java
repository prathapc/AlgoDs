package com.practice.D_design.lld.deliveryfleetapp.models;

import com.practice.D_design.lld.deliveryfleetapp.enums.EmployeePosition;

public class DeliveryExecutive extends Employee {

  private Employee fleetManager;

  public DeliveryExecutive(Employee fleetManager,
                           String name, int id, double salary, int rating, String city, EmployeePosition employeePosition) {
    super(name, id, salary, rating, city, employeePosition);
    this.fleetManager = fleetManager;
  }

  @Override
  public void printHierarchy() {}

  @Override
  public void addReporter(Employee employee) {
    this.fleetManager = employee;
  }
}