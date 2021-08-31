package 拼多多提前批;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Geliang
 * @date 2021-08-22
 * @slogan 致敬大师，致敬未来的你！
 */
public class t3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int time = Integer.parseInt(str);
            for (int i = 0; i < time; i++) {
                String[] s = br.readLine().split(" ");
                int N = Integer.parseInt(s[0]);
                int M = Integer.parseInt(s[1]);
                long left = (long) Math.pow(10, N - 1);
                long right = (long) Math.pow(10, N) - 1;
                System.out.println(left);
                System.out.println(right);
                long res = -1;
                for (long j = left; j <= right; j++) {
                    if (j % M == 0) {
                        res = j;
                        break;
                    }
                }
//                long temp = left;
//                int len = 1;
//                for (long j = left; j <= right; j++) {
//                    if (temp % M == 0) {
//                        res = j;
//                        break;
//                    }
//                    temp = (temp * 10) % M;
//                }
                System.out.println(res);
            }
        }
    }
}
