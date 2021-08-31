package 提前批.HuaWei.test0804;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Geliang
 * @date 2021-08-04
 * @slogan 致敬大师，致敬未来的你！
 * 5 5
 * 0 1 1 0 0
 * 0 1 1 0 0
 * 0 0 0 0 0
 * 0 0 1 2 3
 * 0 0 1 3 9
 * 6 6
 * 1 0 1 0 2 0
 * 0 0 0 0 1 0
 * 0 2 5 0 0 0
 * 0 1 2 0 0 0
 * 0 0 1 1 0 0
 * 0 0 0 0 0 0
 */
public class t1 {
    static int[][] mountain;
    static int count = 0;
    static int W;
    static int L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            W = Integer.parseInt(s[0]);
            L = Integer.parseInt(s[1]);
            mountain = new int[W][L];

            for (int i = 0; i < L; i++) {
                str = br.readLine();
                s = str.split(" ");
                for (int j = 0; j < W; j++) {
                    mountain[i][j] = Integer.parseInt(s[j]);
                }
            }
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < W; j++) {
                    if (mountain[i][j] != 0) {
                        int temp = dfs(i, j);
                        count = Math.max(count, temp);
                    }
                }
            }
            System.out.println(count);
        }

    }

    private static int dfs(int i, int j) {
        if (i < 0 || i >= W || j < 0 || j >= L || mountain[i][j] == 0) return 0;
        int temp = mountain[i][j];
        mountain[i][j] = 0;
        return temp + + dfs(i + 1, j) + dfs(i, j + 1);
    }

}
