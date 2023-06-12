package bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;

    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
//add(Employee employee) – adds an entity to the data if there is room for him/her.
    public void add(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }
//remove(String name) – removes an employee by given name, if such exists, and returns a bool
    public boolean remove(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)){
               this.employees.remove(employee);
               return true;
            }
        }
        return false;
    }

//getOldestEmployee() – returns the oldest employee
    public Employee getOldestEmployee() {
        return this.employees
                .stream()
                .max((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()))
                .get();
    }
//getEmployee(string name) – returns the employee with the given name.
    public Employee getEmployee(String name){
        return employees.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public int getCount(){
        return employees.size();
    }

    public String report(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Employees working at Bakery %s:", name)).append(System.lineSeparator());
        employees.forEach(e -> {
            builder.append(e).append(System.lineSeparator());
        });
        return builder.toString().trim();
    }

}
