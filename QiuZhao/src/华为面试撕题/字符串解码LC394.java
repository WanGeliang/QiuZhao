package 华为面试撕题;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Geliang
 * @date 2021-08-30
 * @slogan 致敬大师，致敬未来的你！
 */
public class 字符串解码LC394 {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        字符串解码LC394 me = new 字符串解码LC394();
        System.out.println(me.decodeString(s));
    }

    public String decodeString(String s) {
        Stack<String> strStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int mul = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                intStack.push(mul);
                strStack.push(sb.toString());
                sb = new StringBuilder();
                mul = 0;
            } else if (c == ']') {
                StringBuilder sbTemp = new StringBuilder();
                int size = intStack.pop();
                String curStr = sb.toString();
                for (int i = 0; i < size; i++) {
                    sbTemp.append(curStr);
                }
                sb = new StringBuilder(strStack.pop() + sbTemp.toString());
            } else if ('0' <= c && c <= '9') {
                mul = mul * 10 + (c - '0');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

