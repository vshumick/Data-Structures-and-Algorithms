class MyHashTableLinearProbing {
    int capacity;
    MyPair[] hash;
    Integer[] arr;

    MyHashTableLinearProbing() {
        this.capacity = 1;
        this.hash = new MyPair[this.capacity];
        this.arr = new Integer[5];
        calculateRandomCof();
    }

    private void calculateRandomCof() {
        for (int i = 0; i < this.arr.length; i++) {
            arr[i] = (int) Math.floor(Math.random() * this.capacity);
        }
    }

    int getKey(int key) {
        int sum = 0;
        for (int i = 0; i < this.arr.length; i++) {
            sum += this.arr[i] * Math.floor(myPow(key, i));
        }
        return sum % this.capacity;
    }

    int key(String str) {
        int res = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            res += str.charAt(i) * myPow(256, str.length() - 1 - i);
        }
        return res;
    }

    private static long myPow(int value, int degree) {
        long j = 1;
        for (int l = 0; l < degree; l++) {
            j *= value;
        }
        return j;
    }

    void resize() {
        this.capacity *= 2;
        MyPair[] tempHash = this.hash;
        this.hash = new MyPair[this.capacity];
        calculateRandomCof();
        for (int i = 0; i < tempHash.length; i++) {
            if (tempHash[i] != null) {
                add(tempHash[i].key, tempHash[i].value);
            }
        }
    }

    int size() {
        int sum = 0;
        for (int i = 0; i < this.hash.length; i++) {
            if (this.hash[i] != null) sum++;
        }
        return sum;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(String key, Object value) {
        if (this.size() > this.capacity * 0.5) {
            resize();
        }
        int key1 = this.key(key);
        int k = this.getKey(key1);
        for (; ; ) {
            if (this.hash[k] == null) {
                this.hash[k] = new MyPair(key, value);
                break;
            }
            if (this.hash[k].key == key) {
                this.hash[k].value = value;
                break;
            }
            k = (k + 1) % this.capacity;
        }
    }

    public Object get(String key) {
        int key1 = this.key(key);
        int k = this.getKey(key1);
        for (; ; ) {
            if (this.hash[k] == null) {
                return null;
            }
            if (this.hash[k].key == key) {
                return this.hash[k].value;
            }
            k = (k + 1) % this.capacity;
        }
    }

    public void remove(String key) {
        int key1 = this.key(key);
        int k = this.getKey(key1);
        for (; ; ) {
            if (this.hash[k] == null) {
                return;
            }
            if (this.hash[k].key == key) {
                this.hash[k] = null;
                this.leftShift(k);
                return;
            }
            k = (k + 1) % this.capacity;
        }
    }

    void leftShift(int pos) {
        for (; ; ) {
            int newPos = (pos + 1) % this.capacity;
            if (this.hash[newPos] == null) return;
            this.hash[pos] = this.hash[newPos];
            pos = newPos;
        }

    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("MyHashTableLinearProbing{");
        boolean first1 = true;
        for (int i = 0; i < this.hash.length; i++) {
            if (first1 != true) {
                str.append(", ");
            }
            first1 = false;
            if (this.hash[i] != null) {
                str.append(this.hash[i].toString());
            }
        }
        return String.valueOf(str.append('}'));
    }

    private class MyPair {
        String key;
        Object value;

        public MyPair(String key, Object value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "MyPair{" +
                    "key='" + key + '\'' +
                    ", value=" + value +
                    '}';
        }
    }
}