package 携程;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Geliang
 * @date 2021-08-12
 * @slogan 致敬大师，致敬未来的你！
 */
public class t2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            str = br.readLine();
            int count = 0;
            List<Integer> list = new ArrayList<>();
            StringBuilder sb ;
            StringBuilder resSb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb = new StringBuilder(str);
                if (isValid(sb.deleteCharAt(i).toString())) {
                    count++;
                    resSb.append(i + 1).append(" ");
                }
            }
            System.out.println(count);
            System.out.println(resSb.toString().trim());
        }
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }
}
