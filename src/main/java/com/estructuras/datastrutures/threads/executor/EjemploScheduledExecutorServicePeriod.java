package com.estructuras.datastrutures.threads.executor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploScheduledExecutorServicePeriod {

    public static void main(String[] args) throws InterruptedException {


        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);


        System.out.println("Alguna tarea en el main1 ....");

        //CountDownLatch lock = new CountDownLatch(5);//contador

        AtomicInteger counter = new AtomicInteger(5);


        Future<?> future = executor.scheduleAtFixedRate(()->{
            System.out.println("Hola mundo tarea programada");
            try {
                //TimeUnit.MICROSECONDS.sleep(1000);
                Thread.sleep(1000);

                //lock.countDown();

                counter.getAndDecrement();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }



        },1,2, TimeUnit.SECONDS);


        //TimeUnit.SECONDS.sleep(10); //cantidad de tiempo antes de que haga shutdown



        //CountDownLatch

        //lock.await();//hasta que llege a cero espera y despues libera el thread

        //future.cancel(true);//cancelamos el task



        //Only with AtomicInteger

        while(counter.get()>=0){
            if(counter.get()==0) {
                future.cancel(true);
                counter.getAndDecrement();
            }
        }



        System.out.println("Alguna tarea en el main2 ....");




        executor.shutdown();


    }


}
