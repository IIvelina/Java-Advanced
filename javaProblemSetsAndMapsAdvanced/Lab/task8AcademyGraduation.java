package Lab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class task8AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            List<Double> scores = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());

            if (!map.containsKey(name)){
                    map.put(name, scores);
                }else {
                    map.get(name).addAll(scores);
                }
            }

        DecimalFormat df = new DecimalFormat("0.###############");

        for (Map.Entry<String, List<Double>> entry : map.entrySet()) {
            double sum = 0;
            double average = 0;
            int count = 0;
            System.out.printf("%s is graduated with ", entry.getKey());
            for (int i = 0; i < entry.getValue().size(); i++) {
                sum += entry.getValue().get(i);
                count++;
            }
            average = sum / count;
            System.out.printf(String.format("%s", average));
            sum = 0;
            count = 0;
            average = 0;
            System.out.println();
        }
    }
}
