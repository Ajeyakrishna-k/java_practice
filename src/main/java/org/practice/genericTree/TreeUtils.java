package org.practice.genericTree;

import java.util.*;

public class TreeUtils{


    public static TreeNode<Integer> buildTreeLevelWise() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter root value : ");
        int rootValue = scan.nextInt();

        TreeNode<Integer> root = new TreeNode<Integer>(rootValue);

        Queue<TreeNode<Integer>> q = new LinkedList<>();

        q.add(root);
        while(!q.isEmpty()){
            TreeNode<Integer> current = q.remove();

            System.out.println("Enter number children in " + current.data + ": ");
            int kids = scan.nextInt();

            List<TreeNode<Integer>> kidNodes = new ArrayList<>();

            for(int i = 0; i < kids; i++){
                kidNodes.add(new TreeNode<>(scan.nextInt()));
            }

            current.children.addAll(kidNodes);

            q.addAll(kidNodes);

        }
        return root;
    }

    public static void buildTreeLevelWise(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            TreeNode<Integer> current = q.remove();


            if(current == null && q.size() == 0){
                break;
            }
            else if(current == null){
                q.add(null);
                System.out.println();
                continue;
            }

            System.out.print(current.data +" ");

            q.addAll(current.children);
        }
    }
}