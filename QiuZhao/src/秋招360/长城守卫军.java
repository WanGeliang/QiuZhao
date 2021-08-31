package 秋招360;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Geliang
 * @date 2021-08-29
 * @slogan 致敬大师，致敬未来的你！
 */
public class 长城守卫军 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int x = Integer.parseInt(s[2]);
            int k = Integer.parseInt(s[3]);

            s = br.readLine().split(" ");
            int[] soldier = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                soldier[i] = Integer.parseInt(s[i]);
                sum += soldier[i];
            }
            for (int i = 0; i < m * (2 * x + 1); i++) {
                int min = soldier[0];
                int minIndex = 0;
                for (int j = 1; j < n; j++) {
                    if (soldier[j] < min) {
                        min = soldier[j];
                        minIndex = j;
                    }
                }
                soldier[minIndex] += k;
            }
            int min = soldier[0];
            int minIndex = 0;
            for (int i = 1; i < n; i++) {
                if (soldier[i] < min) {
                    min = soldier[i];
                    minIndex = i;
                }
            }
            System.out.println(min);
        }
    }
}
