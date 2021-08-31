package InterviewStack;

import java.util.Stack;

public class sortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(2);
        stack.push(1);
        stack.push(3);

        // 只允许定义一个辅助栈
        Stack<Integer> help=new Stack<>();
        while(!stack.isEmpty()){
            int temp=stack.pop();
            while(!help.isEmpty()&&help.peek()>temp){
                int top=help.pop();
                stack.push(top);
            }
            help.push(temp);
        }
        while(!help.isEmpty()) System.out.println(help.pop());
    }
//    public Stack<Integer>
}
