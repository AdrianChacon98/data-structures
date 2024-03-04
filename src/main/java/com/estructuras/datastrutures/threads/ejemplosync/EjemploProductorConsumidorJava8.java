package com.estructuras.datastrutures.threads.ejemplosync;

import java.util.concurrent.ThreadLocalRandom;

public class EjemploProductorConsumidorJava8 {

    public static void main(String[] args) {

        //Using lambda expressions


        Panaderia p = new Panaderia();

        new Thread(()->{
            for(int i=0; i<10; i++){
                p.hornear("Pan n: " + i);
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500,800));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }).start();

        new Thread(()->{
            for(int i=0;i<10;i++){

                p.consumir();

            }
        }).start();


    }
}
