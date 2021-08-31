package hello单车;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Geliang
 * @date 2021-08-23
 * @slogan 致敬大师，致敬未来的你！
 */
public class t1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str=br.readLine())!=null){
            int n=Integer.parseInt(str);
            String[] s = br.readLine().split(" ");
            int[] arr=new int[s.length];
            for (int i = 0; i < s.length; i++) {
                arr[i]=Integer.parseInt(s[i]);
            }
            int[] index=new int[s.length];
            index[0]=1;
            for (int i = 1; i < s.length; i++) {
                if(arr[i-1]==arr[i]){
                    index[i]=index[i-1];
                }else {
                    index[i]=1+index[i-1];
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < index.length; i++) {
                sb.append(index[i]+" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
