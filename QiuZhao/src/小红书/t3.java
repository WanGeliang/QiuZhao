package 小红书;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

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
            int N = Integer.parseInt(str);
            int[][] time = new int[N][3];
            for (int i = 0; i < N; i++) {
                String[] s1 = br.readLine().split("-");
                String[] s2 = s1[0].split(":");
                time[i][0] = Integer.parseInt(s2[0]) * 60 + Integer.parseInt(s2[1]);
                s2 = s1[1].split(":");
                time[i][1] = Integer.parseInt(s2[0]) * 60 + Integer.parseInt(s2[1]);
                time[i][2] = time[i][1] - time[i][0];
            }
            Arrays.sort(time, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    } else return o1[0] - o2[0];
                }
            });
            int maxTime = 0;
            for (int i = 0; i < N - 2; i++) {
                for (int j = i + 1; j < N - 1; j++) {
                    if (time[i][1] > time[j][0]) {
                        continue;
                    }
                    for (int k = j + 1; k < N; k++) {
                        if (time[j][1] <= time[k][0]) {
                            maxTime = Math.max(maxTime, time[i][2] + time[j][2] + time[k][2]);
                        }
                    }
                }
            }
            System.out.println(maxTime);
        }
    }

}
