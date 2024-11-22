package com.practice.D_design.lld.deliveryfleetapp;

import com.practice.D_design.lld.deliveryfleetapp.enums.EmployeePosition;
import com.practice.D_design.lld.deliveryfleetapp.models.CityEmployee;
import com.practice.D_design.lld.deliveryfleetapp.models.DeliveryExecutive;
import com.practice.D_design.lld.deliveryfleetapp.models.Employee;
import com.practice.D_design.lld.deliveryfleetapp.models.Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DeliveryFleetApplication {

  public static List<Employee> listOfEmployee = new ArrayList<>();
  public static Map<String, CityEmployee> mapOfCityNameAndCityEmployees = new HashMap<>();

  static {
    initialiseData();
  }

  public static void main(String[] args) {
    printHierarchy(listOfEmployee);

    divideBonusToEmployees("Bangalore", 900);
    divideBonusToEmployees("Hyderabad", 1000);

    printTopBonusToSalaryRatioDes(listOfEmployee, 5);
  }

  public static void printHierarchy(List<Employee> employees) {
    employees.stream().forEach(employee -> employee.printHierarchy());
  }

  private static void divideBonusToEmployees(String city, double bonus) {
    System.out.println("\nBonus for city: " + city);
    System.out.println("-------------------------");
    for (Map.Entry<Employee, Double> employeeBonus : getMapOfEmployeeAndBonus(bonus, getEmployeeListByCityAndPosition(EmployeePosition.FLEET_MANAGER, city)).entrySet()) {
      System.out.println( "Employee name " + employeeBonus.getKey().getName() + " Position: " + employeeBonus.getKey().getEmployeePosition() + " Bonus: " + employeeBonus.getValue());
      Manager fleetManager = (Manager) employeeBonus.getKey();
      fleetManager.setBonus(employeeBonus.getValue());
      for (Map.Entry<Employee, Double> employeeBonus1 : getMapOfEmployeeAndBonus(employeeBonus.getValue(), fleetManager.getReportees()).entrySet()) {
        System.out.println("Employee name: " + employeeBonus1.getKey().getName() + " Position: " + employeeBonus1.getKey().getEmployeePosition() + " Bonus: " + employeeBonus1.getValue());
        employeeBonus1.getKey().setBonus(employeeBonus1.getValue());
      }
    }
  }

  private static Map<Employee, Double> getMapOfEmployeeAndBonus(double bonus, List<Employee> employees) {
    Map<Employee, Double> mapOfEmployeeBonus = new HashMap<>();
    int totalRating = employees.stream().mapToInt(Employee::getRating).sum();
    employees.stream().forEach(employee -> mapOfEmployeeBonus.put(employee, (bonus / totalRating) * employee.getRating()));
    return mapOfEmployeeBonus;
  }

  private static List<Employee> getEmployeeListByCityAndPosition(EmployeePosition employeePosition, String city) {
    return mapOfCityNameAndCityEmployees
        .get(city)
        .getEmployeeList()
        .stream()
        .filter(employee -> employee.getEmployeePosition().equals(employeePosition))
        .collect(Collectors.toList());
  }

  private static void printTopBonusToSalaryRatioDes(List<Employee> employees, int noOfTopEmployees) {
    Employee[] a = createHeapTree(employees);
    System.out.println("\n***** TOP DEs *****");
    topNLargestElements(a, noOfTopEmployees);
  }

  /*private static void printTopBonusToSalaryRatioDes(List<Employee> employees, int noOfTopEmployees) {
    TreeMap<Double, Employee> mapOfBonusSalaryRatio = getBonusSalaryRatio(employees);
    int count = 0;
    System.out.println("\n***** TOP DEs *****");
    for (Map.Entry<Double, Employee> employeeEntry : mapOfBonusSalaryRatio.entrySet()) {
      if (count++ < noOfTopEmployees) {
        System.out.println(employeeEntry.getValue().getName());
      }
    }
  }

  private static TreeMap<Double, Employee> getBonusSalaryRatio(List<Employee> employees) {
    TreeMap<Double, Employee> mapOfBonusSalaryRatio = new TreeMap<>();
    employees.stream().forEach(employee -> {
      if (employee.getEmployeePosition().equals(EmployeePosition.DELIVERY_EXECUTIVE)) {
        mapOfBonusSalaryRatio.put(employee.getBonus() / employee.getSalary(), employee);
      }
    });
    return mapOfBonusSalaryRatio;
  }*/

  private static Employee[] createHeapTree(List<Employee> employees) {
    List<Employee> deliveryExecutives = employees.stream().filter(employee -> employee.getEmployeePosition().equals(EmployeePosition.DELIVERY_EXECUTIVE)).collect(Collectors.toList());
    int n = deliveryExecutives.size();
    Employee[] a = new Employee[n];
    for(int i=0; i<n; i++) {
      a[i] = deliveryExecutives.get(i);
    }
    for(int i=1; i<a.length; i++) {
      buildHeap(a, i);
    }
    return a;
  }

  private static void buildHeap(Employee[] a, int i) {
    int parent;
    if(i == 0)
      return;
    if(i%2 == 0) {
      parent = (i-2)/2;
    } else {
      parent = (i-1)/2;
    }
    if((a[i].getBonus()/a[i].getSalary()) > (a[parent].getBonus()/a[parent].getSalary())) {
      swap(a, i, parent);
      buildHeap(a, parent);
    }
  }

  private static void swap(Employee[] a, int i, int parent) {
    Employee temp = a[parent];
    a[parent] = a[i];
    a[i] = temp;
  }

  private static void topNLargestElements(Employee[] a, int n) {
    for(int i=0; i<n; i++) {
      System.out.println(a[0].getName());
      a[0] = a[a.length-1];
      heapify(a, 0);
    }
  }

  private static void heapify(Employee[] a, int i) {
    if(2*i+2 < a.length) {
      double p = a[2*i+2].getBonus()/a[2*i+2].getSalary();
      double q = a[2*i+1].getBonus()/a[2*i+1].getSalary();
      double max = p > q ? p : q;
      if(max > (a[i].getBonus()/a[i].getSalary())) {
        if(p > q) {
          swap(a, 2*i+2, i);
          heapify(a, 2*i+2);
        } else {
          swap(a, 2*i+1, i);
          heapify(a, 2*i+1);
        }
      }
    } else if(2*i+1 < a.length) {
      if(a[2*i+1].getBonus()/a[2*i+1].getSalary() > a[i].getBonus()/a[i].getSalary()) {
        swap(a, 2*i+1, i);
        heapify(a, 2*i+1);
      }
    } else {
      return;
    }
  }

  private static void initialiseData() {
    Employee cityManager = new Manager("Prathap", 1, 26000, 5, "Bangalore", EmployeePosition.CITY_MANAGER);

    Employee fleetManager1 = new Manager("Uday", 2, 20000, 4, "Bangalore", EmployeePosition.FLEET_MANAGER);

    Employee deliveryExecutive1 = new DeliveryExecutive(fleetManager1, "John", 1, 15000, 4, "Bangalore", EmployeePosition.DELIVERY_EXECUTIVE);
    Employee deliveryExecutive2 = new DeliveryExecutive(fleetManager1, "Jacob", 2, 18000, 4, "Bangalore", EmployeePosition.DELIVERY_EXECUTIVE);
    fleetManager1.addReporter(deliveryExecutive1);
    fleetManager1.addReporter(deliveryExecutive2);

    Employee fleetManager2 = new Manager("Jaffar", 3, 22000, 5, "Bangalore", EmployeePosition.FLEET_MANAGER);

    Employee deliveryExecutive3 = new DeliveryExecutive(fleetManager2, "Edward", 4, 15000, 4, "Bangalore", EmployeePosition.DELIVERY_EXECUTIVE);
    Employee deliveryExecutive4 = new DeliveryExecutive(fleetManager2, "Jane", 5, 16000, 5, "Bangalore", EmployeePosition.DELIVERY_EXECUTIVE);

    fleetManager2.addReporter(deliveryExecutive3);
    fleetManager2.addReporter(deliveryExecutive4);

    cityManager.addReporter(fleetManager1);
    cityManager.addReporter(fleetManager2);


    Employee cityManager2 = new Manager("Veena", 6, 26000, 4, "Hyderabad", EmployeePosition.CITY_MANAGER);

    Employee fleetManager3 = new Manager("Pranav", 7, 20000, 3, "Hyderabad", EmployeePosition.FLEET_MANAGER);

    Employee deliveryExecutive5 = new DeliveryExecutive(fleetManager3, "Jessey", 8, 15000, 4, "Hyderabad", EmployeePosition.DELIVERY_EXECUTIVE);
    Employee deliveryExecutive6 = new DeliveryExecutive(fleetManager3, "Jared", 9, 18000, 5, "Hyderabad", EmployeePosition.DELIVERY_EXECUTIVE);
    fleetManager3.addReporter(deliveryExecutive5);
    fleetManager3.addReporter(deliveryExecutive6);

    Employee fleetManager4 = new Manager("Pulkit", 10, 22000, 5, "Bangalore", EmployeePosition.FLEET_MANAGER);

    Employee deliveryExecutive7 = new DeliveryExecutive(fleetManager4, "Amy", 11, 15000, 5, "Hyderabad", EmployeePosition.DELIVERY_EXECUTIVE);
    Employee deliveryExecutive8 = new DeliveryExecutive(fleetManager4, "Peter", 12, 16000, 3, "Hyderabad", EmployeePosition.DELIVERY_EXECUTIVE);
    Employee deliveryExecutive9 = new DeliveryExecutive(fleetManager4, "Anna", 13, 16000, 3, "Hyderabad", EmployeePosition.DELIVERY_EXECUTIVE);

    fleetManager4.addReporter(deliveryExecutive7);
    fleetManager4.addReporter(deliveryExecutive8);
    fleetManager4.addReporter(deliveryExecutive9);

    cityManager2.addReporter(fleetManager3);
    cityManager2.addReporter(fleetManager4);

    listOfEmployee.add(cityManager);
    listOfEmployee.add(fleetManager1);
    listOfEmployee.add(fleetManager2);
    listOfEmployee.add(deliveryExecutive1);
    listOfEmployee.add(deliveryExecutive2);
    listOfEmployee.add(deliveryExecutive3);
    listOfEmployee.add(deliveryExecutive4);
    listOfEmployee.add(cityManager2);
    listOfEmployee.add(fleetManager3);
    listOfEmployee.add(fleetManager4);
    listOfEmployee.add(deliveryExecutive6);
    listOfEmployee.add(deliveryExecutive7);
    listOfEmployee.add(deliveryExecutive8);
    listOfEmployee.add(deliveryExecutive9);

    CityEmployee cityEmployee1 = new CityEmployee();
    cityEmployee1.setCityName("Bangalore");
    cityEmployee1.addEmployee(cityManager);
    cityEmployee1.addEmployee(fleetManager1);
    cityEmployee1.addEmployee(fleetManager2);
    cityEmployee1.addEmployee(deliveryExecutive1);
    cityEmployee1.addEmployee(deliveryExecutive2);
    cityEmployee1.addEmployee(deliveryExecutive3);
    cityEmployee1.addEmployee(deliveryExecutive4);

    CityEmployee cityEmployee2 = new CityEmployee();
    cityEmployee2.setCityName("Hyderabad");

    cityEmployee2.addEmployee(cityManager2);
    cityEmployee2.addEmployee(fleetManager3);
    cityEmployee2.addEmployee(fleetManager4);
    cityEmployee2.addEmployee(deliveryExecutive5);
    cityEmployee2.addEmployee(deliveryExecutive6);
    cityEmployee2.addEmployee(deliveryExecutive7);
    cityEmployee2.addEmployee(deliveryExecutive8);
    cityEmployee2.addEmployee(deliveryExecutive9);

    mapOfCityNameAndCityEmployees.put(cityEmployee1.getCityName(), cityEmployee1);
    mapOfCityNameAndCityEmployees.put(cityEmployee2.getCityName(), cityEmployee2);
  }
}
