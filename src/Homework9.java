import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Homework9 {

    public static void main(String[] args) {
        System.out.println("Exercise 1: ---------------------------------------------------------------------");
        int transitionLength = 256;
        String str = "Cat";
        Integer[] arr = IntStream.range(0, transitionLength).boxed().toArray(Integer[]::new);
        List<Integer> lst = Arrays.asList(arr);
        Collections.shuffle(lst);
        lst.toArray(arr);

        System.out.println("Hash for current string: " + HashTransition.hashFunction(str, arr));
        System.out.println();

        System.out.println("Exercise 2: ---------------------------------------------------------------------");
        MyHashTable col = new MyHashTable();
        System.out.println("Initial capacity = " + col.getCapacity());
        col.put("one", 1);
        col.put("two", 2);
        col.put("state", "Alabama");
        col.put("4", 4);
        col.put("5", 5);

        System.out.println("step 1: " + col.get("state"));
        System.out.println("step 2: " + col.get("10"));
        System.out.println("step 3: " + col.get("state"));
        col.remove("state");
        System.out.println("step 4: " + col.get("state"));
        col.put("state", "Alabama");

        col.put("6", 6);
        col.put("7", 7);
        col.put("8", 8);
        col.put("9", 9);
        col.put("10", 10);
        col.put("11", 10);
        col.put("12", 10);
        col.put("13", 10);
        col.put("14", 10);
        col.put("15", 10);
        col.put("16", 10);
        col.put("17", 10);
        col.put("18", 10);
        col.put("19", 10);
        col.put("20", 10);
        col.put("21", 10);
        col.put("22", 10);
        col.put("23", 10);
        col.put("24", 10);
        col.put("25", 10);
        col.put("26", 10);
        col.put("27", 10);
        col.put("28", 10);
        col.put("29", 10);
        col.put("30", 10);
        col.put("31", 10);
        col.put("32", 10);
        col.put("33", 10);
        col.put("34", 10);
        col.put("35", 10);
        col.put("36", 10);

        System.out.println("Final capacity = " + col.getCapacity());

        System.out.println(col);

    }
}
