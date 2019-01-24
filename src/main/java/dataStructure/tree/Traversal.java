package dataStructure.tree;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description 三种树的遍历方式
 * @date 2018-11-14
 * @time 9:17
 */
public class Traversal {
    /**
     * 先序
     */
    void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序
     */
    void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
    }

    /**
     * 后序
     */
    void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);
    }

    /**
     * 层次遍历
     */
    void cenOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node n = queue.remove();
            if (n.left != null) {
                queue.add(n.left);
            }
            if (n.right != null) {
                queue.add(n.right);
            }
            System.out.println(n.value);
        }
    }

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        Node node = root.left;
        node.left = new Node(4);
        node.right = new Node(5);
        node = root.right;
        node.left = new Node(6);
        node.right = new Node(7);

        new Traversal().cenOrder(root);
    }
}
