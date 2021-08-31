package ZhengshiPi;

/**
 * @author Geliang
 * @date 2021-08-07
 * @slogan 致敬大师，致敬未来的你！
 */
public class t2 {
    public static void main(String[] args) {

    }

    static int[][] gridGlobal;
    static int maxI;
    static int maxJ;
    static int maxResource;
    static boolean[][] used;

    public int getMaximumResource(int[][] grid) {
        // write code here
        gridGlobal = grid;
        maxI = grid.length;
        maxJ = grid[0].length;
        maxResource = grid[0][0];
        used = new boolean[maxI][maxJ];
        for (int i = 0; i < maxI; i++) {
            for (int j = 0; j < maxJ; j++) {
                if (grid[i][j] != 0) {
                    dfs(0, i, j, used);
                }
            }
        }
        return maxResource;
    }

    public void dfs(int beforeNum, int curI, int curJ, boolean[][] used) {
        if (curI < 0 || curI >= maxI || curJ < 0 || curJ >= maxJ || gridGlobal[curI][curJ] == 0 || used[curI][curJ]) {
            return;
        }
        int curSum = beforeNum + gridGlobal[curI][curJ];
        maxResource = Math.max(maxResource, curSum);
        used[curI][curJ] = true;
        dfs(curSum, curI + 1, curJ, used);
        dfs(curSum, curI - 1, curJ, used);
        dfs(curSum, curI, curJ + 1, used);
        dfs(curSum, curI, curJ - 1, used);
    }

}
