import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        List<Future> futureList = new ArrayList<>();

        Future<String> f1 = executor.submit(() -> "s" + "u" + "n");
        Future<String> f2 = executor.submit(() -> f1.get()+" moon");
        Future<String> f3 = executor.submit(() -> "s" + "u" + "n");
        Future<Integer> f4 = executor.submit(()-> 5);
        Future<Integer> f5 = executor.submit(getCallableInt());
        futureList.add(f1);
        futureList.add(f2);
        futureList.add(f3);
        futureList.add(f4);
        futureList.add(f5);

        System.out.println("# of futures: " + futureList.size());
        for(Future f: futureList){
            System.out.println(f.get());
        }
        System.out.println("finished futures: " +countFinishedFutures(futureList));
        executor.shutdown();
    }
    public static Callable<String> getCallableString(){
        Callable<String> cs = () -> {
            return "hello I am a string within a callable";
        };
        return cs;
    }

    public static Callable<Integer> getCallableInt () {
        Callable<Integer> ci = () -> {
            return (Integer) 50;
        };
        return ci;
    }

    public static int countFinishedFutures(List<Future> futures) {
        // your code here
        int count = 0;

        for (Future f : futures){
            if(f.isDone()){
                count++;
            }
        }
        return count;
    }
}