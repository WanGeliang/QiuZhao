package 爱奇艺提前批;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Geliang
 * @date 2021-08-01
 * @slogan 致敬大师，致敬未来的你！
 */
public class t3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String s = str.replace("[", "");
            s = s.replace("]", "");
            String[] sp = s.split(",");
            int[] rains = new int[sp.length];
            int[] ans = new int[sp.length];
            for (int i = 0; i < rains.length; i++) {
                rains[i] = Integer.parseInt(sp[i]);
                if (rains[i] > 0) {
                    ans[i] = -1;
                } else if (rains[i] == 0) {
                    ans[i] = i;
                }
            }
            Arrays.sort(rains);
            if (rains[0] == rains[rains.length - 1]) System.out.println(new int[]{});
            System.out.println(Arrays.toString(ans));
        }
    }
}
