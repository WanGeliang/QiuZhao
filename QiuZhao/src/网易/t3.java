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
public class t3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            int length = s.length;
            int[] age = new int[length];
            for (int i = 0; i < length; i++) {
                age[i] = Integer.parseInt(s[i]);
            }
            int[] paper = new int[length];
            Arrays.fill(paper, 1);
            if (length == 1) {
                System.out.println(1);
                return;
            }
            for (int time = 0; time < length; time++) {
                if (age[0] > age[1]) {
                    paper[0] = paper[1] + 1;
                }
                for (int i = 1; i < length - 1; i++) {
                    if (age[i] > age[i - 1]) {
                        paper[i] = paper[i - 1] + 1;
                    }
                    if (age[i] > age[i + 1]) {
                        paper[i] = paper[i + 1] + 1;
                    }
                    if (age[length - 1] > age[length - 2]) {
                        paper[length - 1] = paper[length - 2] + 1;
                    }
                }
            }
            int sum = 0;
            for (int i = 0; i < length; i++) {
                sum += paper[i];
            }
            System.out.println(sum);
        }
    }
}
