package datasource_queue.src.com.wgl;

import java.util.Queue;
import java.util.Scanner;

/**
 * @author 万葛亮
 * @Date 2020 06 09 22:37
 * @GIRL friend 江珊
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key =' ';
        Scanner scanner = new Scanner(System.in);

        boolean loop=true;
        while (loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列中取数据");
            System.out.println("h(head): 查看队列头的数据");
            key=scanner.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数字");
                    int i = scanner.nextInt();
                    arrayQueue.addQueue(i);
                    break;
                case 'g':
                    try {
                        int res= arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res= arrayQueue.headQueue();
                        System.out.printf("队列头的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出....");
    }
}

//使用数组模拟队列，编写一个ArrayQueue类
class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int Size) {
        maxSize = Size;
        arr = new int[maxSize];
        front = -1;
        rear = -1;

    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }

    //显示队列
    public void showQueue(){
        if ((isEmpty()))
        {
            System.out.println("队列空的，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);

        }
    }
    //队列头
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("没有数据");
        }
        return arr[front+1];
    }
}
