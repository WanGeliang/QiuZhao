package 虾皮正式批;

/**
 * @author Geliang
 * @date 2021-08-23
 * @slogan 致敬大师，致敬未来的你！
 */
public class t3 {
    public int numberOfIslands(int[][] grid) {
        // write code here
        int m = grid.length;
        int n = grid[0].length;
        if (m == 0) return 0;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public static void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return;
        if (grid[i][j] == 2) return;
        grid[i][j] = 2;
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
    }
}
