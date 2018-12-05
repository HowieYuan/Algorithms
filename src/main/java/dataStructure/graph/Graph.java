package dataStructure.graph;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description
 * @date 2018-12-05
 * @time 21:01
 */
public class Graph {
    // 顶点的个数
    private int v;
    // 邻接表
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 添加新边
     */
    public void addEgde(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * 广度优先遍历
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        queue.add(s);
        while (!queue.isEmpty()) {
            int num = queue.poll();
            LinkedList<Integer> list = adj[num];
            for (int n : list) {
                if (!visited[n]) {
                    queue.add(n);
                    if (n == t) {
                        print(prev, s, t);
                        return;
                    }
                    prev[n] = num;
                    visited[n] = true;
                }
            }
        }
    }

    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.println(t + " ");
    }


    /**
     * 深度优先遍历
     */
    private boolean found = false; // 全局变量或者类成员变量

    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found) {
            return;
        }
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }



}
