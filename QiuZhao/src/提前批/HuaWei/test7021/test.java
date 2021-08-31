package 提前批.HuaWei.test7021;

import java.util.Scanner;

/**
 * @author Geliang
 * @date 2021-07-21
 * @slogan 致敬大师，致敬未来的你！
 */
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K=sc.nextInt();
//        while (sc.hasNext()){
            for (int i = 0; i < K; i++) {
                String str=sc.nextLine();
                String[] s = str.split(" ");
                for(String c:s){
                    System.out.println(Integer.parseInt(c));
                }
            }

//        }
    }
}
