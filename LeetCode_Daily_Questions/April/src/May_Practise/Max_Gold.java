package May_Practise;
class Pair1{
    int x, y;
    Pair1(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Max_Gold {
    boolean[][]visited;
    int[][]dir = {{1,0},{-1,0},{0,1},{0,-1}};
    int max;
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        max = Integer.MIN_VALUE;
        visited = new boolean[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] != 0){
                    int max1 = dfs(new Pair1(i,j),grid);
                    System.out.print("Max_Val= "+max1);
                    max = Math.max(max,max1);
                }
            }
        }
        return max == Integer.MIN_VALUE ? 0:max;
    }
    public int dfs(Pair1 p, int[][]grid){
        visited[p.x][p.y] = true;
        int curr = grid[p.x][p.y];
        int local_max = curr;
        for(int i = 0; i<4; i++){

            int x = dir[i][0] + p.x;
            int y = dir[i][1] + p.y;

            if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && !visited[x][y] && grid[x][y] !=0){
                local_max = Math.max(local_max,curr+dfs(new Pair1(x,y), grid));

            }

        }
        visited[p.x][p.y] = false;
        return local_max;

    }
}
