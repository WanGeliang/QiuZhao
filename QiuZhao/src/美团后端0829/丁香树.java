package 美团后端0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * @author Geliang
 * @date 2021-08-29
 * @slogan 致敬大师，致敬未来的你！
 */
public class 丁香树 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int m=Integer.parseInt(str);
            String[] s = br.readLine().split(" ");
            int[] arr= Arrays.asList(s).stream().mapToInt(Integer::parseInt).toArray();
            int[] dp=new int[arr.length];
            int count=0;
//            Arrays.fill(dp,0);
//            for (int i = 1; i < arr.length; i++) {
//                for (int j = 0; j < i; j++) {
//                    if(arr[i]>arr[j]){
//                        dp[i]=Math.max(dp[i],dp[j]+1);
//                    }
//                }
//            }
//            for (int i = 0; i < dp.length; i++) {
//                count+=dp[i];
//            }
            for (int i = 0; i < arr.length-1; i++) {
                for (int j = i+1; j < arr.length; j++) {
                    if(arr[j]>arr[i]){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
