package Vivo提前批;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Geliang
 * @date 2021-06-17
 * @slogan 致敬大师，致敬未来的你！
 */
public class t1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null){
            String[] workers = str.split(" ");
            int count = 0;
            for(int i = 0, len = workers.length; i < len; i++){
                if(workers[i].contains("7") || Integer.parseInt(workers[i]) % 7 == 0){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
