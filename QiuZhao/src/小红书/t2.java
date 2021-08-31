package 小红书;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Geliang
 * @date 2021-08-21
 * @slogan 致敬大师，致敬未来的你！
 */
public class t2 {
    static char[][] grid;
    static int N;
    static int num;
    static boolean[][] used;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            N = Integer.parseInt(str);
            grid = new char[N][N];
            used = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                str = br.readLine();
                for (int j = 0; j < str.length(); j++) {
                    grid[i][j] = str.charAt(j);
                    // 记录一共有多少同学需要分发零食
                    if (grid[i][j] == '.') num++;
                }
            }
            dfs(grid, 0, 0, 0);
            System.out.println(res);
        }
    }

    public static void dfs(char[][] grid, int i, int j, int count) {
        if (i < 0 || i >= N || j < 0 || j >= N || used[i][j] || grid[i][j] == '#') return;
        if (grid[i][j] == '.') count++;
        used[i][j] = true;
        // 同学在最后一行，并且count数量达到了同学的数量
        if (i == N - 1 && num == count) res++;
        dfs(grid, i + 1, j, count);
        dfs(grid, i - 1, j, count);
        dfs(grid, i, j + 1, count);
        dfs(grid, i, j - 1, count);
        used[i][j] = false;
    }
}
