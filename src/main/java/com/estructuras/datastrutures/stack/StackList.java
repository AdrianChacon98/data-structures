package com.estructuras.datastrutures.stack;


//Stack definition
//Last In First Out (LIFO)

//Methods

/*
* push() -> To add an element to the top of the stack
* pop()  -> To remove an element from the top of the stack
* peek() -> returns the top element from the stack without deleting it from the stack
* search()-> it returns the position of the element from the top tof the stack
* empty() -> To check whether a stack is empty or not, we use the empty() method
*

*
*
*
* */

import java.util.ArrayList;
import java.util.List;

public class StackList {

    private List<String> stack = new ArrayList<>();



    public StackList(){

    }

    public void push(String element){

        this.stack.add(element);

    }

    public String pop()
    {

        return this.stack.remove(this.stack.size());
    }

    public String peek(){
        return this.stack.get(this.stack.size());
    }

    public int search(String element){
        return this.stack.indexOf(element);
    }

    public boolean isEmpty(){
        return this.stack.isEmpty();
    }









}
