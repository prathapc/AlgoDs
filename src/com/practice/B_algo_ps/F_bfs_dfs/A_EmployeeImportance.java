package com.practice.B_algo_ps.F_bfs_dfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created by prathapchowdary on 04/07/23.
 *
 * You have a data structure of employee information, including the employee's unique ID,
 * importance value, and direct subordinates' IDs.
 *
 * You are given an array of employees employees where:
 *
 * employees[i].id is the ID of the ith employee.
 * employees[i].importance is the importance value of the ith employee.
 * employees[i].subordinates is a list of the IDs of the direct subordinates of the ith employee.
 * Given an integer id that represents an employee's ID, return the total importance value of
 * this employee and all their direct and indirect subordinates.
 *
 * https://leetcode.com/problems/employee-importance/
 */
public class A_EmployeeImportance {

  Map<Integer, Employee> emap;
  public int getImportance(List<Employee> employees, int queryid) {
    emap = new HashMap();
    for (Employee e: employees) emap.put(e.id, e);
    return dfs(queryid);
  }
  public int dfs(int eid) {
    Employee employee = emap.get(eid);
    int ans = employee.importance;
    for (Integer subid: employee.subordinates)
      ans += dfs(subid);
    return ans;
  }

  public int getImportance_bfs(List<Employee> employees, int id) {
    int result = 0;
    Map<Integer, Employee> m = new HashMap<>();
    Queue<Employee> q = new LinkedList<>();

    for (int i=0; i<employees.size(); i++){
      m.put(employees.get(i).id, employees.get(i));
    }
    q.add(m.get(id));

    while(!q.isEmpty()){
      Employee e = q.poll();
      for(int i=0; i<e.subordinates.size();i++){
        q.add(m.get(e.subordinates.get(i)));
      }
      result += e.importance;
    }

    return result;
  }

  class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
  };
}
