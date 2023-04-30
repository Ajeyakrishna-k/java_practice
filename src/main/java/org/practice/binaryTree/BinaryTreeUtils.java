package org.practice.binaryTree;

import java.util.Scanner;
import java.util.function.Function;

public class BinaryTreeUtils {

    public static BinaryTreeNode<Integer> takeInputForIntegerData(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("root data (int / n) : ");
        String root = scanner.next();
        if(root.equals("n")){
            return null;
        }
        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<>(Integer.parseInt(root));

        System.out.print("nn / rn / ln / l / r : ");
        String options = scanner.next();
        switch (options.toLowerCase()){
            case "nn" : {
                rootNode.left = null;
                rootNode.right = null;
                break;
            }
            case "rn" : {
                System.out.print("Enter " + root + "'s left ");
                rootNode.left = takeInputForIntegerData();
                break;
            }
            case "ln" :{
                System.out.print("Enter " + root + "'s right ");
                rootNode.right = takeInputForIntegerData();
                break;
            }
            case "l":{
                System.out.print("Enter " + root + "'s left ");
                rootNode.left = takeInputForIntegerData();
                System.out.print("Enter " + root + "'s right ");
                rootNode.right = takeInputForIntegerData();
                break;
            }
            case "r":{
                System.out.print("Enter " + root + "'s right ");
                rootNode.right = takeInputForIntegerData();
                System.out.print("Enter " + root + "'s left ");
                rootNode.left = takeInputForIntegerData();
                break;
            }
            default: {
                System.out.println("ALAS! YOU FUCKED UP!");
            }
        }
        return rootNode;
    }

    public static <T> BinaryTreeNode<T> takeInput(Function<String,T> function){
        Scanner scanner = new Scanner(System.in);
        System.out.print("root data ( value / n) : ");
        String root = scanner.next();
        if(root.equals("n")){
            return null;
        }

        BinaryTreeNode<T> rootNode = new BinaryTreeNode<>(function.apply(root));

        System.out.print("nn / rn / ln / l / r : ");
        String options = scanner.next();
        switch (options.toLowerCase()){
            case "nn" : {
                rootNode.left = null;
                rootNode.right = null;
                break;
            }
            case "rn" : {
                System.out.print("Enter " + root + "'s left ");
                rootNode.left = takeInput(function);
                break;
            }
            case "ln" :{
                System.out.print("Enter " + root + "'s right ");
                rootNode.right = takeInput(function);
                break;
            }
            case "l":{
                System.out.print("Enter " + root + "'s left ");
                rootNode.left = takeInput(function);
                System.out.print("Enter " + root + "'s right ");
                rootNode.right = takeInput(function);
                break;
            }
            case "r":{
                System.out.print("Enter " + root + "'s right ");
                rootNode.right = takeInput(function);
                System.out.print("Enter " + root + "'s left ");
                rootNode.left = takeInput(function);
                break;
            }
            default: {
                System.out.println("ALAS! YOU FUCKED UP!");
            }
        }
        return rootNode;
    }

    public static <T> void print(BinaryTreeNode<T> root){
        if(root == null) return;

        System.out.print(root.data.toString() + ": ");
        if(root.left != null){
            System.out.print("L - " +root.left.data.toString() + " , ");
        }
        else {
            System.out.print("L - null, ");
        }

        if(root.right != null){
            System.out.println("R - " +root.right.data.toString());
        }
        else {
            System.out.println("R - null");
        }
        print(root.left);
        print(root.right);
    }

    public static <T> int numberOfNodes(BinaryTreeNode<T> root){
        if(root == null){
            return 0;
        }
        return numberOfNodes(root.left) + numberOfNodes(root.right) + 1;
    }

    public static <T> int maxDepth(BinaryTreeNode<T> root){
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left) , maxDepth(root.right))+1;
    }

    public static <T> int minDepth(BinaryTreeNode<T> root){
        if(root == null){
            return 0;
        }
        return Math.min(minDepth(root.left) , minDepth(root.right))+1;
    }

    public static boolean isBST(BinaryTreeNode<Integer> root){
        return isBSTHelper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private static boolean isBSTHelper(BinaryTreeNode<Integer> root, int min , int max){
        if(root == null){
            return true;
        }

        if(root.data < min){
            return false;
        }

        if(root.data > max){
            return false;
        }

        return isBSTHelper(root.left,min,root.data - 1) && isBSTHelper(root.right, root.data,max);
    }

}
