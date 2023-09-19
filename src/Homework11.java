public class Homework11 {

    public static void main(String[] args) {
        System.out.println("Exercise 1: ---------------------------------------------------------------------");
        Graph11_3 g = new Graph11_3();
        g.addNode("a");
        g.addNode("b");
        g.addNode("c");
        g.addNode("d");
        g.addNode("e");

        g.addEdge("a", "e");
        g.addEdge("a", "d");
        g.addEdge("a", "c");
        g.addEdge("a", "b");
        g.addEdge("b", "c");

        System.out.println(g);
        g.printMatrix();

        System.out.println("{a, e}: " + g.isAdjacentNodes("a", "e"));
        System.out.println("{d, c}: " + g.isAdjacentNodes("d", "c"));
        System.out.println("b: " + g.getAdjacentNodeList("b"));
        System.out.println("{d, c}: " + g.isAdjacentNodes("d", "c"));

        g.removeEdge("b", "c");
        System.out.println(g);
        g.printMatrix();

        g.removeNode("b");
        System.out.println(g);
        g.printMatrix();




        System.out.println("Exercise 2: ---------------------------------------------------------------------");

        Graph11_4 g2 = new Graph11_4();
        g2.addNode("a", null);
        g2.addNode("b", null);
        g2.addNode("c", null);
        g2.addNode("d", null);
        g2.addNode("e", null);

        g2.addEdge("a", "b");
        g2.addEdge("a", "c");
        g2.addEdge("a", "d");
        g2.addEdge("a", "e");
        g2.addEdge("c", "b");

        System.out.println(g2.isConnectedNode("c", "d"));
        g2.removeEdge("a", "d");
        System.out.println(g2.isConnectedNode("c", "d"));



    }
}
