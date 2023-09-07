import java.util.Arrays;

public class MyList {
    public static void main(String[] args) {

        /*MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("aaaaaaaaaa");
        myArrayList.add("bbbbbbbb");
        myArrayList.add("ccccccccc");

        System.out.println(myArrayList);

        myArrayList.add("ddd", 1);
        System.out.println(myArrayList);

        myArrayList.remove(1);
        System.out.println(myArrayList);

        System.out.println(myArrayList.get(1));
        //System.out.println(myArrayList.get(10));

        myArrayList.set("DDD", 1);
        System.out.println(myArrayList);

        System.out.println("MyArrayList size: " + myArrayList.size());*/

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst("Alabama");
        myLinkedList.addLast(5);

        System.out.println(myLinkedList);
        System.out.println(myLinkedList.get(0));

        myLinkedList.add(2, "two");
        System.out.println(myLinkedList);

        myLinkedList.removeFirst();
        myLinkedList.removeLast();
        System.out.println(myLinkedList);

        myLinkedList.remove(200);
        System.out.println(myLinkedList);

        System.out.println("Size: " + myLinkedList.size());




    }

}
//----------------------------------------------------------------------------------------------------------------------
class MyArrayList{
    private Object[] arr = new Object[3];
    private int size = 0;

    public void add(Object element){
        if(size == arr.length){
            arr = Arrays.copyOf(arr, arr.length*3/2 + 1);
        }
        arr[size++] = element;
    }

    public void add(Object element, int ind){
        if(size == arr.length){
            arr = Arrays.copyOf(arr, arr.length*3/2 + 1);
        }
        System.arraycopy(arr, ind, arr, ind+1, size - ind);
        arr[ind] = element;
        size++;
    }

    public void remove(int ind){
        System.arraycopy(arr, ind+1, arr, ind, size - ind);
        size--;
    }

    public Object get(int ind){
        if (ind < 0 || ind >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return arr[ind];
    }

    public void set(Object element, int ind){
        if (ind < 0 || ind >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        arr[ind] = element;
    }

    public int size(){
        return size;
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++){
            sb.append(arr[i]);
            if (i < size-1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
//----------------------------------------------------------------------------------------------------------------------
class MyLinkedList {
    Node head = new Node();
    Node tail = new Node();

    public MyLinkedList() {
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
        while (curr != this.tail) //(int i = 0; i < size; i++)
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

//---
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

