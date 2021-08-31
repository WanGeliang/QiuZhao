package 网易0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Geliang
 * @date 2021-08-22
 * @slogan 致敬大师，致敬未来的你！
 */
public class t3 {
    static int maxN = 1000010;
    //    static char[] s=new char[maxN];
    static int[] next = new int[maxN];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            String s = br.readLine();
            char[] ch = new char[n + 1];
            for (int i = 1; i <= n; i++) {
                ch[i] = s.charAt(i - 1);
            }
            for (int i = 2, j = 0; i <= n; ++i) {
                while (j != 0 && ch[i] != ch[j + 1]) j = next[j];
                if (ch[i] == ch[j + 1]) j++;
                next[i] = j;
            }
            System.out.printf("Test case \n");
            for (int i = 2; i <= n; i++) {
                int j = i - next[i];
                if (i > j && i % j == 0) System.out.println(i + " " + i / j);
            }
        }
    }
}
