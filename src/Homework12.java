import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Homework12 {
    public static void main(String[] args) {

        System.out.println("Exercise 1: ---------------------------------------------------------------------");
        //Бинарное дерево, которое на занятии 11 было реализовано на JS
        BinaryTree12 bt = new BinaryTree12();

        bt.add(6, 1);
        bt.add(4, 2);
        bt.add(9, 4);
        bt.add(5, 3);
        bt.add(7, 4);
        bt.add(12, 4);
        bt.add(11, 6);
        bt.add(15, 46);
        bt.add(10, 0);


        System.out.println(bt);

        System.out.println(bt.search(9));
        System.out.println(bt.search(0));

        System.out.println("size: " + bt.size());
        bt.remove(7);
        System.out.println("size: " + bt.size());
        System.out.println(bt);


        System.out.println("Exercise 2: ---------------------------------------------------------------------");
        //Реализация ассоциативного массива на основе Бинарного дерева
        System.out.println("----------------------------");

        AssociativeArray aa = new AssociativeArray();
        aa.put(6, 1);
        aa.put(4, 2);
        aa.put(9, 4);
        aa.put(5, 3);
        aa.put(7, 4);
        aa.put(12, 4);
        aa.put(11, 6);
        aa.put(15, 46);
        aa.put(10, 0);

        System.out.println(aa);
        System.out.println("get: " + aa.get(12));
        System.out.println("size:" + aa.size());
        aa.remove(7);
        System.out.println(aa);

        System.out.println("keySet: " + aa.keySet());
        System.out.println("values: " + aa.values());


        System.out.println("Exercise 3: ---------------------------------------------------------------------");
        //Сравнение времени добавления и поиска в массиве на основе метода списков и
        // массиве на основе бинарного дерева для 10000 елементов
        long timeStart = System.currentTimeMillis();
        MyHashTableLinearProbing ht = new MyHashTableLinearProbing();

            for (int i=1; i <= 10000; i++){

                ht.add(String.valueOf(i), "Kakaya-to erunda");
            }

        System.out.println("Elapsed time for HashTable(adding): " + (System.currentTimeMillis() - timeStart));
        timeStart = System.currentTimeMillis();
        for (int i=1; i <= 10000; i++){
            ht.get(String.valueOf(i)
            );
        }
        System.out.println("Elapsed time for HashTable(getting): " + (System.currentTimeMillis() - timeStart));
        System.out.println("HashTable size: " + ht.size());

        /////////////////////////////////

        timeStart = System.currentTimeMillis();
        AssociativeArray arr = new AssociativeArray();

        for (int i=1; i <= 10000; i++){
            arr.put(i, "Kakaya-to erunda");
        }

        System.out.println("Elapsed time for AssociativeArray(adding): " + (System.currentTimeMillis() - timeStart));
        timeStart = System.currentTimeMillis();
        for (int i=1; i <= 10000; i++){
            arr.get(i);
        }
        System.out.println("Elapsed time for AssociativeArray(getting): " + (System.currentTimeMillis() - timeStart));
        System.out.println("AssociativeArray size: " + ht.size());


    }
}
