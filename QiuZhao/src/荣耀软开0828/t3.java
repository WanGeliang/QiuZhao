package 荣耀软开0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Geliang
 * @date 2021-08-28
 * @slogan 致敬大师，致敬未来的你！
 */
public class t3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str=br.readLine())!=null){
            String[] s = str.split(" ");
            int m=Integer.parseInt(s[0]);
            int n=Integer.parseInt(s[1]);
            s = br.readLine().split(" ");
            int[] arr=Arrays.asList(s).stream().mapToInt(Integer::parseInt).toArray();
            int res=resolve(arr,m);
            System.out.println(res);
        }
    }
    private static int resolve(int[] arr, int m) {
        // 最短作业优先
        Arrays.sort(arr);
        int[] cpu = new int[m];
        int time = 0; // 总时间
        int j = 0; // 任务指针
        int aCount = 0; // 空闲cpu数
        while (j != arr.length || aCount != m) {
            // 填充任务
            for (int i = 0; i < m; i++) {
                // 取任务
                if (cpu[i] == 0 && j < arr.length) {
                    cpu[i] = arr[j];
                    j++;
                }
            }
            // 运行任务
            time++;
            // 运行结果和状态
            aCount = 0;
            for (int i = 0; i < m; i++) {
                if (cpu[i] != 0) {
                    cpu[i]--;
                }
                if (cpu[i] == 0) {
                    aCount++;
                }
            }
        }
        return time;
    }
}
