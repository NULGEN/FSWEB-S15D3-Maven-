package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {

    private  static Map<Integer, Employee> employeeMap;
    private  static List <Employee> dublicatedEmployee;

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Ali", "Mercan"));
        employees.add(new Employee(1, "Ali", "Mercan"));
        employees.add(new Employee(1, "Ali", "Mercan"));
        employees.add(new Employee(2, "Mualla", "Tercan"));
        employees.add(new Employee(2, "Mualla", "Tercan"));
        employees.add(new Employee(3, "Mustafa", "Ercan"));
        employees.add(new Employee(4, "Hasan Ali", "Sürmeli"));
        employees.add(new Employee(5, "Süleyman", "Turan"));

        System.out.println(WordCounter.calculatedWord());


//
    }

    public static List<Employee> findDuplicates(List<Employee> employees){
       employeeMap = new HashMap<>();
       dublicatedEmployee = new LinkedList<>();

       Iterator<Employee> iterator = employees.iterator();
       while (iterator.hasNext()){
           Employee employee = iterator.next();
           if(employee==null) continue;
           if(employeeMap.containsKey(employee.getId())){
               dublicatedEmployee.add(employee);
           }
           else{
               employeeMap.put(employee.getId(), employee);
           }
       }
       return  dublicatedEmployee;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        employeeMap = new HashMap<>();

        Iterator<Employee> iterator = employees.iterator();

        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if(employee==null) continue;

            if(!employeeMap.containsKey(employee.getId())){
                employeeMap.put(employee.getId(), employee);
            }
        }

        return employeeMap;

    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
       List<Employee> dublicates = findDuplicates(employees);
       Map<Integer, Employee> uniques = findUniques(employees);
       List<Employee> onlyUnique = new LinkedList<>(uniques.values());

       onlyUnique.removeAll(dublicates);
       return  onlyUnique;

    }


}