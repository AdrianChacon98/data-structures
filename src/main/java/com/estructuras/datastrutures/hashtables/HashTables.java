package com.estructuras.datastrutures.hashtables;



/*
* A hash table is a data structure that maps keys to values for highly efficient lookup. There are a number of
* ways of implementing this. Here, we will describe a simple but common implementation
*
* 1. First, compute the key's hash code, which will usually be an in t or long. Note that two different keys
* could have the same hash code, as there may be an infinite number of keys and a finite number of ints.
* 2. Then, map the hash code to an index in the array. This could be done with something like hash (key )
* % array_length.Two different hash codes could, of course, map to the same index.
* 3. At this index, there is a linked list of keys and values. Store the key and value in this index. We must use a
* linked list because of collisions: you could have two different keys with the same hash code, or two different
* hash codes that map to the same index.
* To retrieve the value pair by its key, you repeat this process. Compute the hash code from the key, and then
* compute the index from the hash code. Then, search through the linked list for the value with this key.
* If the number of collisions is very high, the worst case runtime is 0(N), where N is the number of keys.
* However, we generally assume a good implementation that keeps collisions to a minimum, in which case
* the lookup time is 0( 1).
*
* Alternatively, we can implement the hash table with a balanced binary search tree.This gives us an 0 (lo g N)
* lookup time.The advantage of this is potentially using less space, since we no longer allocate a large array. We
* can also iterate through the keys in order, which can be useful sometimes.
*
*
*
*
* */


import java.io.Serializable;
import java.util.Dictionary;
import java.util.LinkedList;
import java.util.Map;

public class HashTables<K,V> {

    private static final int ARRAY_LENGTH=10;
    private LinkedList<Entry<K,V>> [] array;


    public HashTables(){
        array = new LinkedList[ARRAY_LENGTH];
        //create the keys
        for(int i=0; i<array.length; i++){
            array[i]= new LinkedList<Entry<K, V>>();
        }
    }

    public void put(K key, V value){
        int index = hash(key) % ARRAY_LENGTH;
        LinkedList<Entry<K,V>> linkedList = this.array[index];


        //Check if the key already exists in the linked list

        for(Entry<K,V> entry : linkedList){
            if(entry.getKey().equals(key)){
                //if the key exists, update the value and return
                entry.setValue(value);
                return;
            }
        }

        //If the key doesn't exist add a new entry ti the linked list
        linkedList.add(new Entry<>(key,value));

    }

    public V getValue(K key){
        int index = hash(key) % ARRAY_LENGTH;
        LinkedList<Entry<K,V>> linkedList = array[index];

        // Search for the key in the linked list
        for(Entry<K,V> entry : linkedList){
            if(entry.getKey().equals(key)){
                //if the key found, return its corresponding value
                return entry.getValue();
            }
        }

        //if key is not found, return null
        return  null;
    }


    public int hash(K key){
        return key.hashCode();
    }

    private class Entry<K,V>{

        private K key;
        private V value;

        public Entry(K key, V value){
            this.key=key;
            this.value=value;
        }

        public K getKey(){
            return this.key;
        }
        public V getValue(){
            return  value;
        }
        public void setValue(V value){
            this.value=value;
        }
    }
}
