package org.practice.binaryTree;

import java.util.ArrayList;

public class BinarySearchTree {

    private BinaryTreeNode<Integer> root;
    private int size;

    public void insert(int data) {
        // Implement the insert() function
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(data);
        if (this.root == null) {
            this.root = newNode;
        } else {
            insert(this.root, newNode);
        }
        this.size++;
    }

    private static void insert(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> newNode) {

        if (newNode.data <= root.data) {
            if (root.left == null) {
                root.left = newNode;
            } else {
                insert(root.left, newNode);
            }
        } else {
            if (root.right == null) {
                root.right = newNode;
            } else {
                insert(root.right, newNode);
            }
        }
    }

    public void remove(int data) {
        // Implement the remove() function
        this.root = remove(this.root, data);
        this.size--;
    }

    private BinaryTreeNode<Integer> remove(BinaryTreeNode<Integer> root, int data) {
        // Implement the remove() function
        if (root == null)
            return null;

        if (data == root.data) {
            if (root.left == null && root.right == null)
                return null;

            else if (root.left == null)
                return root.right;

            else if (root.right == null)
                return root.left;

            BinaryTreeNode<Integer> temp = root.right;
            while (temp.left != null) {
                temp = temp.left;
            }

            root.data = temp.data;
            root.right = remove(root.right, root.data);
        } else if (data < root.data) {
            root.left = remove(root.left, data);
        } else if (data > root.data) {
            root.right = remove(root.right, data);
        }

        return root;
    }

    public void printTree() {
        // Implement the printTree() function
        printTree(this.root);
    }

    private static void printTree(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

        System.out.print(root.data + ":");

        if (root.left != null) {
            System.out.print("L:" + root.left.data + ",");
        }

        if (root.right != null)
            System.out.print("R:" + root.right.data);

        System.out.println();
        printTree(root.left);
        printTree(root.right);
    }

    public boolean search(int data) {
        // Implement the search() function
        return search(this.root, data);
    }

    private static boolean search(BinaryTreeNode<Integer> root, int data) {
        if (root == null)
            return false;
        if (root.data == data)
            return true;
        else if (data < root.data)
            return search(root.left, data);
        else
            return search(root.right, data);
    }

}
