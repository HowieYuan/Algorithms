package dataStructure.tree;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description 二叉查找树
 * @date 2018-11-14
 * @time 17:11
 */
public class BinarySearchTree {
    private Node tree;

    public Node find(int data) {
        Node n = tree;
        while (n != null) {
            if (data < tree.value) {
                n = n.left;
            } else if (data > tree.value) {
                n = n.right;
            } else {
                return n;
            }
        }
        return null;
    }

    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }
        Node node = tree;
        while (true) {
            if (node.value < data) {
                if (node.right == null) {
                    node.right = new Node(data);
                    return;
                }
                node = node.right;
            } else if (node.value > data) {
                if (node.left == null) {
                    node.left = new Node(data);
                    return;
                }
                node = node.left;
            } else {
                return;
            }
        }
    }

    public void delete(int data) {
        Node n = tree;
        Node father = null;
        while (data != n.value) {
            father = n;
            if (n.value > data) {
                if (n.left == null) {
                    return;
                }
                n = n.left;
            } else {
                if (n.right == null) {
                    return;
                }
                n = n.right;
            }
        }
        if (n.left != null && n.right != null) {
            Node min = n.right;
            Node minFather = n.right;
            while (min.left != null) {
                minFather = min;
                min = min.left;
            }
            n.value = min.value;
            minFather.left = null;
            return;
        }
        Node child;
        if (n.left != null) {
            child = n.left;
        } else if (n.right != null) {
            child = n.right;
        } else {
            child = null;
        }

        if (father == null) {
            tree = child;
        } else if (father.left == n) {
            father.left = child;
        } else if(father.right == n) {
            father.right = child;
        }
    }

    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
