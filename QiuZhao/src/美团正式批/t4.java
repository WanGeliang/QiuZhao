package 美团正式批;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Geliang
 * @date 2021-08-08
 * @slogan 致敬大师，致敬未来的你！
 */
public class t4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            int[] arr = new int[n];
            String[] s = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int[] leftNum = new int[n / 2];
            int[] rightNum = new int[n / 2];
            Set<Integer> leftSet = new HashSet<>();
            Set<Integer> rightSet = new HashSet<>();
            for (int i = 0; i < n / 2; i++) {
                leftNum[i] = arr[i];
                rightNum[i] = arr[i + n / 2];
                if (leftNum[i] != rightNum[i]) {
                    leftSet.add(leftNum[i]);
                    rightSet.add(rightNum[i]);
                }
            }
            System.out.println(Math.max(leftSet.size(), rightSet.size()));
        }
    }
}
