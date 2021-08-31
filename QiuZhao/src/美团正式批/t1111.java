package 美团正式批;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Geliang
 * @date 2021-08-08
 * @slogan 致敬大师，致敬未来的你！
 */
public class t1111 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int time = Integer.parseInt(str);
            for (int i = 0; i < time; i++) {
                String[] s = br.readLine().split(" ");
                int n = Integer.parseInt(s[0]);
                int k = Integer.parseInt(s[1]);
                int num[] = new int[n];
                s = br.readLine().split(" ");
                for (int j = 0; j < s.length; j++) {
                    num[j] = Integer.parseInt(s[j]);
                }
                Arrays.sort(num);
                int tempNum = num[k - 1];
                if (tempNum + 1 > n || ((k < n - 1) && (num[k - 1] == num[k]))) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                    System.out.println(tempNum + 1);
                }
            }
        }
    }
}
