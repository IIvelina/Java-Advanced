package CompanyRoster;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
      //  double maxSalary = Double.MIN_VALUE;
       // String depWithMaxSalary = "";
        List<Employee>list = new ArrayList<>();
        List<Department> listDep = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Employee employee = null;
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];

            if (input.length == 4){
                employee = new Employee(name, salary, position, department);
            //    list.add(employee);

            }else if (input.length == 5){
              /*
              if (Character.isDigit(input[4].charAt(0))){
                    int age = Integer.parseInt(input[4]);
                    employee = new Employee(name, salary, position, department, age);
                    list.add(employee);
                }else {
                    String email = input[4];
                    employee = new Employee(name, salary, position, department, email);
                    list.add(employee);
                }
               */
                if (input[4].contains("@")){
                    String email = input[4];
                    employee = new Employee(name, salary, position, department, email);
                   // list.add(employee);
                }else {
                    int age = Integer.parseInt(input[4]);
                    employee = new Employee(name, salary, position, department, age);
                 //   list.add(employee);
                }
            }else if (input.length == 6){
                String email = input[4];
                int age = Integer.parseInt(input[5]);
                employee = new Employee(name, salary, position, department, email, age);
               // list.add(employee);
            }
            //вече имаме създаден служител и го добавяме в листа
            list.add(employee);
        /*
            if (maxSalary > salary){
                maxSalary = salary;
                depWithMaxSalary = department;
            }
         */
            //имаме ли такъв отдел
            //ако имаме такъв отдел - добавяме служителя
            //ако нямаме - създааме отдела

            //проверяваме дали има такъв департмът вече създаден
            boolean departmentExists = listDep.stream()
                    .anyMatch(dep -> dep.getName().equals(department));
            //ако нямаме такъв департмент го създаваме
            if(!departmentExists){
                //ако нямаме такъв отдел го създаваме
                Department departmentNew = new Department(department);
                //след като сме го създали го добавяме в нашите отдели
                listDep.add(departmentNew);
            }
            Department currentDepartment = listDep.stream()
                    .filter(d -> d.getName().equals(department))
                    .findFirst()
                    .get();

            currentDepartment.getEmployees().add(employee);
        }

        //Как да сметнем средна заплата?
        Department highestPayDep = listDep.stream()
                .max((f,s) -> Double.compare(f.calculateAverageSalary(),
                        s.calculateAverageSalary()))
                .get();

        System.out.printf("Highest Average Salary: %s%n", highestPayDep.getName());

        highestPayDep.getEmployees().stream()
                .sorted((f,s) -> Double.compare(s.getSalary(), f.getSalary()))
                .forEach(System.out::println);
    }
}
