package com.estructuras.datastrutures.threads.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EjemploScheduledExecutorService {

    public static void main(String[] args) {


        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);


        System.out.println("Alguna tarea en el main1 ....");

        executor.schedule(()->{
            System.out.println("Hola mundo tarea programada");
            try {
                TimeUnit.MICROSECONDS.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }



        },2000, TimeUnit.MICROSECONDS);


        System.out.println("Alguna tarea en el main2 ....");

        executor.shutdown();


    }


}
