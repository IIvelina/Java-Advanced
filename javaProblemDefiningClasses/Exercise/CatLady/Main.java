package CatLady;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        HashMap<String, StreetExtraordinaire> mapStreetExtraordinaire = new HashMap<>();
        HashMap<String, Siamese> mapSiamese = new HashMap<>();
        HashMap<String, Cymric> mapCymric = new HashMap<>();


        while (!input.equals("End")){
            String[] data = input.split("\\s+");
            String type = data[0];
            String name = data[1];
            if (type.equals("StreetExtraordinaire")){
            double decibelsOfMeows = Double.parseDouble(data[2]);
            StreetExtraordinaire streetExtraordinaire = new StreetExtraordinaire(name, decibelsOfMeows);
            mapStreetExtraordinaire.put(name, streetExtraordinaire);
            }else if (type.equals("Cymric")){
                double furLength = Double.parseDouble(data[2]);
                Cymric cymric = new Cymric(name, furLength);
                mapCymric.put(name, cymric);
            }else if (type.equals("Siamese")){
                double earSize = Double.parseDouble(data[2]);
                Siamese siamese = new Siamese(name, earSize);
                mapSiamese.put(name, siamese);
            }

            input = scanner.nextLine();
        }
        String catName = scanner.nextLine();

        if (mapSiamese.containsKey(catName)){
            System.out.println(mapSiamese.get(catName).toString());
        }else if (mapStreetExtraordinaire.containsKey(catName)){
            System.out.println(mapStreetExtraordinaire.get(catName).toString());
        }else if (mapCymric.containsKey(catName)){
            System.out.println(mapCymric.get(catName).toString());
        }
    }
}
