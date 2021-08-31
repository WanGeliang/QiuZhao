package ZuoShen.StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author Geliang
 * @date 2021-07-27
 * @slogan 致敬大师，致敬未来的你！
 */
public class TwoStackQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public TwoStackQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void add(int val) {
        s1.push(val);
    }

    // 刚开始直接将其加入到一个栈中，后面需要进行poll时，才将另外一个栈里面的元素全部都加进去
    public int poll() {
        if (s1.isEmpty() && s2.isEmpty()) return -1;
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    // 取队头元素
    public int peek(){
        if (s1.isEmpty() && s2.isEmpty()) return -1;
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        TwoStackQueue me = new TwoStackQueue();
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            for (int i = 0; i < 3; i++) {
                me.add(Integer.parseInt(s[i]));
            }
            System.out.println(me.poll());
//            System.out.println(me.s2.size());
            System.out.println(me.poll());
            System.out.println(me.poll());
            System.out.println(me.poll());
            System.out.println(" ********");
            for (int i = 3; i < s.length; i++) {
                me.add(Integer.parseInt(s[i]));
            }
            System.out.print(me.poll());
            System.out.print(me.poll());
            System.out.print(me.poll());
        }
    }
}
