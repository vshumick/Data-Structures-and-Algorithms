public class List7 {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addFirst(1);
        doublyLinkedList.addFirst(2);
        doublyLinkedList.addFirst(3);
        doublyLinkedList.addFirst("Alabama");
        doublyLinkedList.addLast(5);

        System.out.println(doublyLinkedList);
        System.out.println(doublyLinkedList.get(0));

        doublyLinkedList.add(2, "two");
        System.out.println(doublyLinkedList);

        doublyLinkedList.removeFirst();
        doublyLinkedList.removeLast();
        System.out.println(doublyLinkedList);

        doublyLinkedList.remove(200);
        System.out.println(doublyLinkedList);

        System.out.println("Size: " + doublyLinkedList.size());


    }

}
//----------------------------------------------------------------------------------------------------------------------
class DoublyLinkedList {
    Node head = new Node();
    Node tail = new Node();
    private class Node {
        Node prev;
        Object data;
        Node next;

        public Node(Node prev, Object data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }

        public Node() {}

        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    public DoublyLinkedList() {
        this.head = new Node();
        this.tail = new Node();
        this.head.next = tail;
        this.tail.prev = head;
    }

    public void addFirst(Object element){
        Node node = new Node(null, element, null);
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next = node;
        node.next.prev = node;
    }

    public void addLast(Object element){
        Node node = new Node(null, element, null);
        node.prev = this.tail.prev;
        node.next = this.tail;
        this.tail.prev = node;
        node.prev.next = node;
    }

    public Node get(int index){
        Node curr = this.head.next;
        int count = 0;
        while (curr != this.tail){
            if (index == count) return curr;
            curr = curr.next;
            count++;
        }
        return null;
    }

    public void add(int index, Object element){
        Node curr = this.get(index - 1);
        Node node = new Node(null, element, null);
        node.prev = curr;
        node.next = curr.next;
        curr.next = node;
        node.next.prev = node;
    }

    public void removeFirst(){
        if (this.head.next == this.tail) return;
        Node removeNode = this.head.next;
        this.head.next = removeNode.next;
        removeNode.next.prev = this.head;
    }

    public void removeLast(){
        if (this.tail.prev == this.head) return;
        Node removeNode = this.tail.prev;
        this.tail.prev = removeNode.prev;
        removeNode.prev.next = this.tail;
    }

    public void remove(int index){
        Node removeNode = this.get(index);
        if (removeNode == null) return;
        removeNode.next.prev = removeNode.prev;
        removeNode.prev.next = removeNode.next;
    }

    public int size(){
        Node curr = this.head.next;
        int count = 0;
        while (curr != this.tail){
            curr = curr.next;
            count++;
        }
        return count;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node curr = this.head.next;
        boolean first = true;
        while (curr != this.tail)
        {
            if (!first){
                sb.append(", ");
            } else {first = false;}
            sb.append(curr.data);
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

