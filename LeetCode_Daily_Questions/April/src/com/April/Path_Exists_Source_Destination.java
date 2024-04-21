package com.April;
/*
There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex source to vertex destination.

Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.
 */
/*
Intuition
Will use union find data structure to find the path exist between source and destination or not.Will do union by rank, so if the path exisit between source and destination then the path will be compressed int one and will have same parent.

Approach
will create the data structure union find by rank where union will be done based on the rank and union will be done only if they different parent.
And, to find the find the parent , we will use path compression technique.
Will travel to all the edges and do the union based on the parent of each node in the edge.
if source and destination has the same parent then there is path exisit otherwise not.
Complexity
Time complexity:
Union_find - O(alpha(n))
alpha(n) ->is the inverse Ackermann function, which grows very slowly. In fact it grows so slowly, that it doesn't exceed 4 for all reasonable n.
n< 10^600.
Edge joining - O(edge.length)

Space complexity:
O(n) - Parent and rank int the dsu class.
 */
class union_find{
    int[]parent;
    int[]rank;
    union_find(int n){
        this.parent = new int[n];
        this.rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
    }
    public int find(int u){
        if(parent[u]==u){
            return u;
        }
        return parent[u] = find(parent[u]);
    }
    public void union_by_rank(int u, int v){
        int x = find(u);
        int y = find(v);
        if(x==y) return;
        if(rank[x]>rank[y]){
            parent[y] =x;
        }
        else if(rank[x]<rank[y]){
            parent[x]=y;
        }
        else{
            parent[y] =x;
            rank[x]++;
        }
    }
}
public class Path_Exists_Source_Destination {
    public boolean validPath(int n, int[][] edges, int s, int d) {
        union_find dsu = new union_find(n);
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(dsu.find(u) != dsu.find(v)){
                dsu.union_by_rank(u,v);
            }
        }
        return dsu.find(s)==dsu.find(d);
    }
}
