package com.estructuras.datastrutures.treeAVL;

//https://www.happycoders.eu/algorithms/avl-tree-java/

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
*AVL Tree Balancing
*After insertion into or deletion from the AVL tree, we calculate the height and balance factor from the inserted or deleted node upwards to the root.
*
*If, at a node, we determine that the AVL invariant is no longer satisfied (i.e., the balance factor is less than -1 or greater than +1), we must rebalance. We differentiate four cases:
*
*Balancing a left-heavy node:
*   Right rotation
*   Left-right Rotation
*Balancing a right-heavy node:
*   Left rotation
*   Right-left rotation
*
* Rebalancing by Right Rotation
*
* Rebalancing by Left-Right Rotation
*
* Rebalancing by Left Rotation
*
* Rebalancing by Right-Left Rotation
*
*
* 1.	BF(N) < -1 and BF(L) ≤ 0	Right rotation around N
* 2.	BF(N) < -1 and BF(L) > 0	Left rotation around L followed by right rotation around N
* 3.	BF(N) > 1 and BF(R) ≥ 0	Left rotation around N
* 4.	BF(N) > 1 and BF(R) < 0	Right rotation around R followed by left rotation around N
*
*
*
*
*
*
* */
public class Node {


   public int key;
   public Node left,right;
   public int height;

    public Node(int key){
        this.key=key;
    }




}
