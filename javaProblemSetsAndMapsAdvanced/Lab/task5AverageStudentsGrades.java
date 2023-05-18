package Lab;

import java.util.*;

public class task5AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[]arr = scanner.nextLine().split("\\s+");
            String name = arr[0];
            double grade = Double.parseDouble(arr[1]);

            map.putIfAbsent(name, new ArrayList<>());
            map.get(name).add(grade);

            /*
            if (!studentsMap.containsKey(name)) {
                studentsMap.put(name, new ArrayList<>());
                studentsMap.get(name).add(grade);
            } else {
                studentsMap.get(name).add(grade);
            }
             */
        }
        for (Map.Entry<String, List<Double>> student : map.entrySet()) {
            double sumAverage = 0;
            int averageCount = 0;
            System.out.printf("%s -> ", student.getKey());
            for (int i = 0; i < student.getValue().size(); i++) {
                System.out.printf("%.2f ", student.getValue().get(i));
                averageCount++;
                sumAverage += student.getValue().get(i);
            }
            System.out.printf("(avg: %.2f)", sumAverage / averageCount);
            System.out.println();
        }
    }
}
