package CommonTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Geliang
 * @date 2021-07-30
 * @slogan 致敬大师，致敬未来的你！
 */
public class Synch {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 2, 1, TimeUnit.MILLISECONDS,new ArrayBlockingQueue(3));
        Synch me = new Synch();
        for (int i = 0; i < 500; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    me.set();
                }
            });

        }
        for (int i = 0; i < 500; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    me.set2();
                }
            }).start();
        }
    }

    public void set() {
        Object obj;
        Integer integer= new Integer(1);
        synchronized (integer) {
            System.out.println("获取到了锁11111111");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void set2() {
        Object obj;
        Integer integer= new Integer(1);
        synchronized (integer) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("获取到了锁22222222");
        }
    }
}
