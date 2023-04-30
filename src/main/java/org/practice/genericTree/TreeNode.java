package org.practice.genericTree;

import java.util.*;

public class TreeNode<T> {
    T data;
    List<TreeNode<T>> children;

    TreeNode(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    TreeNode(T data, List<TreeNode<T>> children) {
        this.data = data;
        this.children = new ArrayList<>(children);
    }

}
