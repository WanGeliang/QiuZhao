package CommonTest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @author Geliang
 * @date 2021-07-19
 * @slogan 致敬大师，致敬未来的你！
 */
public class JUCTest {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        Semaphore semaphore = new Semaphore(4);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        cyclicBarrier.await();

        cyclicBarrier.reset();
        try {
            semaphore.acquire(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release(2);
    }
}
