package org.practice.multithreading;

import lombok.SneakyThrows;

public class PetersonsAlgorithm {

    static int count  =  0;

    static int turn;

    static boolean[] flag= new boolean[2];


    private synchronized static void increment(int k ){

        System.out.println("Thread "+k+ " "+Thread.currentThread().getId());
        for(int i = 0; i < 10000000;i++){
//            System.out.println(k++);
            count++;
        }
    }
    @SneakyThrows
    public static void execute1(){
        Thread t1 = new Thread(() -> {
            System.out.println("Thread 0 "+Thread.currentThread().getId());
            turn = 1;
            flag[0] = true;
            System.out.println("Thread 0 "+Thread.currentThread().getId());
            while(flag[1] && turn  == 1){
                System.out.println("wait 0");
            }
            System.out.println("Thread 0 "+Thread.currentThread().getId());
            increment(0);
            flag[0] = false;
        });
        Thread t2 = new Thread(() -> {
            System.out.println("Thread 1 "+Thread.currentThread().getId());
            turn = 0;
            flag[1] = true;
            System.out.println("Thread 1 "+Thread.currentThread().getId());
            while(flag[0] && turn  == 0){
                System.out.println("wait  1");
            }
            System.out.println("Thread 1 "+Thread.currentThread().getId());
            increment(1);
            flag[1] = false;
        });
        System.out.println("count = " + count);
        t1.start();
        t2.start();

        t1.join();

        t2.join();

        System.out.println("count = " + count);

    }

    @SneakyThrows
    public static void execute(){
        Thread t1 = new Thread(() -> {
            System.out.println("Thread 0 "+Thread.currentThread().getId());
////            flag[0] = true;
//            System.out.println("Thread 0 "+Thread.currentThread().getId());
//            while(turn  == 1){
////                System.out.println("wait 0");
//            }
//            turn = 1;
//            System.out.println("Thread 0 "+Thread.currentThread().getId());
                increment(0);


//            turn = 0;
        });
        Thread t2 = new Thread(() -> {
            System.out.println("Thread 1 "+Thread.currentThread().getId());

////            flag[1] = true;
//            System.out.println("Thread 1 "+Thread.currentThread().getId());
//            while(turn  == 1){
////                System.out.println("wait  1");
//            }
//            turn = 1;
//            System.out.println("Thread 1 "+Thread.currentThread().getId());
            increment(1);
//            turn = 0;
        });
        System.out.println("count = " + count);
        t1.start();
        t2.start();

        t1.join();

        t2.join();

        System.out.println("count = " + count);


//        for(int i =0 ; i< Integer.MAX_VALUE; i++){
//            Thread t = new Thread(() -> {
//                System.out.println("Hello from "+ Thread.currentThread().getId());
//                System.out.println(Runtime.getRuntime().freeMemory());
//                System.out.println(Runtime.getRuntime().availableProcessors());
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//            t.start();
//        }
    }

}
