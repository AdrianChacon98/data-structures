package com.estructuras.datastrutures.treeAVL;

import com.parisesoftware.datastructure.bst.factory.BinarySearchTreeFactory;
import com.parisesoftware.datastructure.linkedlist.factory.ILinkedListFactory;
import com.parisesoftware.datastructure.model.factory.IBSTNodeFactory;

import static com.google.common.primitives.Ints.max;

public class TreeAVL{

    public Node root;

    public TreeAVL()
    {

    }


    //Balancing Tree
    private int height(Node node){
        return node != null ? node.height : -1;
    }
    private void updateHeight(Node node){
        int leftChildHeight = height(node.left);
        int rightChildHeight = height(node.right);
        node.height = max(leftChildHeight,rightChildHeight) + 1;
    }

    private int balanceFactor(Node node){
        return height(node.right) - height(node.left);
    }


    //Rotations methods

    //Right Rotation

    private Node rotateRight(Node node){
        Node leftChild = node.left;

        node.left=leftChild.right;
        leftChild.right=node;

        updateHeight(node);
        updateHeight(leftChild);

        return leftChild;
    }

    //Left Rotation

    private Node rotateLeft(Node node){
        Node rightChild = node.right;

        node.right = rightChild.left;
        rightChild.left=node;

        updateHeight(node);
        updateHeight(rightChild);

        return rightChild;

    }

    //Rebalance method

    private Node rebalance(Node node){
        int balanceFactor=balanceFactor(node);


        // Left-heavy
        if(balanceFactor < -1){

            if(balanceFactor(node.left) <= 0){ // Case 1
                //Rotate right
                node = rotateRight(node);
            }else{                             // Case 2
                //Rotate left-right

                node.left=rotateLeft(node.left);
                node=rotateRight(node);
            }

        }

        // Right-heavy
        if(balanceFactor > 1){
            if(balanceFactor(node.right) >= 0){  // Case 3
                //Rotate left
                node = rotateLeft(node);
            }else{                               // Case 4
                //Rotate right-left
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }



        return node;
    }


    // Tree methods

    public void insert(int key){
        this.root = insertRecursive(this.root,key);
        updateHeight(root);

        this.root=rebalance(root);
    }


    private Node insertRecursive(Node root,int key){

        if(root==null){
            root = new Node(key);
            return root;
        }

        if(key<root.key)
            root.left=insertRecursive(root.left,key);
        else if(key>root.key)
            root.right=insertRecursive(root.right,key);

        return root;

    }

    public void deleteKey(int key){
        this.root=deleteKeyRecursive(this.root,key);

        // Node is null if the tree doesn't contain the key
        if (root == null) {
            //print the key does not exist
        }

        updateHeight(root);

        this.root=rebalance(root);
    }

    private Node deleteKeyRecursive(Node root, int key){

        if(root==null) return root;


        if(key<root.key)
            this.root.left=deleteKeyRecursive(this.root.left,key);
        else if(key>root.key)
            this.root.right=deleteKeyRecursive(this.root.right,key);
        else{

            if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;

            root.key=minValue(root.right);
            root.right=deleteKeyRecursive(root.right,key);
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










}
