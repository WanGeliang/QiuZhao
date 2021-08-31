package Soul0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author Geliang
 * @date 2021-08-26
 * @slogan 致敬大师，致敬未来的你！
 */


public class t1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String brackets = str.replace("\"", "").replace(" ", "");
            System.out.println(MissingBrackets(brackets));
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param brackets string字符串 brackets
     * @return string字符串
     */
    public static String MissingBrackets(String brackets) {
        int n = brackets.length();
        if (n % 2 == 1) return "Impossible";
        int left = 0, right = 0, question = 0;
        for (char c : brackets.toCharArray()) {
            switch (c) {
                case '(':
                    left++;
                    break;
                case ')':
                    right++;
                    break;
                case '?':
                    question++;
                    break;
            }
            if (left + question < right) return "Impossible";
        }
        char[] ans = brackets.toCharArray();
        int m = n / 2 - left;
        if (m < 0) return "Impossible";
        left = 0;
        right = 0;
        for (int i = 0; i < n; i++) {
            if (ans[i] == '(') left++;
            if (ans[i] == ')') right++;
            if (ans[i] == '?') {
                if (m > 0) {
                    ans[i] = '(';
                    m--;
                    left++;
                } else {
                    ans[i] = ')';
                    right++;
                }
            }
            if (left < right) return "Impossible";
        }
        return new String(ans);
    }

    public static String[] MissingBrackets(String[] brackets) {
        int n = brackets.length;
        int count = 0;
        for (int i = 0; i < n; i++) //统计左括号数
            if (brackets[i] == "(")
                count++;
        if (n % 2 == 1 || count * 2 > n) //不为偶数一定不合法，左括号数大于一般肯定不合法
            return new String[]{"Impossible"};
        int rest = n / 2 - count; //还需要补充多少左括号
        for (int i = 0; i < n; i++) {
            if (brackets[i] == "?" && rest != 0) {
                brackets[i] = "(";
                rest--;
            } else if (brackets[i] == "?")
                brackets[i] = ")";
        }
        int all = 0;
        for (int i = 0; i < n; i++) { //检查修改后内容是否合法
            if (brackets[i] == "(")
                all++;
            else if (brackets[i] == ")")
                all--;
            if (all < 0)
                return new String[]{"Impossible"};
        }
        return brackets;
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
