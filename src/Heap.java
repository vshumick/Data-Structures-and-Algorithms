import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class  Heap {
    private class Node {
        int key;
        Object data;

        public Node(int key, Object data) {
            this.key = key;
            this.data = data;
        }

        @Override
        public String toString() {
            return "{"+ key +
                    "=>" + data +
                    '}';
        }
    }

    private List<Node> nodes = new ArrayList<>();

    public void add(int key, Object data) {
        nodes.add(new Node(key, data));
        siftUp(nodes.size() - 1);
    }

    private void siftUp(int index) {
        int parentIndex;
        for (; index > 0; ) {
            parentIndex = (index - 1) / 2;
            if (nodes.get(index).key > nodes.get(parentIndex).key) {
                Collections.swap(nodes, index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    public Object getMaxAndDelete() {
        if (nodes.size() == 0) {
            return null;
        }
        Object n = nodes.get(0).data;
        Collections.swap(nodes, 0, nodes.size() - 1);
        nodes.remove(nodes.size() - 1);

        siftDown(0);

        return n;
    }

    private void siftDown(int index) {
        for (; ; ) {
            int indChildLeft = 2 * index + 1;
            int indChildRight = 2 * index + 2;
            /*if (indChildLeft > nodes.size() - 1){
                break;
            }*/
            int maxChildIndex = index;
            //if (nodes.get(maxChildIndex).key < nodes.get(indChildRight).key){
            if (indChildLeft < nodes.size() && nodes.get(maxChildIndex).key < nodes.get(indChildLeft).key) {
                maxChildIndex = indChildLeft;
            }
            if (indChildRight < nodes.size() && nodes.get(maxChildIndex).key < nodes.get(indChildRight).key) {
                maxChildIndex = indChildRight;
            }

            if (maxChildIndex == index) {
                break;
            }
            Collections.swap(nodes, index, maxChildIndex);
            index = maxChildIndex;
        }
    }

    public Object search(int key) {
        for (Node n : nodes) {
            if (n.key == key) {
                return n.data;
            }
        }
        return null;
    }

    public void remove(int key){
        for(int i = 0; i < nodes.size(); i++){
          if(nodes.get(i).key == key){
              Collections.swap(nodes, i, nodes.size() - 1);
              nodes.remove(nodes.size() - 1);
              siftDown(i);
              break;
          }
        }
    }

    public void changeKey(int oldKey, int newKey) {
        for(int i = 0; i < nodes.size(); i++){
            if(nodes.get(i).key == oldKey){
                nodes.get(i).key = newKey;
                siftUp(i);
                siftDown(i);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return nodes.toString();
    }
}
