package com.estructuras.datastrutures.TraversalTree;

public class TraversalTree {

    public Node root;


    public TraversalTree(){
        this.root =null;
    }


    public void inOrder(Node node){
        if(node==null)
            return;

        inOrder(node.left);

        System.out.println(node.key);

        inOrder(node.right);

    }


    public void preOrder(Node node){
        if(node==null)
            return;

        System.out.println(node.key);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrden(Node node){
        postOrden(node.left);
        postOrden(node.right);
        System.out.println(node.key);
    }


}
