package ZuoShen.StackAndQueue;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author Geliang
 * @date 2021-07-27
 * @slogan 致敬大师，致敬未来的你！
 */
public class getMin {
    Stack<Integer> s1;
    // 定义一个专门用来记录s2最小值的栈
    Stack<Integer> s2;

    // 初始化
    public getMin() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // 将数据进行入栈
    public void push(int val) {
        if (s2.isEmpty()) {
            s2.push(val);
        } else if (s2.peek() > val) {
            s2.push(val);
        } else {
            s2.push(s2.peek());
        }
        s1.push(val);
    }

    // 将原来的数据进行出栈
    public int pop() {
        if (s1.isEmpty()) return -1;
        s2.pop();
        return s1.pop();
    }

    // 获取最小值
    public int getmin() {
        if (s2.isEmpty()) return -1;
        return s2.peek();
    }

    public static void main(String[] args) throws IOException {
        getMin me = new getMin();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            for (int i = 0; i < s.length; i++) {
                me.push(Integer.parseInt(s[i]));
            }
            while (!me.s1.isEmpty()) {
                System.out.println(me.getmin());
                me.pop();
            }
        }
    }
}
