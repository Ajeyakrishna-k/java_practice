package org.practice.genericTree;

import java.util.*;

public class TreePlayground{

    public static void main(String[] args) {
        TreeNode<Integer> root = TreeUtils.buildTreeLevelWise();

        TreeUtils.buildTreeLevelWise(root);
    }
}