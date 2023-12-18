package com.estructuras.datastrutures.treeAVL;

/*AVL TREE Description*/
/*
* AVL TREE
*
* An AVL tree is a balanced binary search tree – that is, a binary search tree in which the heights of the left and right subtrees of each node differ by at most one.
* After each insert and delete operation, this invariant is verified, and the balance is restored by AVL rotation if necessary.
*
*
* HEIGHT
*
* The height of a (sub) tree indicates how far the root is from the lowest node. Therefore, a (sub) tree that consists of only a root node has a height of 0.
*
*
* BALANCE FACTOR
*
*
* The balance factor "BF" of a node denotes the difference of the heights "H" of the right and left subtree ("node.right" and "node.left"):
*
* BF(node) = H(node.right) - H(node.left)
*
* The height of a non-existent subtree is -1 (one less than the height of a subtree consisting of only one node).
*
* There are three cases:
*
* If the balance factor is < 0, the node is said to be left-heavy.
* If the balance factor is > 0, the node is said to be right-heavy.
* A balance factor of 0 represents a balanced node.
*
* In an AVL tree, the balance factor at each node is -1, 0, or 1.
*
*
* AVL TREE ROTATION
*
*
* Inserting into and deleting from an AVL tree works basically as described in the article about binary search trees.
*
* If the AVL invariant is no longer fulfilled after an insert or delete operation, we must rebalance the tree. We will do that by so-called rotations.
*
* We distinguish between right and left rotation.
*
* RIGHT ROTATION
*
*
*
*
*
* */
public class Node {


    int data;
    Node left;
    Node right;

    int height;

    public Node(int data){

    }




}
