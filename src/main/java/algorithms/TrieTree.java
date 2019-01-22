package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description Tire 树/字典树
 * @date 2019-01-22
 * @time 17:24
 */
public class TrieTree {
    private TireNode tireNode = new TireNode('/');

    /**
     * 插入字符串
     */
    public void inset(String s) {
        if (s.length() == 0) {
            return;
        }
        char[] charArray = s.toCharArray();
        TireNode currentNode = tireNode;
        for (char c : charArray) {
            if (currentNode.children == null) {
                currentNode.children = new TireNode[26];
            }
            int charIndex = c - 'a';
            if (currentNode.children[charIndex] == null) {
                currentNode.children[charIndex] = new TireNode(c);
            }
            currentNode = currentNode.children[charIndex];
        }
        currentNode.isEndChar = true;
    }

    /**
     * 查找字符串
     */
    public boolean find(String s) {
        if (s.length() == 0 || tireNode.children == null) {
            return false;
        }
        char[] charArray = s.toCharArray();
        TireNode currentNode = tireNode;
        for (char c : charArray) {
            currentNode = currentNode.children[c - 'a'];
            if (currentNode == null || currentNode.value != c) {
                return false;
            }
        }
        return currentNode.isEndChar;
    }

    class TireNode {
        private char value;
        private TireNode[] children;
        private boolean isEndChar = false;

        public TireNode(char value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree();
        trieTree.inset("howie");
        trieTree.inset("her");
        trieTree.inset("stella");
        System.out.println(trieTree.find("howie"));
        System.out.println(trieTree.find("how"));
        System.out.println(trieTree.find("stella"));
        System.out.println(trieTree.find("her"));
        System.out.println(trieTree.find("stel"));
    }
}
