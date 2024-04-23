package com.April;
import java.util.*;
public class Min_Height_Tree {
    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            //will use Modified BFS approach for Khans algorithm
            List<Integer> ans = new ArrayList<>();
            if (n < 2) {
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
            ArrayList<Integer>[] adj = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
            }
            int[] degree = new int[n];
            for (int[] e : edges) {
                int u = e[0];
                degree[u]++;
                int v = e[1];
                degree[v]++;
                adj[u].add(v);
                adj[v].add(u);
            }
            Deque<Integer> que = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                if (degree[i] == 1) {
                    que.add(i);
                }
            }
            while (!que.isEmpty()) {
                int sz = que.size();
                ans = new ArrayList<>();
                for (int i = 0; i < sz; i++) {
                    int u = que.poll();
                    ans.add(u);
                    degree[u]--;
                    for (int v : adj[u]) {
                        degree[v]--;
                        if (degree[v] == 1) {
                            que.add(v);
                        }
                    }
                }
            }
            return ans;
        }
    }
}
