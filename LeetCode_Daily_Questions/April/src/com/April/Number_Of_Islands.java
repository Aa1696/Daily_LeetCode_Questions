package com.April;
/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
/*
Intuition
Will use Union_find to get the total connected island.Since we need to maintain the component of islands which area reachable islands from each other can be subsumed into one. so in this way we can maintain the different components throughout traversal.will use union_by rank to union the components having the different parent.

Approach
Will create the union class in which parent ,rank and component will be intialized, component will be consisitng of the number of total one in the grid.

Inside the constructor will send the grid and maintains the parent of each one and components too.

Will use path path compression compression method to find the parent and then compress the path from which we found the parent.

will use union_by_rank to do union based on the rank if the parent is not same and after union will decrease the component by one because intially all 1 was considered as differnet components.

Will traverse in the grid and do the union once we found the neighboure in horizontal and vertical with char value 1.

After the grid traversal will return net 1's component that are being subsumed while doing union_by_rank

Complexity
Time complexity:
grid traversal- O(nm)
union_find << alpha(nm)
O(nm) + alpha(mm)

Space complexity:
O(n*m)
 */
class union{
    int[]parent;
    int[]rank;
    int comp;
    union(char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        this.parent = new int[n*m];
        this.rank = new int[n*m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    this.comp++;
                    parent[i*m+j] = i*m+j;
                }
            }
        }
    }
    public int find_parent(int u){
        if(parent[u] == u){
            return u;
        }
        return parent[u] = find_parent(parent[u]);
    }
    public void union_by_rank(int u, int v){
        int x = find_parent(u);
        int y= find_parent(v);
        if(x==y) return;
        if(rank[x]>rank[y]){
            parent[y]=x;
        }
        else if(rank[x]<rank[y]){
            parent[x] =y;
        }
        else{
            parent[x] =y;
            rank[y]++;
        }
        this.comp--;
    }
    public int get_comp(){
        return this.comp;
    }
}
public class Number_Of_Islands {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][]dir = {{1,0},{-1,0},{0,1},{0,-1}};
        union dsu = new union(grid);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    for(int k=0;k<dir.length;k++){
                        int x = dir[k][0] + i;
                        int y = dir[k][1] + j;
                        if(isValid(x,y,n,m) && grid[x][y]=='1'){
                            dsu.union_by_rank(m*i+j,m*x+y);
                        }
                    }
                }
            }
        }
        return dsu.get_comp();
    }
    public boolean isValid(int x, int y, int n, int m){
        if(x<0 || x>=n || y<0 || y>=m) return false;
        return true;
    }
}
