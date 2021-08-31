import java.util.concurrent.*;

public class MyTest {
    public static void main(String[] args) {
//        Executors.newFixedThreadPool()
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 1, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5));

        System.out.println("dddd".toString());
    }

    @Override
    public String toString() {
        return "1222";
    }
}
