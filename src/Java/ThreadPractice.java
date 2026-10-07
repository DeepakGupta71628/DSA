package Java;

import java.util.Locale;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPractice {
    static void main() throws ExecutionException, InterruptedException {
        countDownLatch();
    }

    public static void  threadCreationWithLambda(){
        Thread t1= new Thread() {
            @Override
            public void run() {
                System.out.println("thread");
            }
        };

        new Thread(()->{
            System.out.println("T2");
        }).start();
    }

    public static void ExecutorServiceAndPool() throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(5);

        executorService.execute(()-> System.out.print("T1"));
        Future<?> future = executorService.submit(()->{

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t2");
            return 2;
        });

        System.out.println(future.get());

        executorService.shutdown();
    }

    public static void countDownLatch(){
        CountDownLatch latch=new CountDownLatch(2);

        ExecutorService executorService= Executors.newFixedThreadPool(5);

        executorService.execute(()-> {
            System.out.print("T1");
            latch.countDown();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        executorService.execute(()-> {
            System.out.print("T2");
            latch.countDown();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.shutdown();
    }


    public static void completableFuturePractice(){

        //supplyAsync
        CompletableFuture<String> future1=CompletableFuture.supplyAsync(()->
        {
            return "future1";
        });

        //runAsync
        CompletableFuture<Void> future2=CompletableFuture.runAsync(()->System.out.println("runAsync"));

        future1.thenApply((string)-> string.toUpperCase()).thenAccept((name)->System.out.println(name))
                .thenRun(()->System.out.print("thenRun"));




       //CompletableFuture.allOf(future1,future2).thenCompose(()-> System.out.println("ab"));


        //Virtual Thread

        ExecutorService executorService= Executors.newVirtualThreadPerTaskExecutor();

    }



    static Integer  number=0;
    static Integer limit=10;

    ReentrantLock lock=new ReentrantLock();
    Condition condition=lock.newCondition();

    public static void printEvenOdd() throws InterruptedException{
        ThreadPractice threadPractice= new ThreadPractice();
        Thread even=new Thread(()->{
            try {
                threadPractice.printEven();
            }catch( InterruptedException e){
                Thread.currentThread().interrupt();
            }

        });
        Thread odd=new Thread(()->{
           try{
               threadPractice.printOdd();
           }catch(InterruptedException e){
               Thread.currentThread().interrupt();
           }
        });
        even.start();
        odd.start();
        even.join();
        odd.join();
    }

    public  synchronized void printEven() throws InterruptedException{

        while(number<=limit){
            while(number%2!=0){
                wait();
            }

            System.out.println(number);
            number++;
            notifyAll();
        }
    }

    public synchronized  void printOdd() throws InterruptedException {
        while(number<=limit){
            while(number%2==0){
                wait();
            }

            System.out.print("Odd");
            number++;
            notifyAll();

        }
    }

    public void printeven() throws InterruptedException{

        while(true){
            lock.lock();
            try{
                if(number>limit){
                    condition.signalAll();
                    return;
                }

                while(number%2!=0){
                    condition.await();
                }
                System.out.println(number);
                number++;
                condition.signalAll();
            }finally{
                lock.unlock();
            }

        }
    }
}
