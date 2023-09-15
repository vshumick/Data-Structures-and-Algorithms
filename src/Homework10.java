public class Homework10 {

    public static void main(String[] args) {
        System.out.println("Exercise 1: ---------------------------------------------------------------------");
        MyHashTableLinearProbing col = new MyHashTableLinearProbing();
        System.out.println("Initial capacity = " + col.getCapacity());
        col.add("one", 1);
        col.add("two", 2);
        col.add("state", "Alabama");
        col.add("4", 4);
        col.add("5", 5);

        System.out.println(col.get("state"));
        System.out.println(col.get("10"));
        System.out.println(col.get("state"));
        col.remove("state");
        System.out.println(col.get("state"));
        col.add("state", "Alabama");

        col.add("6", 6);
        col.add("7", 7);
        col.add("8", 8);
        col.add("9", 9);
        col.add("10", 10);

        System.out.println("sixe = " + col.size());
        System.out.println("Final capacity = " + col.getCapacity());

        System.out.println(col);

        System.out.println("Exercise 1: ---------------------------------------------------------------------");
        Graph graph = new Graph();
        graph.addNode("a", null);
        graph.addNode("b", null);
        graph.addNode("c", null);
        graph.addNode("d", null);
        graph.addNode("e", null);

        System.out.println(graph.nodes);
        System.out.println(graph);



    }
}
