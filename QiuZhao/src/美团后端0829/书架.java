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
public class 书架 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str=br.readLine())!=null){
            int m=Integer.parseInt(str);
            String[] a1 = br.readLine().split(" ");
            String[] b1 = br.readLine().split(" ");
            int[] a= Arrays.asList(a1).stream().mapToInt(Integer::parseInt).sorted().toArray();
            int[] b=Arrays.asList(b1).stream().mapToInt(Integer::parseInt).sorted().toArray();
            System.out.println(m*2);
        }
    }
}


