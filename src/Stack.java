import java.util.Arrays;

public class Stack {
    public static void main(String[] args) {

        //MyArrayStack stack = new MyArrayStack();

        MyLinkedStack stack = new MyLinkedStack();
        System.out.println(stack);

        stack.push(1);
        stack.push("two");
        stack.push("Alabama");
        System.out.println(stack);

        System.out.println("peek: " + stack.peek());
        System.out.println(stack);

        System.out.println("pop: " + stack.pop());
        System.out.println(stack);

        System.out.println("size: " + stack.size());


        while(stack.peek() != null){
            System.out.println(stack.pop());
        }



    }

}
class MyArrayStack {
    private Object[] arr = new Object[16];
    private int size = 0;

    public void push(Object element){
        if(size == arr.length){
            arr = Arrays.copyOf(arr, arr.length*3/2 + 1);
        }
        arr[size++] = element;
    }

    public Object peek(){
        if (size  == 0) {
            return null;
        }
        return arr[size-1];
    }

    public Object pop(){
        if (size  == 0) {
            return null;
        }
        Object result = arr[size-1];
        arr[--size] = null;
        return result;
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
//----------------------------------------------------------------------------------
class MyLinkedStack{
    private final Node head;

    MyLinkedStack(){
        this.head = new Node();

    }
    public void push(Object element){
        Node node = new Node(element,this.head.next);
        this.head.next = node;
    }

    public Object pop(){
        if(this.head.next==null) return null;
        Object element = this.head.next.data;
        this.head.next = this.head.next.next;
        return element;
    }
    public Object peek(){
        if(this.head.next==null) return null;
        return this.head.next.data;
    }

    public int size() {
        int size = 0;
        for (Node element = head; element.next != null; element = element.next) {
            size++;
        }
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node curr = this.head.next;
        boolean first = true;
        while (curr != null) {
            if (!first) sb.append(", ");
            first = false;
            sb.append(curr.data);
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }
    //---
    class Node {
        private Object data;
        private Node next;

        Node(Object data, Node next){
            this.data = data;
            this.next = next;
        }

        public Node() {

        }
    }
}


