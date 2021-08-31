package 携程;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Geliang
 * @date 2021-08-12
 * @slogan 致敬大师，致敬未来的你！
 */
public class t1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int random = (int) (Math.random() * 30) + 1;
            double v = Double.parseDouble(str);
            if (v == 0) {
                System.out.println(0 + "/" + 1);
            } else if (v < 0 || v > 100) {
                System.out.println(0);
            } else {
                boolean flag = false;
                String s = "0";
                for (int i = 1; i <= 30; i++) {
                    if (!flag) {
                        for (int j = 1; j <= i; j++) {
                            double temp = ((j * 1.0) / i) * 100;
                            String result = String.format("%.2f", temp);

                            if (str.equals(result)) {
                                s = (j + "/" + i);
                                flag = true;
                                break;
                            }
                        }
                    } else {
                        System.out.println(s);
                        break;
                    }
                }
                if (!flag) {
                    System.out.println(s);
                }
            }
        }
    }
}
