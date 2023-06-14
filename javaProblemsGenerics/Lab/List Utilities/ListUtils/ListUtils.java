package ListUtils;

import java.util.Collections;
import java.util.List;

public class ListUtils {
    public static <T extends Comparable<T>> T getMin(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return Collections.min(list);
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty!");
        }
        return Collections.max(list);
    }
}



/*package ListUtils;

import java.util.Collections;
import java.util.List;

public class ListUtils {
    //The class should have two static methods:
    //•	T getMin(List<T> list)
    //•	T getMax(List<T> list)

    public static <T extends Comparable <T>> T getMin (List<T> list) throws IllegalAccessException {
        if (list.isEmpty()){
            throw new IllegalAccessException();
        }
        return Collections.min(list);
    }


    public static <T extends Comparable <T>> T getMax (List<T> list) throws IllegalAccessException {
        if (list.isEmpty()){
            throw new IllegalAccessException();
        }
        return Collections.max(list);
    }
}

 */
