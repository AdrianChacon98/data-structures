package com.estructuras.datastrutures.threads.executor;

import java.util.concurrent.*;

public class EjemploExecutorFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

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


        // Future<?> result = executor.submit(tarea);
        Future<String> result = executor.submit(tarea);

        executor.shutdown(); //mejor una vez que se realizan todas las tareas se apaga


        System.out.println("continuando con la ejecucion del metodo main 1");


        //executor.awaitTermination(2,TimeUnit.SECONDS);//esperar a que finalice todas las tareas y luego que se detenga el executor para continuar con la ejecucion del metodo main o hilo principal

        System.out.println("continuando con la ejecucion del metodo main 2");

        System.out.println(result.isDone());


        while(!result.isDone()){
            System.out.println("ejecutando tarea ......");
            TimeUnit.MICROSECONDS.sleep(3000);
        }

        System.out.println(result.get(4,TimeUnit.SECONDS));//similara al metodo join //error el tiempo de espera agregar mas tiempo mayor con el que tiene el thread.sleep de hilo
        System.out.println("Continuamos.....");
    }


}
