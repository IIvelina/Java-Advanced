package Jar;


public class Main {
    public static void main(String[] args) {


        Jar<String> stringJar = new Jar<String>();

        stringJar.add("Iva");
        stringJar.add("Viki");
        stringJar.add("Bobi");

       String removed = stringJar.remove();
        System.out.println(removed);


        Jar<Integer> intJar = new Jar<Integer>();

        intJar.add(5);
        intJar.add(10);
        intJar.add(20);
        intJar.add(7);
        intJar.add(6);

        int removedInt = intJar.remove();
    }
}
