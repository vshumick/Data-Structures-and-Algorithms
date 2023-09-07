public class Queue {
    public static void main(String[] args) {
        //MyArrayQueue q = new MyArrayQueue();
        MyLinkedQueue q = new MyLinkedQueue();

        Object el = "1";
        q.enqueue(el);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        System.out.println(q);

        System.out.println("size: " + q.size());

        System.out.println("peek: " + q.peek());
        System.out.println(q);

        System.out.println("dequeue: " + q.dequeue());
        System.out.println(q);

        while (q.peek() != null){
            System.out.println(q.dequeue());
        }
        System.out.println(q);
    }
}

class MyArrayQueue {
    private Object[] arr = new Object[16];
    private int size = 0;
    private int head = 0;
    private int tail = 0;


    public void enqueue(Object el) {
        int nextTail= (tail + 1) % arr.length;
        if (nextTail != head) {
            arr[tail] = el;
            tail = nextTail;
        }
        else {
            Object[] newArray = new Object[arr.length * 4/3 + 1] ;
            for (int i = head, j = 0; i != tail; i = (i + 1) % arr.length, j++ ){
                newArray[j] = arr[i];
            }
            arr = newArray;
            head = 0;
            tail = size;
            arr[tail] = el;
            tail = (tail + 1) % arr.length;
        }
        size++;
    }

    public Object dequeue() {
        if (head == tail) {
            return null;
        }
        Object curr = arr[head];
        arr[head] = null;
        head = (head + 1) % arr.length;
        size--;
        return curr;
    }

    public Object peek() {
        if (head == tail) {
            return null;
        }
        Object curr = arr[head];
        return curr;
    }

    public int size(){
        return size;
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean first = true;
        for (int i = head; i != tail; i = (i + 1) % arr.length ){
            if (!first) sb.append(", ");
            first = false;
            sb.append(arr[i]);
        }
        sb.append("]");
        return String.valueOf(sb);
    }
}
//---------------------------------------------------------------------------------------------------------------------
class MyLinkedQueue {
    Node head = new Node();
    Node tail = new Node();

    public MyLinkedQueue() {
        this.head = new Node();
        this.tail = new Node();
        this.head.next = tail;
        this.tail.prev = head;
    }

    public void enqueue(Object element){
        Node node = new Node(null, element, null);
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next = node;
        node.next.prev = node;
    }

    public Object dequeue(){
        if (this.tail.prev == this.head) return null;
        Node removeNode = this.tail.prev;
        this.tail.prev = removeNode.prev;
        removeNode.prev.next = this.tail;
        return removeNode.data;
    }

    public Object peek(){
        if (this.tail.prev == this.head) return null;
        return this.tail.prev.data;
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

    class Node {
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
}

