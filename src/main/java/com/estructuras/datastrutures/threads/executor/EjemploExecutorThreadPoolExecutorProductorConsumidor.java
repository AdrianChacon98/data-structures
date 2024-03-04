package com.estructuras.datastrutures.threads.executor;

import com.estructuras.datastrutures.threads.ejemplosync.Consumidor;
import com.estructuras.datastrutures.threads.ejemplosync.Panaderia;
import com.estructuras.datastrutures.threads.ejemplosync.Panadero;

import java.util.concurrent.*;

public class EjemploExecutorThreadPoolExecutorProductorConsumidor {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {



        //Recuerda como tenemos 2 tareas que trabajan al mismo tiempo debemos poner al menos 2 cpu
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);


        //Override parameters of the pool
        //executor.setCorePoolSize();

        System.out.println("Tamaño del pool" + executor.getPoolSize());


        Panaderia p = new Panaderia();

        Runnable productor = new Panadero(p);

        Runnable consumidor = new Consumidor(p);

        Future<?> result1 = executor.submit(productor);

        Future<?> result2 = executor.submit(consumidor);







        System.out.println("Cantidad de tareas en cola:" + executor.getQueue().size());

        executor.shutdown(); //mejor una vez que se realizan todas las tareas se apaga


    }

}
