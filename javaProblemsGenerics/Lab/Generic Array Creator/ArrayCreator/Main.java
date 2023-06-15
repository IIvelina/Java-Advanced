package ArrayCreator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] array1 = ArrayCreator.create(5, 10);  // Creates an Integer array of length 5 with default item 10
        System.out.println(Arrays.toString(array1));    // Output: [10, 10, 10, 10, 10]

        String[] array2 = ArrayCreator.create(String.class, 3, "Hello");  // Creates a String array of length 3 with default item "Hello"
        System.out.println(Arrays.toString(array2));                      // Output: ["Hello", "Hello", "Hello"]
    }
}
