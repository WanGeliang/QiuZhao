package 华为机考练习;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Geliang
 * @date 2021-08-24
 * @slogan 致敬大师，致敬未来的你！
 */
public class HJ94 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int num = Integer.parseInt(str);
            String[] person = br.readLine().split(" ");
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < num; i++) {
                map.put(person[i], 0);
            }
            int voteNum = Integer.parseInt(br.readLine());
            String[] vote = br.readLine().split(" ");
            for (int i = 0; i < voteNum; i++) {
                if (map.containsKey(vote[i])) {
                    map.put(vote[i], map.get(vote[i]) + 1);
                }
            }
            int count = 0;
            for (int i = 0; i < num; i++) {
                int voteResNum = map.get(person[i]);
                if (voteResNum != 0) count++;
                System.out.println(person[i] + " : " + voteResNum);
            }
            System.out.println("Invalid" + " : " + (voteNum - count));
        }
    }
}
