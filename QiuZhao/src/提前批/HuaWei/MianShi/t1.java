package 提前批.HuaWei.MianShi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Geliang
 * @date 2021-08-02
 * @slogan 致敬大师，致敬未来的你！
 */
// 排列一个数
public class t1 {
    static HashSet set;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int sum = recursion(n);
            set = new HashSet<>();
//            System.out.println(sum);
            if (k < 0 || k > sum) {
                System.out.println(-1);
                continue;
            }
            back(0, n);
            String[] sss = (String[]) set.toArray(new String[sum]);
            Arrays.sort(sss);
            System.out.println(Arrays.toString(sss));
            System.out.println(sss[sss.length - k]);
        }
    }

    public static void back(int start, int size) {
        if (sb.length() == size) {
            if (!set.contains(sb.toString())) {
                set.add(sb.toString());
            }
            return;
        }
        for (int i = 1; i <= size; i++) {
            if (sb.toString().contains(i + "")) {
                continue;
            }
            sb.append(i);
            back(0, size);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static int recursion(int n) {
        if (n == 1) return 1;
        return n * recursion(n - 1);
    }
}
