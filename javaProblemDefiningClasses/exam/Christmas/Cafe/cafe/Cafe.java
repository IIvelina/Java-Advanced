package cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {
    private String name;
    private int capacity;

    private List<Employee>employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    //•	Method addEmployee(Employee employee) – adds an entity to the data if there is room for him/her.

    public void addEmployee(Employee employee){
        if (this.employees.size() < this.capacity){
            this.employees.add(employee);
        }
    }

    //•	Method removeEmployee(String name) – removes an employee by given name, if such exists, and returns a bool.

    public boolean removeEmployee(String name){
        return employees.removeIf(e -> e.getName().equals(name));
    }

    //•	Method getOldestEmployee() – returns the oldest employee.
    public Employee getOldestEmployee(){

        return employees.stream()
                .max(Comparator.comparingInt(Employee::getAge))
                .orElse(new Employee("", 0, ""));
        /*
        Employee oldest = new Employee("", 0, "");
        for (Employee employee : employees) {
            if (employee.getAge() > oldest.getAge()){
                oldest = employee;
            }
        }
        return oldest;
         */
    }

    //•	Method getEmployee(string name) – returns the employee with the given name.

    public Employee getEmployee(String name){

        return employees.stream()
                .filter(employee -> employee.getName().equals(name))
                .findFirst()
                .orElse(null);
        /*
        for (Employee employee : employees) {
            if (employee.getName().equals(name)){
                return employee;
            }
        }
        return null;
         */
    }

    //•	Getter getCount() – returns the number of employees.

    public int getCount(){
        return employees.size();
    }

    //•	report() – returns a string in the following format:
    //o	"Employees working at Cafe {cafeName}:
    //{Employee1}
    //{Employee2}
    //(…)"

    public String report(){
        return String.format("Employees working at Cafe %s:%n%s",
                this.name,
                employees.stream()
                        .map(Employee::toString)
                        .collect(Collectors.joining(System.lineSeparator())))
                .trim();
    }
}
