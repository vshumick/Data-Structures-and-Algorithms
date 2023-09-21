public class Task12 {
    public static void main(String[] args) {
        Graph12 g = new Graph12();
        g.addNode("a", null);
        g.addNode("b", null);
        g.addNode("c", null);
        g.addNode("d", null);
        g.addNode("e", null);

        g.addEdge("a", "e");
        g.addEdge("a", "d");
        g.addEdge("a", "c");
        g.addEdge("a", "b");

        g.addEdge("b", "c");

        System.out.println(g);

        System.out.println(g.getDistance("e", "a"));
        //g.removeEdge("a", "d");
        System.out.println(g.getDistance("b", "d"));
        System.out.println(g.getPathNodes("b", "d"));



    }
}
