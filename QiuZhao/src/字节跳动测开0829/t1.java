package 字节跳动测开0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Geliang
 * @date 2021-08-29
 * @slogan 致敬大师，致敬未来的你！
 */
public class t1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str=br.readLine())!=null){
            int time=Integer.parseInt(str);
            for (int i = 0; i < time; i++) {
                String[] s = br.readLine().split(" ");
                int a=Integer.parseInt(s[0]);
                int b=Integer.parseInt(s[1]);
                int c=Math.abs(a-b);
                if(c==0){
                    System.out.println(0);
                }else if(c==1){
                    System.out.println(1);
                }else if (c==2){
                    System.out.println(3);
                }else if(c==3){
                    System.out.println(2);
                }else if(c==4){
                    System.out.println(4);
                }else if (c==5){
                    System.out.println(5);
                }else if(c==6){
                    System.out.println(4);
                }else if(c==7){
                    System.out.println(5);
                }else if(c==8){
                    System.out.println(4);
                }else if(c==9){
                    System.out.println(5);
                }else if (c==10){
                    System.out.println(4);
                }
            }
        }
    }
}
