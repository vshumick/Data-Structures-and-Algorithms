import java.util.Queue;
import java.util.*;

public class Graph12 {
    private class Node {
        String id;
        Object data;
        List<Node> nodes = new ArrayList<>();
        Integer distance;

        boolean isColor = false;

        public Node(String id, Object data) {
            this.id = id;
            this.data = data;
        }
    }

    private Map<String, Node> graphNodes = new HashMap<>();

    public void addNode(String s, Object o) {
        if (graphNodes.containsKey(s)) {
            graphNodes.get(s).data = o;
        } else {
            graphNodes.put(s, new Node(s, o));
        }
    }

    public void addEdge(String s1, String s2) {
        Node n1 = graphNodes.get(s1);
        Node n2 = graphNodes.get(s2);
        if (n1 == null || n2 == null) {
            return;
        }
        n1.nodes.add(n2);
        n2.nodes.add(n1);
    }

    public void removeNode(String s) {
        Node n = graphNodes.get(s);
        if (n == null) {
            return;
        }
        for (Node nn : n.nodes) {
            nn.nodes.remove(n);
        }
        graphNodes.remove(s);
    }

    public void removeEdge(String s1, String s2) {
        Node n1 = graphNodes.get(s1);
        Node n2 = graphNodes.get(s2);
        if (n1 == null || n2 == null) {
            return;
        }
        n1.nodes.remove(n2);
        n2.nodes.remove(n1);
    }

    public boolean isAdjacentNodes(String s1, String s2) {
        Node n1 = graphNodes.get(s1);
        Node n2 = graphNodes.get(s2);

        if (n1 == null || n2 == null) {
            return false;
        }
        return n1.nodes.contains(n2);
    }

    public List<String> getAdjacentNodeList(String s) {
        Node n = graphNodes.get(s);

        List<String> l = new ArrayList<>();
        if (n == null) {
            return l;
        }

        for (Node nn : n.nodes) {
            l.add(nn.id);
        }
        return l;
    }

    public void repaint(){
        for(String s: graphNodes.keySet()){
            Node n = graphNodes.get(s);
            n.isColor = false;
            n.distance = null;
        }
    }

    public void bfs(String s){
        Node n = graphNodes.get(s);
        n.distance = 0;
        if (n == null){
            return;
        }
        Queue<Node> q = new ArrayDeque<>();
        q.add(n);

        while(!q.isEmpty()){
            Node nn = q.poll();
            nn.isColor = true;
            for (Node nnn: nn.nodes){
                if (!nnn.isColor){
                    q.add(nnn);
                    if (nnn.distance == null || nnn.distance > nn.distance + 1) {
                        nnn.distance = nn.distance + 1;
                    }
                }
            }
        }
    }

    public boolean isConnectedNodes(String s1, String s2){
        Node n1 = graphNodes.get(s1);
        Node n2 = graphNodes.get(s2);

        if (n1 == null || n2 == null) {
            return false;
        }

        bfs(s1);
        boolean res = n2.isColor;

        repaint();

        return res;
    }

    public Integer getDistance(String s1, String s2){
        Node n1 = graphNodes.get(s1);
        Node n2 = graphNodes.get(s2);

        if (n1 == null || n2 == null) {
            return 0;
        }

        bfs(s1);
        Integer res = n2.distance;

        repaint();

        return res;
    }

    public List<String> getPathNodes(String start, String end) {
        List<String> l = new ArrayList<>();

        Node n1 = graphNodes.get(start);
        Node n2 = graphNodes.get(end);

        if (n1 == null || n2 == null) {
            return l;
        }

        bfs(start);

        if (n2.distance == null) {
            return l;
        }
        l.add(n2.id);
        while (n2 != n1) {
            for (Node n : n2.nodes) {
                if (n.distance == n2.distance - 1) {
                    l.add(n.id);
                    n2 = n;
                    break;
                }
            }
        }
        //l.add(n1.id);
        repaint();
        Collections.reverse(l);
        return l;
    }


    @Override
    public String toString() {
        String str = new String("");
        for(String s: graphNodes.keySet()){
            str += s + " -> " + getAdjacentNodeList(s) + System.lineSeparator();
        }
        return str;
    }

}
