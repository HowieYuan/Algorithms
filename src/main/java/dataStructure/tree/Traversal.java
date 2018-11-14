package dataStructure.tree;

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
        System.out.println(root);
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
        preOrder(root.left);
        System.out.println(root);
        preOrder(root.right);
    }

    /**
     * 后序
     */
    void postOrder(Node root) {
        if (root == null) {
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root);
    }

    public class Node {
        private Object value;
        private Node left;
        private Node right;

        public Node(Object value) {
            this.value = value;
        }
    }
}
