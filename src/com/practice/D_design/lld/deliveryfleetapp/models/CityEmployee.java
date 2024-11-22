package com.practice.D_design.lld.deliveryfleetapp.models;

import java.util.ArrayList;
import java.util.List;

public class CityEmployee {

  private String cityName;
  private List<Employee> employeeList;

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public List<Employee> getEmployeeList() {
    return employeeList;
  }

  public void addEmployee(Employee employee) {
    if(this.employeeList == null) {
      this.employeeList = new ArrayList<>();
    }
    this.employeeList.add(employee);
  }
}
