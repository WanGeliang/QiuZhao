package 拼多多提前批;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Geliang
 * @date 2021-08-22
 * @slogan 致敬大师，致敬未来的你！
 */
public class t1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int time=Integer.parseInt(str);
            for (int i = 0; i < time; i++) {
                int n=Integer.parseInt(br.readLine());
                int[][] sale=new int[n][2];
                for (int j = 0; j < n; j++) {
                    String[] s = br.readLine().split(" ");
                    sale[j][0] = Integer.parseInt(s[1]);
                    sale[j][1] = Integer.parseInt(s[0]);
                }
                int res=0;
                for (int j = 0; j < n; j++) {
                    res+=sale[j][1];
                }
                System.out.println(res);
            }
        }
    }
}