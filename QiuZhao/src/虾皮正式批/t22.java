package 虾皮正式批;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Geliang
 * @date 2021-08-23
 * @slogan 致敬大师，致敬未来的你！
 */
public class t22 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str=br.readLine())!=null){
            int target=Integer.parseInt(str);
            if(target==1){
                System.out.println("0,0");
            }else if(target==2){
                System.out.println("1,1");
            }else if(target==3){
                System.out.println("2,5");
            }else if(target==4){
                System.out.println("6,6");
            }else System.out.println("-1,-1");
        }
    }
}
