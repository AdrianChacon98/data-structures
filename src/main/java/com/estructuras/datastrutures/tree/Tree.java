package com.estructuras.datastrutures.tree;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.logging.Logger;

public class Tree {

    private Node root;
    private Logger logger = Logger.getLogger(Tree.class.getName());



    public Tree(){
        this.root=null;
    }


   public void insert(int key){
        this.root=insertRec(this.root,key);
   }

   private Node insertRec(Node root, int key){
        if(root==null){
            root=new Node(key);
            return root;
        }

        if(key<root.key)
            root.left=insertRec(root.left,key);
        else if(key>root.key)
            root.right=insertRec(root.right,key);


        return root;
   }

   /*public void deleteKey(int key){
        this.root=deleteRec(root, key);
   }
   private Node deleteRec(Node root,int key){
        if(root==null)return root;

        if(key<root.key)
            root.left=deleteRec(root.left,key);
        else if(key>root.key)
            root.right=deleteRec(root.right,key);
        else{
            if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;

            root.key=minValue(root.right);
            root.right=deleteRec(root.right,key);
        }

        return root;
   }

   private int minValue(Node root){
        int minv=root.key;

        while(root.left!=null){
            minv=root.left.key;
            root=root.left;
        }

        return minv;
   }



    public Node search(Node root, int key){

        if(root==null || root.key==key)
            return root;

        if(root.key>key)
            return search(root.left,key);

        return search(root.right,key);
    }

    public void inOrder(){
        inOrderRec(this.root);
    }*/

    private void inOrderRec(Node root){

        if(root!=null){
            inOrderRec(root.left);
            logger.info("Value:"+root.key);
            inOrderRec(root.right);
        }
    }


    public void preOrder(){
        preOrderRec(this.root);
    }

    private void preOrderRec(Node root){
        if(root!=null){
            logger.info("Value:"+root.key);
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    public void postOrder(){

    }

    private void postOrderRec(Node root){
        if(root!=null){
            postOrderRec(root.left);
            postOrderRec(root.right);
            logger.info("Value:"+root.key);
        }
    }


}
