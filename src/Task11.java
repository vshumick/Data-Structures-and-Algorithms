public class Task11 {
    public static void main(String[] args) {
        Graph11 g = new Graph11();
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
        System.out.println("{a, e}: " + g.isAdjacentNodes("a", "e"));
        System.out.println("{d, c}: " + g.isAdjacentNodes("d", "c"));

        System.out.println("b: " + g.getAdjacentNodeList("b"));

        System.out.println("{d, c}: " + g.isAdjacentNodes("d", "c"));
        //System.out.println("{d, c}: " + g.isConnectedNodes("d", "c"));

        g.removeEdge("a", "d");

        //System.out.println("{d, c}: " + g.isConnectedNodes("d", "c"));



    }
}
