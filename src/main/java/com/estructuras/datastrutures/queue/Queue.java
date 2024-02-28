package com.estructuras.datastrutures.queue;

import java.util.ArrayList;
import java.util.List;

public class Queue<T extends Number> {

    private List<T> queue;


    public Queue() {
        this.queue = new ArrayList<T>();
    }

    public boolean add(T value) {
        try {
            queue.add(value);
        } catch (Exception e) {
            throw new RuntimeException("Error adding the value");
        }

        return true;
    }

    public boolean offer(T value) {

        if (queue.add(value))
            return true;
        return false;

    }

    public T element() {
        T value = null;
        try {
            if(queue.isEmpty())
                throw new RuntimeException("The Queue is empty");
            value = queue.get(queue.size());

        } catch (Exception e) {
        }
        return value;
    }

    public T peek() {
        return queue.get(queue.size());
    }

    public T remove()
    {
        T value=null;
        try {
            if(queue.isEmpty())
                throw new RuntimeException("The queue is empty");

            value=queue.remove(queue.size());
        }catch (Exception e){
        }
        return value;
    }

    public T poll(){
        T value=null;
        value=queue.remove(queue.size());
        return value;
    }









}
