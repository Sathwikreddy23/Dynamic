package Nodes;


class Entry<K, V> {
    K key;
    V value;
    Entry<K, V> next;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}


public class DynamicHashMap<K, V> {
    private int capacity = 4;       // initial size
    private float loadFactor = 0.75f;
    private int size = 0;

    private Entry<K, V>[] table;

    public DynamicHashMap() {
        table = new Entry[capacity];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int index = hash(key);
        Entry<K, V> head = table[index];

        
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

      
        Entry<K, V> newNode = new Entry<>(key, value);
        newNode.next = table[index];
        table[index] = newNode;
        size++;

        
        if ((1.0 * size) / capacity >= loadFactor) {
            resize();
        }
    }

    public V get(K key) {
        int index = hash(key);
        Entry<K, V> head = table[index];
        while (head != null) {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        Entry<K, V> head = table[index];
        Entry<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                if (prev == null) table[index] = head.next;
                else prev.next = head.next;
                size--;
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    private void resize() {
        int oldCapacity = capacity;
        capacity = capacity * 2;
        Entry<K, V>[] oldTable = table;
        table = new Entry[capacity];
        size = 0;

        for (int i = 0; i < oldCapacity; i++) {
            Entry<K, V> head = oldTable[i];
            while (head != null) {
                put(head.key, head.value);
                head = head.next;
            }
        }
    }

    public int size() {
        return size;
    }
}

