package 提前批.HuaWei.test0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Geliang
 * @date 2021-08-04
 * @slogan 致敬大师，致敬未来的你！
 */
public class t2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            // 表示从第N层到M层需要花费的最短时间
            int[][] dp = new int[N][M];

        }
    }
}
