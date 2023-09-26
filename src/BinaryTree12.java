public class BinaryTree12 {
    private class Node {
        int key;
        Object data;
        Node left;
        Node right;

        public Node(int key, Object data, Node left, Node right) {
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    Node root;

    public void add(int key, Object data) {
        root = addRecursive(root, key, data);
    }
    private Node addRecursive(Node node, int key, Object data) {
        if (node == null) {
            node = new Node(key, data, null, null);
            return node;
        }
        if (key == node.key) {
            node.data = data;
            return node;
        }
        if (key < node.key) {
            node.left = addRecursive(node.left, key, data);
        }
        if (key > node.key) {
            node.right = addRecursive(node.right, key, data);
        }
        return node;
    }

    public Object search(int key) {
        return searchDfs(root, key);
    }
    private Object searchDfs(Node node, int key) {
        if (node == null) return null;

        if (key == node.key) {
            return node.data;
        } else if (key < node.key) {
            return searchDfs(node.left, key);
        } else {
            return searchDfs(node.right, key);
        }
    }

    public void remove(int key) {
        root = removeDfs(root, key);
    }
    private Node removeDfs(Node node, int key) {
        if (node == null) return null;

        if (node.key == key) {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left != null && node.right == null) {
                return node.left;
            } else if (node.right != null && node.left == null) {
                return node.right;
            } else {
                Node min = findMin(node.right);
                node.key = min.key;
                node.data = min.data;
                node.right = removeDfs(node.right, min.key);
                return node;
            }
        }

        if (node.key > key) {
            node.left = removeDfs(node.left, key);
        } else {
            node.right = removeDfs(node.right, key);
        }

        return node;
    }
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public int size() {
        return sizeDfs(this.root);
    }
    private int sizeDfs(Node node) {
        return node == null ? 0 : 1 + sizeDfs(node.left) + sizeDfs(node.right);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        toStringDfs(root, str);
        return str.toString();
    }
    private void toStringDfs(Node node, StringBuilder str) {
        if (node == null) return;
        str.append(node.key).append("=>").append(node.data).append(" ");
        toStringDfs(node.left, str);
        toStringDfs(node.right, str);
    }


}
