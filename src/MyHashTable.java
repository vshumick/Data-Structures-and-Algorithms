import java.util.ArrayList;
import java.util.List;

public class MyHashTable {
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("MyHashTable{arr=");
        boolean first1 = true;
        for (List<MyPair> ls : arr) {
            if (first1 != true) {
                str.append(", ");
            }
            first1 = false;
            str.append("{");
            boolean first2 = true;
            for (MyPair p : ls) {
                if (first2 != true) {
                    str.append(", ");
                }
                first2 = false;
                /*if (first != true) {
                    str.append(", ");
                }
                first = false;*/
                str.append("[" + p.key + "=>" + p.value + "]");
            }
            str.append("}");
        }
        return String.valueOf(str.append('}'));
    }

    public MyHashTable() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<MyPair>();
        }
    }

    private class MyPair {
        String key;
        Object value;

        public MyPair(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    public int getCapacity() {
        return capacity;
    }

    private int capacity = 17;
    List<MyPair>[] arr = new ArrayList[this.capacity];

    public int size() {
        return size;
    }

    private int size = 0;

    private double loadFactor = 0.75;

    private static int hashFunction(int key, int primeM) {
        return key % primeM;
    }

    private static int myHash(String str) {
        int result = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i) * mult(str.length() - i - 1);
        }
        return result;
    }

    private static int mult(int k) {
        int j = 1;
        for (int l = 0; l < k; l++) {
            j *= 256;
        }
        return j;
    }

    public void put(String key, Object value) {
        if (size > loadFactor * arr.length) {
            this.capacity = nearestPrime();
            List<MyPair>[] newArr = new ArrayList[capacity];
            for (int i = 0; i < newArr.length; i++) {
                newArr[i] = new ArrayList<MyPair>();
            }
            expandArray(arr, newArr);
        }

        int hash = hashFunction(myHash(key), arr.length);
        List<MyPair> ls = arr[hash];

        for (MyPair p : ls) {
            if (p.key.equals(key)) {
                p.value = value;
                return;
            }
        }

        ls.add(new MyPair(key, value));
        size++;

    }

    private int nearestPrime() {
        for (int i = capacity * 3 / 2 + 1; i <= 500000000; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                return i;
            }
        }
        return 0;
    }

    private void expandArray(List<MyPair>[] oldArr, List<MyPair>[] newArr) {
        for (List<MyPair> l : oldArr) {
            for (MyPair p : l) {
                int hash = hashFunction(myHash(p.key), newArr.length);
                List<MyPair> ll = newArr[hash];
                ll.add(new MyPair(p.key, p.value));
            }
        }
        this.arr = newArr;
    }

    public Object get(String key) {
        int hash = hashFunction(myHash(key), arr.length);
        List<MyPair> ls = arr[hash];

        for (MyPair p : ls) {
            if (p.key.equals(key)) {
                return p.value;
            }
        }
        return null;
    }

    public void remove(String key) {
        int hash = hashFunction(myHash(key), arr.length);
        List<MyPair> ls = arr[hash];

        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i).key.equals(key)) {
                ls.remove(i);
                size--;
                break;
            }

        }
    }


}
