package Exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class exam22october2022task2RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); //брой редове = брой колони
        String carNumber = scanner.nextLine();

        int km = 0; //изминати км от колата

        String[][]trace = new String[n][n];

        fillMatrix(trace, scanner);

        int currentRowCar = 0; //ред, на който се намира колата
        int currentColCar = 0; //колона, на която се намира колата

        //да намерим тунелите, като винаги имаме 2 тунела
        //първия тунел на кой ред и на коя колона е
        //вротия тунел на кой ред е и на коя колона е
        ////лист за координатите на първия тунел -> ред на първи тунел и колона на първи тунел или да ги държим в променливи
        ////лист за координатите на втория тунел -> ред на втори тунел и колона на втори тунел или да ги държим в променливи
        //или list с 4 елемента -> 1ви елемент (ред на тунел1), 2-ри елемент (колона на тунел1)
                                    //3ти елемент (ред на тунел2) и 4-ти елемент (колона на тунел2)

        List<Integer> tunnelsCoordinates = new ArrayList<>();
        findTunnels(trace, tunnelsCoordinates);

        //започваме движение
        String direction = scanner.nextLine();

        int countTunnels = 0;

        while (!direction.equals("End")){

            switch (direction){
                case "left":
                    currentColCar--;
                    break;
                case "right":
                    currentColCar++;
                    break;
                case "up":
                    currentRowCar--;
                    break;
                case "down":
                    currentRowCar++;
                    break;
            }
            //currentRowCar, currentColCar -> къде се намира колата
            //там където е преместена какво има?

            String movePlace = trace[currentRowCar][currentColCar]; //место по трасето, на което сме се преместили

            if (".".equals(movePlace)) {
                km = km + 10; //km+=10
            } else if ("F".equals(movePlace)) {
                System.out.printf("Racing car %s finished the stage!", carNumber);
                km += 10;
                break;
            } else if ("T".equals(movePlace)) {
                //стигаме тунел
                countTunnels++;
                if (countTunnels == 1){
                    //отиваме на другия тунел
                    //кординати на колата да станат равни на координатите на втория тунел
                    currentRowCar = tunnelsCoordinates.get(2);
                    currentColCar = tunnelsCoordinates.get(3);
                    km += 30;
                    //заместваме тунелите с точка, защото вече сме преминали
                    trace[tunnelsCoordinates.get(0)][tunnelsCoordinates.get(1)] = ".";
                    trace[tunnelsCoordinates.get(2)][tunnelsCoordinates.get(3)] = ".";
                }
            }
            direction = scanner.nextLine();
        }

        if (direction.equals("End")){
            System.out.printf("Racing car %s DNF.", carNumber);
        }
        System.out.println();
        System.out.printf("Distance covered %d km.", km);
        System.out.println();

        //там където е колата да слагаме C
        trace[currentRowCar][currentColCar] = "C";

        printMatrix(trace);

    }

    private static void findTunnels(String[][] trace, List<Integer> tunnelsCoordinates) {
        for (int r = 0; r < trace.length; r++) {
            for (int c = 0; c < trace.length; c++) {
                if (trace[r][c].equals("T")){
                    tunnelsCoordinates.add(r);
                    tunnelsCoordinates.add(c);
                }
            }
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner){
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }

    private static void printMatrix(String[][]matrix){
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
