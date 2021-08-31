package datasource_queue.src.com.wgl;

import java.util.Scanner;

/**
 * @author 万葛亮
 * @Date 2020 06 10 9:45
 * @GIRL friend 江珊
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArray circleArray = new CircleArray(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);

        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列中取数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    circleArray.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数字");
                    int i = scanner.nextInt();
                    circleArray.addQueue(i);
                    break;
                case 'g':
                    try {
                        int res = circleArray.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = circleArray.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出....");
    }
}


class CircleArray {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArray(int Size) {
        maxSize = Size;
        arr = new int[maxSize];
        front = 0;
        rear = 0;

    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满,不能添加数据");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }


    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列
    public void showQueue() {
        if ((isEmpty())) {
            System.out.println("队列空的，没有数据");
            return;
        }
        for (int i = front; i < front + (rear + maxSize - front)%maxSize; i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);

        }
    }

    //队列头
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("没有数据");
        }
        return arr[(front + maxSize) % maxSize];
    }

}
