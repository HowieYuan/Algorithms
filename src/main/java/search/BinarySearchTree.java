package search;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description 二叉查找树
 * @date 2018-07-12
 * @time 16:09
 */
public class BinarySearchTree {
    //该二叉树的根结点
    private Node root;

    private class Node {
        //键
        private int key;
        //值
        private Object value;
        //左右子树结点
        private Node left, right;
        //以该结点为根结点的树的结点总数
        private int n;

        public Node(int key, Object value, int n) {
            this.key = key;
            this.value = value;
            this.n = n;
        }
    }

    public int size() {
        return size(root);
    }

    public int size(Node node) {
        if (node != null) {
            return node.n;
        }
        return 0;
    }

    public Object getValue(int key) {
        return getValue(root, key);
    }

    private Object getValue(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (root.key == key) {
            return root.value;
        }
        if (key < root.key) {
            return getValue(root.left, key);
        }
        return getValue(root.right, key);
    }

    /**
     * 更新某结点值，若不存在，则插入改结点
     *
     * @param key   需要更新的结点的键
     * @param value 需要更新的值
     */
    public void put(int key, Object value) {
        root = put(root, key, value);
    }

    private Node put(Node node, int key, Object value) {
        if (node == null) {
            node = new Node(key, value, 1);
        }
        if (node.key == key) {
            node.value = value;
        }
        if (key < node.key) {
            node.left = put(node.left, key, value);
        }
        if (key > node.key) {
            node.right = put(node.right, key, value);
        }
        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }

    /**
     * 获得树的最小 key 值
     */
    public int min() {
        return min(root);
    }

    private int min(Node root) {
        if (root.left == null) {
            return root.key;
        }
        return min(root.left);
    }

    /**
     * 获得树的最大 key 值
     */
    public int max() {
        return max(root);
    }

    private int max(Node root) {
        if (root.right == null) {
            return root.key;
        }
        return max(root.right);
    }
}
