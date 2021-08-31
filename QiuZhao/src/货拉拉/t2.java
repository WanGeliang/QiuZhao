package 货拉拉;

import java.util.Stack;

/**
 * @author Geliang
 * @date 2021-08-30
 * @slogan 致敬大师，致敬未来的你！
 */
public class t2 {
    public static void main(String[] args) {
        t2 me = new t2();
        String s = "()a()()";
        System.out.println(me.isValid(s, s.length()));
    }

    public boolean isValid(String s, int n) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
