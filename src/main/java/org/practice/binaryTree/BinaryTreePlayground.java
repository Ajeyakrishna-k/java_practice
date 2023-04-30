package org.practice.binaryTree;

public class BinaryTreePlayground {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUtils.takeInput(Integer::parseInt);
        BinaryTreeUtils.print(root);
        System.out.println(BinaryTreeUtils.maxDepth(root));
        System.out.println(BinaryTreeUtils.minDepth(root));
        System.out.println(BinaryTreeUtils.numberOfNodes(root));
    }
}
