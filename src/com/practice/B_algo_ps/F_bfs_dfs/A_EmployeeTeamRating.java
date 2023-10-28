package com.practice.B_algo_ps.F_bfs_dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;

/**
 * Created by prathapchowdary on 04/07/23.
 *
 * Company xyz.com has an organizational structure such that each employee in the company can have at most one manager
 * and may have many subordinates. The company recently conducted their quarterly performance review cycle and each employee has received a performance rating.
 *
 * An example structure is as follows:
 *
 *           A(5)
 *  B(3)                    C(1)
 *
 *                 D(4)             E(10)
 * A is the manager of B and C
 * C is the manager of D and E
 * Performance ratings are mentioned in brackets
 * Now given the employee information of a company, return the employee whose team has the highest performance rating average.
 * A team is defined as a group consisting of an employee and all their subordinates (not just the direct ones).
 * Sample input/output:
 * Input format: [employee name, rating, List]
 * data = [['A', 5, ['B', 'C']], ['B', 3, []], ['C', 2, ['D', 'E']], ['D', 4, []], ['E', 10, []]
 * Output: E
 *
 * https://leetcode.com/discuss/interview-question/1650545/Rippling-or-SE-or-DSAlgo-Round-orHighest-performing-rating-employee-team/
 *
 */
public class A_EmployeeTeamRating {

  public static void main(String[] args) {
    A_EmployeeTeamRating employeeRating = new A_EmployeeTeamRating();
    List<Employee> employees = new ArrayList<>();
    Employee A = new Employee("A", 5, new ArrayList<>(Arrays.asList(new String[]{"B", "C"})));
    Employee B = new Employee("B", 3, new ArrayList<>());
    Employee C = new Employee("C", 2, new ArrayList<>(Arrays.asList(new String[]{"D", "E"})));
    Employee D = new Employee("D", 4, new ArrayList<>());
    Employee E = new Employee("E", 10, new ArrayList<>());
    employees.add(A);
    employees.add(B);
    employees.add(C);
    employees.add(D);
    employees.add(E);
    Assert.assertEquals("E", employeeRating.getEmployeeWithHighestRatingAverage(employees));
  }

  private static class Employee {
    public String id;
    public int rating;
    public List<String> subordinates;

    public Employee(String id, int rating, List<String> subordinates) {
      this.id = id;
      this.rating = rating;
      this.subordinates = subordinates;
    }

    @Override
    public String toString() {
      return "Employee: {" + id + ", " + rating + ", " + subordinates + '}';
    }
  }


  private Map<String, Employee> employeeMap;

  public String getEmployeeWithHighestRatingAverage(List<Employee> employees) {
    employeeMap = new HashMap<>();
    for (Employee e : employees) {
      employeeMap.put(e.id, e);
    }
    //System.out.println(employeeMap);
    maxAverage(employees.get(0));
    return maxId;
  }

  private static double ans = 0.0;
  private static String maxId = null;

  private int[] maxAverage(Employee root) {
    //System.out.println(root);
    if (root.subordinates != null && root.subordinates.size() == 0) {
      //System.out.println("Leaf Node");
      if (root.rating > ans) {
        ans = root.rating;
        maxId = root.id;
      }
      //System.out.println("leaf ans:" + ans);
      return new int[]{root.rating, 1};
    }

    int[] childResult = new int[2];
    for (String id : employeeMap.get(root.id).subordinates) {
      int[] childTotal = maxAverage(employeeMap.get(id));
      childResult[0] += childTotal[0];
      childResult[1] += childTotal[1];
    }
    int sum = childResult[0] + root.rating;
    int count = childResult[1] + 1;

    if (sum * 1.0 / count > ans) {
      maxId = root.id;
      ans = sum * 1.0 / count;
      //System.out.println("non leaf ans:" + ans);
    }

    return new int[]{sum, count};
  }

}
