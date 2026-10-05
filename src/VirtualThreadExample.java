import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadExample {
    static void main() {
        ExecutorService executors= Executors.newVirtualThreadPerTaskExecutor();
        executors.submit(()->System.out.print("abcd"));

        executors.shutdown();
    }
}
