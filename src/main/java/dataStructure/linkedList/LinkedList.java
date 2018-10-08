package dataStructure.linkedList;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description 链表
 * @date 2018-10-07
 * @time 15:33
 */
public class LinkedList {
    private Node head;

    public LinkedList() {
    }

    public LinkedList(Node head) {
        this.head = head;
    }

    // 检测环
    public static boolean checkCircle(Node list) {
        if (list == null) return false;

        Node fast = list.next;
        Node slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) return true;
        }

        return false;
    }

    // 求中间结点
    public static Node findMiddleNode(Node list) {
        if (list == null) {
            return null;
        }
        Node fast = list, slow = list;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 删除倒数第K个结点
    public static Node deleteLastKth(Node head, int k) {
        Node fast = head;
        int i = 1;
        while (i < k) {
            fast = fast.next;
            i++;
        }
        if (fast == null) {
            return head;
        }
        Node slow = head;
        Node previous = null;
        while (fast.next != null) {
            fast = fast.next;
            previous = slow;
            slow = slow.next;
        }
        if (previous == null) {
            head = head.next;
        } else {
            previous.next = slow.next;
        }
        return head;

    }

    /**
     * 有序链表合并
     */
    public static Node mergeSortedLists(Node la, Node lb) {
        if (la == null) {
            return lb;
        }
        if (lb == null) {
            return la;
        }
        Node p = la;
        Node q = lb;
        Node head;
        if (p.value < q.value) {
            head = p;
            p = p.next;
        } else {
            head = q;
            q = q.next;
        }
        Node current = head;
        while (p != null && q != null) {
            if (p.value < q.value) {
                current.next = p;
                p = p.next;
            } else {
                current.next = q;
                q = q.next;
            }
            current = current.next;
        }
        if (p == null) {
            current.next = q;
        } else {
            current.next = p;
        }
        return head;
    }

    /**
     * 反转
     */
    public void reverse() {
        Node currentNode = this.head, headNode = null, nextNode = null;
        while (currentNode != null) {
            Node next = currentNode.next;
            if (next == null) {
                headNode = currentNode;
            }
            currentNode.next = nextNode;
            nextNode = currentNode;
            currentNode = next;
        }
        this.head = headNode;
    }

    /**
     * 根据值查找结点
     */
    public Node findByValue(int value) {
        Node node = this.head;
        while (node != null && node.value != value) {
            node = node.next;
        }
        return node;
    }

    /**
     * 根据位置查找结点
     */
    public Node findByIndex(int index) {
        Node node = this.head;
        int i = 0;
        while (node != null && i != index) {
            i++;
            node = node.next;
        }
        return node;
    }

    /**
     * 插入头结点
     */
    public void insertToHead(Node newNode) {
        if (this.head == null) {
            this.head = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
    }

    /**
     * 插入到某个结点后面
     */
    public static void insertAfter(Node node, Node newNode) {
        if (node == null) {
            return;
        }
        newNode.next = node.next;
        node.next = newNode;
    }

    /**
     * 插入到某结点前面
     */
    public void insertBefore(Node p, Node newNode) {
        if (p == null) {
            return;
        }
        if (this.head == p) {
            this.insertToHead(newNode);
            return;
        }
        Node node = this.head;
        while (node != null && node.next != p) {
            node = node.next;
        }
        if (node == null) {
            return;
        }
        newNode.next = p;
        node.next = newNode;
    }

    /**
     * 根据值删除某个结点
     *
     * @param value
     */
    public void deleteByValue(int value) {
        Node node = this.head;
        if (node == null) {
            return;
        }
        if (node.value == value) {
            this.head = head.next;
        }
        while (node.next != null && node.next.value != value) {
            node = node.next;
        }
        if (node.next == null) {
            return;
        }
        node.next = node.next.next;
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this(value, null);
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}
