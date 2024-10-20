package program;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Employee class representing an employee with ID and salary
class Employee {
    private final int id;       // Employee ID
    private final double salary; // Employee salary

    public Employee(int id, double salary) {
        this.id = id;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }
}

// Department class representing a department with a name and a list of employees
class Department {
    private final String name;             // Department name
    private final List<Employee> employees; // List of employees in the department

    public Department(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}

public class SalaryWithDepartment {
    public static void main(String[] args) {
        // Creating employees
        Employee emp1 = new Employee(1, 50000);
        Employee emp2 = new Employee(2, 60000);
        Employee emp3 = new Employee(3, 70000);
        Employee emp4 = new Employee(4, 80000);
        Employee emp5 = new Employee(5, 90000);

        // Creating departments with employees
        Department dept1 = new Department("HR", Arrays.asList(emp1, emp2));
        Department dept2 = new Department("Finance", Arrays.asList(emp3, emp4));
        Department dept3 = new Department("IT", Arrays.asList(emp5));

        // List of departments
        List<Department> departments = Arrays.asList(dept1, dept2, dept3);

        // Example 1: Using map to get the total salary of each department
        List<Double> totalSalaries = departments.stream()
            .map(department -> department.getEmployees().stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum)) // Summing up salaries in the department
            .collect(Collectors.toList());

        // Printing total salaries per department
        System.out.println("Total Salaries by Department: " + totalSalaries);

        // Example 2: Using flatMap to get a flat list of all employee salaries
        List<Double> allSalaries = departments.stream()
            .flatMap(department -> department.getEmployees().stream()
                .map(Employee::getSalary)) // Flattening the salaries of all employees
            .collect(Collectors.toList());

        // Printing all salaries
        System.out.println("All Employee Salaries: " + allSalaries);


        List<String> list = Stream.of("one", "two", "three", "four")
                .filter(e -> e. length() > 3)
                .peek(e -> System. out. println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System. out. println("Mapped value: " + e))
                .limit(3)
                .collect(Collectors. toList());
        System.out.println(list);
    }
}
