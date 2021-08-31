package 网易;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Geliang
 * @date 2021-08-21
 * @slogan 致敬大师，致敬未来的你！
 */
public class t1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            int[] num = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                num[i] = Integer.parseInt(s[i]);
            }
            int M = Integer.parseInt(br.readLine());
            int count = 0;

            for (int i = 0; i < num.length; i++) {
                for (int j = i + 1; j < num.length; j++) {
                    if (num[i] + num[j] <= M) count++;
                }
            }
            System.out.println(count);
        }
    }
}
