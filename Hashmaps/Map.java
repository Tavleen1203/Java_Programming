package hashmaps;

import java.util.ArrayList;

// MapNode class to represent each node in the linked list
class MapNode<K, V> {
    K key; // key of the node
    V value; // value of the node
    MapNode<K, V> next; // reference to the next node in the linked list

    // Constructor to initialize key and value
    public MapNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

// Main Map class implementing the hash map
public class Map<K, V> {
    ArrayList<MapNode<K, V>> buckets; // ArrayList of MapNode to store the buckets
    int size; // number of key-value pairs in the map
    int numBuckets; // number of buckets

    // Constructor to initialize the map with 20 buckets
    public Map() {
        numBuckets = 20;
        buckets = new ArrayList<MapNode<K, V>>();
        for (int i = 0; i < 20; i++) {
            buckets.add(null); // initialize each bucket with null
        }
    }

    // Method to get the bucket index for a given key
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode(); // get the hash code of the key
        return hashCode % numBuckets; // modulo operation to get the index
    }

    // Method to insert a key-value pair into the map
    public void insert(K key, V value) {
        int bucketIndex = getBucketIndex(key); // get the bucket index
        MapNode<K, V> head = buckets.get(bucketIndex); // get the head of the linked list at the bucket index

        // Check if the key already exists in the map
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value; // update the value if the key exists
                return;
            }
            head = head.next;
        }

        // Insert the new key-value pair
        head = buckets.get(bucketIndex); // get the head of the linked list again
        MapNode<K, V> newNode = new MapNode<K, V>(key, value); // create a new node
        size++; // increment the size
        newNode.next = head; // point the new node to the current head
        buckets.set(bucketIndex, newNode); // set the new node as the head of the linked list

        // Check the load factor and rehash if necessary
        double loadFactor = (size * 1.0) / numBuckets;
        if (loadFactor > 0.7) {
            reHash();
        }
    }

    // Method to get the load factor of the map
    public double loadFactor() {
        return (1.0 * size) / numBuckets;
    }

    // Method to rehash the map by doubling the number of buckets
    private void reHash() {
        ArrayList<MapNode<K, V>> temp = buckets; // store the current buckets
        buckets = new ArrayList<MapNode<K, V>>(); // create new buckets
        for (int i = 0; i < 2 * numBuckets; i++) {
            buckets.add(null); // initialize each bucket with null
        }

        size = 0; // reset the size
        numBuckets *= 2; // double the number of buckets
        
        // Reinsert all the key-value pairs into the new buckets
        for (int i = 0; i < temp.size(); i++) {
            MapNode<K, V> head = temp.get(i);
            while (head != null) {
                K key = head.key;
                V value = head.value;
                insert(key, value); // reinsert the key-value pair
                head = head.next;
            }
        }
    }

    // Method to get the size of the map
    public int size() {
        return size;
    }

    // Method to get the value for a given key
    public V getValue(K key) {
        int bucketIndex = getBucketIndex(key); // get the bucket index
        MapNode<K, V> head = buckets.get(bucketIndex); // get the head of the linked list at the bucket index
        
        // Traverse the linked list to find the key
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value; // return the value if the key is found
            }
            head = head.next;
        }
        return null; // return null if the key is not found
    }

    // Method to remove a key-value pair from the map
    public V removeKey(K key) {
        
    	int bucketIndex = getBucketIndex(key); // get the bucket index
        MapNode<K, V> head = buckets.get(bucketIndex); // get the head of the linked list at the bucket index
        MapNode<K, V> prev = null; // to keep track of the previous node
        
        // Traverse the linked list to find the key
        while (head != null) {
            if (head.key.equals(key)) {
                size--; // decrement the size
                if (prev == null) {
                    buckets.set(bucketIndex, head.next); // remove the head node
                } else {
                    prev.next = head.next; // remove the node from the middle
                }
                return head.value; // return the value of the removed node
            }
            prev = head;
            head = head.next;
        }
        return null; // return null if the key is not found
    }
}
