package com.estructuras.datastrutures.threads.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EjemploExecutor {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable tarea = ()->{

            System.out.println("Inicio de la tarea....");
            try {
                System.out.println(Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);//equivale al sleep
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }

            System.out.println("finaliza la tarea");
        };


        executor.submit(tarea);

        executor.shutdown(); //mejor una vez que se realizan todas las tareas se apaga


        System.out.println("continuando con la ejecucion del metodo main 1");


        //executor.awaitTermination(2,TimeUnit.SECONDS);//esperar a que finalice todas las tareas y luego que se detenga el executor para continuar con la ejecucion del metodo main o hilo principal

        System.out.println("continuando con la ejecucion del metodo main 2");


    }


}
