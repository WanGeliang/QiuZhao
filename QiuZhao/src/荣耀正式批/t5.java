package 荣耀正式批;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Geliang
 * @date 2021-08-07
 * @slogan 致敬大师，致敬未来的你！
 */
public class t5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int mmCount = Integer.parseInt(br.readLine());
        int[] num = new int[mmCount];
        int resIndex = 0;
        for (int m = 0; m < mmCount; m++) {
            str = br.readLine();
            if (!str.contains("*")) {
                num[resIndex++] = 1;
            }
        }
        for (int i = 0; i < mmCount; i++) {
            System.out.println(num[i]);
        }
    }
}
