package datasource_stack.src.stack;

import java.util.Scanner;

/**
 * @author 万葛亮
 * @Date 2020 07 07 11:42
 * @GIRL friend 江珊
 */


//使用链表模拟栈
public class LinkedToStack {
    public static void main(String[] args) {
        //测试类
        Stack2 stack = new Stack2();
        String key = "";
        boolean loop = true; //控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key) {
                case "s":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是 %d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case "e":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出~~~");
    }
}


class Stack2 {
    //链表实现不需要考虑是否为满的情况，因为是链式的，根据计算机空间而定

    //定义一个头节点
    Node head = new Node(0);

    //临时变量，保存头节点
    Node temp = head;

    //判断是否为空
    public boolean isEmpty() {
        return head.next == null;
    }

    //进栈
    public void push(int value) {
        Node node = new Node(value);
        temp.next = node;
        temp = temp.next;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return -1;
        }
        Node pre = head;
        while (true) {
            if (pre.next == temp) {
                break;
            }
            pre = pre.next;
        }
        pre.next = temp.next;//temp.next=null，将pre至于链表的最后
        int value = temp.no;
        temp = pre;//再将pre指向最后（temp）
        return value;
    }

    //遍历栈
    public void list() {
        temp = head;
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        while (true) {
            if (temp.next == null) {
                break;
            }
            System.out.println(temp.next.no);
            temp = temp.next;
        }

    }
}

//在这个类里面定义节点
class Node {
    int no;
    Node next;

    public Node(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }
}



