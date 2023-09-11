package com.estructuras.datastrutures.linkedlist;

import java.util.logging.Logger;

public class LinkedList {

    public Node l;
    private  Logger logger = Logger.getLogger(LinkedList.class.getName());

    public LinkedList(){
        l=null;
    }

    public void insert(int data){
        Node n;

        if(l==null) {
            n = new Node(data);
            l = n;
        }else{
            n = new Node(data);
            n.next=l;
            l=n;
        }

    }


    public void shortInsert(int data){
        Node n;
        n = new Node(data);
        if(l!=null)
            n.next=l;
        l=n;
    }

    public void print(){
        Node n = l;

        while(n!=null){
            logger.info(n.data+">");
            n=n.next;
        }
    }

    public void printReverse(Node n){
        printReverseRec(n);
    }

    public void printReverseRec(Node n){
        if(n==null){
            logger.info("null >");
        }else{
            printReverse(n.next);
            logger.info(n.data+">");
        }
    }

    public void search(int value){
        Node n;
        n=l;

        while(n!=null){
            if(n.data==value){
                logger.info("it was found");
                break;
            }
            n=n.next;
        }
        if(n==null)
            logger.info("it was not found");
    }

    public void deleteAll(){
        l=null;
    }

    public void delete(int value){
        Node a,n;
        a=null;
        n=l;

        while(n!=null){
            if(n.data==value){
                break;
            }

            a=n;
            n=n.next;
        }

        if(n==null){
            logger.info("it doesnt exist that value");
        }else if(l==n){
            l=n.next;
        }else
            a.next=n.next;


    }

}
