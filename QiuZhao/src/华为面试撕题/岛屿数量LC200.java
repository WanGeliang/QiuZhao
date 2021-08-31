package 华为面试撕题;

/**
 * @author Geliang
 * @date 2021-08-28
 * @slogan 致敬大师，致敬未来的你！
 */
public class 岛屿数量LC200 {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        岛屿数量LC200 me = new 岛屿数量LC200();
        System.out.println(me.numIslands(grid));
    }

    static boolean[][] used;

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        used = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || used[i][j] || grid[i][j] == '0') return;
        grid[i][j]='2';
        used[i][j] = true;
        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
    }
}