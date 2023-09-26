public class Task13 {
    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(9,"a");
        h.add(6,"b");
        h.add(7,"c");
        h.add(4,"d");
        h.add(5,"e");
        h.add(3,"f");
        //h.add(12,"g");

        System.out.println(h);
        /*System.out.println(h.getMaxAndDelete());
        System.out.println(h);
        System.out.println(h.getMaxAndDelete());
        System.out.println(h);
        System.out.println(h.search(6));*/
        h.changeKey(6, 2);
        System.out.println(h);
    }
}
