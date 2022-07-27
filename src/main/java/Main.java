import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        List<Future> futureList = new ArrayList<>();

        Future<String> f1 = executor.submit(() -> "s" + "u" + "n");
        Future<String> f2 = executor.submit(() -> f1.get()+" moon");
        Future<String> f3 = executor.submit(() -> "s" + "u" + "n");
        Future<Integer> f4 = executor.submit(()-> 5);

        futureList.add(f1);
        futureList.add(f2);
        futureList.add(f3);
        futureList.add(f4);

        System.out.println("# of futures: " + futureList.size());
        System.out.println("finished futures: " +countFinishedFutures(futureList));
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