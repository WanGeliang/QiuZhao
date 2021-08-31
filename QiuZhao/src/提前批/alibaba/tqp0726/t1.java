package 提前批.alibaba.tqp0726;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Geliang
 * @date 2021-07-26
 * @slogan !!!!!
 * 2
 * 2
 * 25 16 33 6 2
 * 49 41 1 11 1
 * 2
 * 2 1 6 0 2
 * 1 3 4 5 10
 */
public class t1 {
    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(System.in);
        // 测试数据的组数
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int T = Integer.parseInt(br.readLine());
//        for (int i = 0; i < T; i++) {
        while ((str = br.readLine()) != null && T > 0) {
            // 每组测试数据的雨棚个数
            int n = Integer.parseInt(str);

            Map<Integer, double[]> map = new HashMap<>();
            double[] sale = new double[n];
            // 每组进行封装
            for (int j = 0; j < n; j++) {
                String[] s = br.readLine().split(" ");
                double[] temp = new double[4];
                for (int k = 0; k < 4; k++) {
                    temp[k] = Double.parseDouble(s[k]);
                }
                map.put(j, temp);
                sale[j] = Double.parseDouble(s[4]);
            }
            // 长度
            double[] res = new double[n];
            double count = Double.MAX_VALUE;
            int flag = 0;
            for (int j = 0; j < n; j++) {
                // 长度*单位价格除以阴影长度
                res[j] = sale[j] * Math.sqrt(Math.pow(Math.abs(map.get(j)[0] - map.get(j)[2]), 2) +
                        Math.pow(Math.abs(map.get(j)[1] - map.get(j)[3]), 2)) /
                        Math.abs(map.get(j)[0] - map.get(j)[2]);
                // 显示出每一个的价格
                System.out.println(res[j]);
                if (res[j] < count) {
                    flag = j + 1;
                    count = res[j];
                }
            }
            System.out.println(flag);
            T--;
        }
    }
}
