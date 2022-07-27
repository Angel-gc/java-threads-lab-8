import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
//    public static void main(String[] args) {
//        ExecutorService executor = Executors.newSin;
//        List<Future> futureList = new ArrayList<Future>();
//
//        Future<String> f1 = executor.submit(() -> {
//            return "s" + "u" + "n";
//        });
//        Future<String> f2 = executor.submit(() -> {
//            return f1.get() + " moon";
//        });
//        Future<String> f3 = executor.submit(() -> {
//            return "s" + "u" + "n";
//        });
//        futureList.add(f1);
//        futureList.add(f2);
//        futureList.add(f3);
//
//        System.out.println(countFinishedFutures(futureList));
//    }
    public static Callable<String> getCollableString(){
        
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