package com.estructuras.datastrutures.threads.executor;

import java.util.concurrent.*;

public class EjemploExecutorThreadPoolExecutor {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        //ExecutorService executor = Executors.newSingleThreadExecutor();

        //ExecutorService executor = Executors.newFixedThreadPool(2);//Using 3cpu


        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);




        //Override parameters of the pool
        //executor.setCorePoolSize();

        System.out.println("Tamaño del pool" + executor.getPoolSize());






        /*Runnable tarea = ()->{

            System.out.println("Inicio de la tarea....");
            try {
                System.out.println(Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);//equivale al sleep
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }

            System.out.println("finaliza la tarea");
        };*/

        Callable<String> tarea = ()->{
            System.out.println("Inicio de la tarea....");
            try {
                System.out.println(Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);//equivale al sleep
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }

            System.out.println("finaliza la tarea");

            return "Algun resultado importante de la tarea";
        }; //el return lo obtenemos con el result.get();



        Callable<Integer> tarea2 = ()->{
            System.out.println("Iniciando tarea 3");
            System.out.println(Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(3);
            return 10;
        };


        // Future<?> result = executor.submit(tarea);
        Future<String> result = executor.submit(tarea);

        Future<String> result2 = executor.submit(tarea);

        Future<Integer> result3 = executor.submit(tarea2);



        System.out.println("Cantidad de tareas en cola:" + executor.getQueue().size());

        executor.shutdown(); //mejor una vez que se realizan todas las tareas se apaga


        System.out.println("continuando con la ejecucion del metodo main 1");


        //executor.awaitTermination(2,TimeUnit.SECONDS);//esperar a que finalice todas las tareas y luego que se detenga el executor para continuar con la ejecucion del metodo main o hilo principal

        System.out.println("continuando con la ejecucion del metodo main 2");

        System.out.println(result.isDone());


        while(!(result.isDone() && result2.isDone() && result3.isDone()) ){
            System.out.println(String.format("Resultado1: %s - Resultado2: %s - resultado3: %s",
                    result.isDone() ? "Finalizo":"en proceso",
                    result2.isDone() ? "Finalizo":"en proceso",
                    result3.isDone() ? "Finalizo":"en proceso"));
            Thread.sleep(1000);
        }

        System.out.println(result.get(4,TimeUnit.SECONDS));//similara al metodo join //error el tiempo de espera agregar mas tiempo mayor con el que tiene el thread.sleep de hilo
        System.out.println("Continuamos.....");
    }


}
