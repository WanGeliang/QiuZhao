package 美团正式批;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Geliang
 * @date 2021-08-08
 * @slogan 致敬大师，致敬未来的你！
 */
public class t1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = br.readLine()) != null) {
            String s = str.replace(" ", "");
            StringBuilder sb = new StringBuilder();
            if (s.length() <= 1) {
                System.out.println(s);
            } else {
                sb.append(s.charAt(0));
                for (int i = 1; i < s.length(); i++) {
                    char pre = s.charAt(i - 1);
                    char cur = s.charAt(i);
                    if (pre != cur) {
                        sb.append(cur);
                    }
                }
                System.out.println(sb.toString());
            }

        }
    }
}
