package 大疆测开;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Geliang
 * @date 2021-08-14
 * @slogan 致敬大师，致敬未来的你！
 */
public class t1 {
    public static void main(String[] args) throws InterruptedException {
        LockTest me = new LockTest();
        new Thread(() -> {
            try {
                LockTest.ClassLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                LockTest.ClassLock2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> me.ObjectLock()).start();
//        LockTest.ClassLock();
//        me.print();
//        me.ObjectLock();
    }
}

class LockTest {
//    LockTest lt = new LockTest();

    public void print() {
        System.out.println("print....");
    }

    public void ObjectLock() {
        synchronized (this) {
            System.out.println("对象锁");
        }
    }

    public static synchronized void ClassLock() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("类锁");
    }

    public static synchronized void ClassLock2() throws InterruptedException {
//        Thread.sleep(3000);
        System.out.println("类锁22222");
    }
}
