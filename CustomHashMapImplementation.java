import java.util.Scanner;

class HashNode {
    int key;
    int value;
    HashNode next;

    HashNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class CustomHashMap {
    private HashNode[] buckets;
    private int capacity;

    CustomHashMap(int capacity) {
        this.capacity = capacity;
        buckets = new HashNode[capacity];
    }

    private int getIndex(int key) {
        return key % capacity;
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        HashNode head = buckets[index];

        while (head != null) {
            if (head.key == key) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        HashNode newNode = new HashNode(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    public int get(int key) {
        int index = getIndex(key);
        HashNode head = buckets[index];

        while (head != null) {
            if (head.key == key) {
                return head.value;
            }
            head = head.next;
        }

        return -1; // Key not found
    }

    public void remove(int key) {
        int index = getIndex(key);
        HashNode head = buckets[index];
        HashNode prev = null;

        while (head != null) {
            if (head.key == key) {
                if (prev == null) {
                    buckets[index] = head.next;
                } else {
                    prev.next = head.next;
                }
                return;
            }
            prev = head;
            head = head.next;
        }
    }
}

public class CustomHashMapImplementation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomHashMap map = new CustomHashMap(10);

        map.put(1, 10);
        map.put(2, 20);
        map.put(11, 30);

        System.out.println("Value for key 2: " + map.get(2));
        map.remove(2);
        System.out.println("Value for key 2 after removal: " + map.get(2));

        sc.close();
    }
}
