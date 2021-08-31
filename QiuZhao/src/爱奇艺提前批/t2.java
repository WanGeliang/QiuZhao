package 爱奇艺提前批;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Geliang
 * @date 2021-08-01
 * @slogan 致敬大师，致敬未来的你！
 */
public class t2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] s = str.split(",");
            int len = s.length;
            int[] arr = new int[len];
            for (int i = 0; i < len - 1; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            String[] window = s[len - 1].split(":");
            arr[len - 1] = Integer.parseInt(window[0]);
            int size = Integer.parseInt(window[1]);
            int num = len - size + 1;


            int[] slide = new int[num];
            float[] mean = new float[num];
            for (int i = 0; i < size; i++) {
                slide[0] += arr[i];
            }
            mean[0] = slide[0] / 3;
            float max = Integer.MIN_VALUE;

            for (int i = 1; i < num; i++) {
                slide[i] = slide[i - 1] - arr[i - 1] + arr[i + size - 1];
                max = Math.max(max, (float) (slide[i] - slide[i - 1]) / slide[i - 1]);
            }
            max *= 100;
            String.format("%.2f", max);
            System.out.println(String.format("%.2f", max) + "%");

        }
    }
}
