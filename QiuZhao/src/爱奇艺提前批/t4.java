package 爱奇艺提前批;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.stream.Collectors;


public class t4 {


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Solution s = new Solution();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(10000));
        final Scanner reader = new Scanner(System.in);
        final String next = reader.next();
        List<Line> lines = Arrays.stream(next.split(",")).map(str -> new StringLine(str))
                .collect(Collectors.toList());

        List<Line> result = s.translateAll(lines, "", threadPoolExecutor);
        String resultString = result.stream().map(l -> l.toString()).collect(Collectors.joining(","));
        System.out.println(resultString);
        reader.close();
        threadPoolExecutor.shutdown();
    }

    public interface Line {

        Line translate(String language);
    }

    public static class Solution {

        public List<Line> translateAll(List<Line> lines, String language, Executor executor) throws InterruptedException, ExecutionException {
            Job<Line> job = new Job<>();
            for (Line line : lines) {
                Callable<Line> callable = () -> line.translate(language);
                job.newTask(callable);
            }
            job.execute(executor);
            return job.get();
        }
    }

    public static class Job<V> {
        List<FutureTask<V>> list=new ArrayList<>();
        public void newTask(Callable<V> runnable) {
            //待实现
            FutureTask<V> futureTask = new FutureTask<>(runnable);
            list.add(futureTask);
        }


        public void execute(Executor executor) {
            //待实现
            for (FutureTask<V> futureTask:list){
                executor.execute(futureTask);
            }
        }

        public List<V> get() throws InterruptedException, ExecutionException {
            //待实现
            List<V> res=new ArrayList<>();
            for (FutureTask<V> futureTask:list){
                res.add(futureTask.get());
            }
            return res;
        }

    }

    /**
     * translate the string line to upper case
     */
    public static class StringLine implements Line {
        private String text;

        public StringLine(String text) {
            this.text = text;
        }

        @Override
        public Line translate(String language) {
            return new StringLine(text.toUpperCase());
        }


        @Override
        public String toString() {
            return text;
        }
    }
}