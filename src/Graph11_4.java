import java.util.ArrayList;
import java.util.List;

class Graph11_4 {
    List<Node> nodes;
    List<List<Node>> edges;

    public Graph11_4() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }

    private Node findNode(String key) {
        for (Node node : nodes) {
            if (node.key == key) {
                return node;
            }
        }
        return null;
    }

    public void addNode(String key, Object data) {
        Node newNode = findNode(key);
        if (newNode != null) {
            newNode.data = data;
            return;
        } else {
            nodes.add(new Node(key, data));
        }
    }

    public void addEdge(String key1, String key2) {
        Node firstNode = findNode(key1);
        Node secondNode = findNode(key2);
        if (firstNode != null && secondNode != null) {
            List<Node> edge = new ArrayList<>();
            edge.add(firstNode);
            edge.add(secondNode);
            edges.add(edge);
        }
    }

    public void removeNode(String key) {
        Node node = findNode(key);
        if (node == null) {
            return;
        }
        List<List<Node>> connections = new ArrayList<>();
        for (List<Node> edge : edges) {
            if (edge.contains(node)) {
                connections.add(edge);
            }
        }
        for (List<Node> connection : connections) {
            edges.remove(connection);
        }
        nodes.remove(node);
    }

    public void removeEdge(String key1, String key2) {
        Node firstNode = findNode(key1);
        Node secondNode = findNode(key2);
        if (firstNode != null && secondNode != null) {
            List<Node> edgeToRemove = null;
            for (List<Node> edge : edges) {
                if (edge.contains(firstNode) && edge.contains(secondNode)) {
                    edgeToRemove = edge;
                    break;
                }
            }
            if (edgeToRemove != null) {
                edges.remove(edgeToRemove);
            }
        }
    }

    public List<String> getAdjustanceNodes(String keyStart) {
        Node node = findNode(keyStart);
        if (node == null) {
            return null;
        }
        List<String> nodeList = new ArrayList<>();
        for (List<Node> edge : edges) {
            if (edge.get(0) == node) {
                nodeList.add(edge.get(1).key);
            }
            if (edge.get(1) == node) {
                nodeList.add(edge.get(0).key);
            }
        }
        return nodeList;
    }

    public boolean isNodesAdjustance(String key1, String key2) {
        Node firstNode = findNode(key1);
        Node secondNode = findNode(key2);
        if (firstNode != null && secondNode != null) {
            for (List<Node> edge : edges) {
                if (edge.get(0) == firstNode && edge.get(1) == secondNode) {
                    return true;
                }
                if (edge.get(1) == firstNode && edge.get(0) == secondNode) {
                    return true;
                }
            }
        }
        return false;
    }

    public void recolor() {
        for (Node n : nodes){
            n.color = 0;
        }
    }

    public void dfs(String key) {
        Node n = findNode(key);
        if (n == null) { return; }
        if (n.color == 1) { return; }
        n.color = 1;
        List<String> l = getAdjustanceNodes(key);
        for (String s : l) {
            dfs(s);
        }
    }

    public boolean isConnectedNode(String start, String end){
        dfs(start);
        Node nEnd = findNode(end);
        boolean res = false;
        if (nEnd.color == 1) {
            res = true;
        }
        recolor();
        return res;
    }

    @Override
    public String toString() {
        String nodes = "{";
        String edges = "{";
        boolean first = true;

        for (Node n : this.nodes) {
            if (!first) {
                nodes += ",";
            }
            first = false;
            nodes += n.key;
        }

        first = true;
        for (List<Node> l : this.edges) {
            if (!first) {
                edges += ",";
            }
            first = false;
            edges += "{" + l.get(0).key + "," + l.get(1).key + "}";
        }
        nodes += "}";

        return "Graph{" +
                "nodes=" + nodes +
                ", edges=" + edges +
                '}';
    }

    private class Node {
        String key;
        Object data;
        int color = 0;


        Node(String key, Object data) {
            this.key = key;
            this.data = data;
        }

        @Override
        public String toString() {
            return "{" +
                    "key='" + key + '\'' +
                    ", data=" + data +
                    '}';
        }
    }
}