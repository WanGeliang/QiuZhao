package 货拉拉;

import java.util.Arrays;

/**
 * @author Geliang
 * @date 2021-08-30
 * @slogan 致敬大师，致敬未来的你！
 */
public class t3 {
    public static void main(String[] args) {
        int[][] A={{0,0,1,1},{1,0,1,0},{0,1,1,0},{0,0,1,0}};
        int[][] f={{2,2},{3,3},{4,4}};
        t3 me = new t3();
        int[][] res = me.flipChess(A, f);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    public int[][] flipChess(int[][] A, int[][] f) {
        for (int i = 0; i < f.length; i++) {
            int x = f[i][0] - 1;
            int y = f[i][1] - 1;
            if (x - 1 >= 0) {
                A[x - 1][y] ^= 1;
            }
            if (y - 1 >= 0) {
                A[x][y - 1] ^= 1;
            }
            if (x + 1 <= 3) {
                A[x + 1][y] ^= 1;
            }
            if (y + 1 <= 3) {
                A[x][y + 1] ^= 1;
            }
        }
        return A;
    }
}

