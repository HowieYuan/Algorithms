package dataStructure.tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description 二叉查找树
 * @date 2018-11-14
 * @time 17:11
 */
public class BinarySearchTree {
    private Node root;

    public Node find(int data) {
        Node n = root;
        while (n != null) {
            if (data < n.value) {
                n = n.left;
            } else if (data > n.value) {
                n = n.right;
            } else {
                return n;
            }
        }
        return null;
    }

    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        Node node = root;
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
        Node n = root;
        Node father = null;
        //找到待删除点
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
        //左右都存在子树的情况
        if (n.left != null && n.right != null) {
            Node min = n.right;
            Node minFather = n.right;
            while (min.left != null) {
                minFather = min;
                min = min.left;
            }
            n.value = min.value;
            if (min == n.right) {
                n.right = min.right;
            } else {
                minFather.left = min.right;
            }
            return;
        }
        //目标为叶子结点或者只有一边有子树的情况
        Node child;
        if (n.left != null) {
            child = n.left;
        } else if (n.right != null) {
            child = n.right;
        } else {
            child = null;
        }

        if (father == null) {
            root = child;
        } else if (father.left == n) {
            father.left = child;
        } else if (father.right == n) {
            father.right = child;
        }
    }

    public Node findMax() {
        Node node = root;
        while (node != null) {
            node = node.right;
        }
        return node;
    }

    public int height() {
        Node node = root;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return (left > right ? left : right) + 1;
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        return (left > right ? left : right) + 1;
    }

    private static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
