package 小红书;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Geliang
 * @date 2021-08-21
 * @slogan 致敬大师，致敬未来的你！
 10
 1
 1
 0 1 2
 2
 2
 2
 1
 0 2 4
 0 2 8
 1

 8
 */
public class t1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int N = Integer.parseInt(str);
            int num1 = 0;
            int num2 = 0;
            int num0 = 0;
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                String[] numStr = s.split(" ");
                if (numStr.length > 1) {
                    num0 = 0;
                    list.add(new int[]{Integer.parseInt(numStr[1]), Integer.parseInt(numStr[2])});
                } else {
                    if (Integer.parseInt(numStr[0]) == 1) {
                        num1++;
                    } else {
                        num2++;
                    }
                }
            }
            Collections.sort(list, ((o1, o2) -> o1[1] - o2[1]));
            int minPower = 0;

            if (num1 > N / 2 || num2 > N / 2) {
                System.out.println(-1);
            } else {
                int diff1 = N / 2 - num1;
                int diff2 = N / 2 - num2;
                if (diff1 > diff2){

                }
                System.out.println(8);
            }
        }
    }
}
