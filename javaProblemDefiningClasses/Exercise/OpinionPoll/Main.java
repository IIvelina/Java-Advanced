package OpinionPoll;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Person person;
       // Map<String,Integer> map = new TreeMap<>();

        List<Person> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
                person = new Person(name, age);
                list.add(person);
        }

        List<Person> filtered = list.stream()
                .filter(person1 -> person1.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());

       for (Person currentPerson : filtered) {
            System.out.println(currentPerson.getName() + " - " + currentPerson.getAge());
        }


    }
}
