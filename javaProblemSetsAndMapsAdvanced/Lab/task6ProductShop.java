package Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class task6ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Double>> map = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Revision")){
            String shop = input.split(", ")[0];
            String product = input.split(", ")[1];
            double price = Double.parseDouble(input.split(", ")[2]);

            if (!map.containsKey(shop)){
                map.put(shop, new LinkedHashMap<>());
                map.get(shop).put(product, price);
            }else {
                map.get(shop).put(product, price);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Double>> entry : map.entrySet()) {
            System.out.printf("%s->%n", entry.getKey());
            for (Map.Entry<String, Double> linkedHashMapEntry : entry.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", linkedHashMapEntry.getKey(), linkedHashMapEntry.getValue());
            }
        }
    }
}
