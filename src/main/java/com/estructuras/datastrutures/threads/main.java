package com.estructuras.datastrutures.threads;

public class main {

    public static void main(String [] args) throws InterruptedException {
        //Thread



        /*CalculoThread t1 =  new CalculoThread("Adrian");
        t1.start();

        CalculoThread t2 = new CalculoThread("Rogelio");
        t2.start();

        CalculoThread t3 = new CalculoThread("Chacon");
        t3.start();*/




        //Runnable




        /*new Thread(new CalculoRunnable("isla hawai")).start();
        new Thread(new CalculoRunnable("las vegas")).start();
        new Thread(new CalculoRunnable("california")).start();
        new Thread(new CalculoRunnable("NEW YORK")).start();*/





        //Lambda expression and Runnable





       /* Runnable viaje = new Runnable(){
          @Override
          public void run(){

              for(int i=0; i<10; i++){

                  try {
                      System.out.println(i + " - " + Thread.currentThread().getName());
                      Thread.sleep((long)Math.random() * 100);
                  }catch (InterruptedException e){}
              }
              System.out.println("Finally i am going to travel to: "+ Thread.currentThread().getName());
          }
        };

        new Thread(viaje,"isla hawai").start();
        new Thread(viaje,"las vegas").start();
        new Thread(viaje,"new york").start();

        //Lambda expression

        Runnable viajeLambda = ()->{

            for(int i=0; i<10; i++){

                try {
                    System.out.println(i + " - " + Thread.currentThread().getName());
                    Thread.sleep((long)Math.random() * 100);
                }catch (InterruptedException e){}
            }
            System.out.println("Finally i am going to travel to: "+ Thread.currentThread().getName());

        };


        new Thread(viaje,"isla hawai").start();
        new Thread(viaje,"las vegas").start();
        new Thread(viaje,"new york").start();*/












        //Join vs Sleep Methods







        /*Thread main = Thread.currentThread();

        Runnable viaje = new Runnable(){
            @Override
            public void run(){

                for(int i=0; i<10; i++){

                    try {
                        System.out.println(i + " - " + Thread.currentThread().getName());
                        Thread.sleep((long)Math.random() * 100);
                    }catch (InterruptedException e){}
                }
                System.out.println("Finally i am going to travel to: "+ Thread.currentThread().getName());
                System.out.println(main.getState());//se ejecutara hasta que termine por que se declaro el join()
            }
        };


        //Lambda expression

        Runnable viajeLambda = ()->{

            for(int i=0; i<10; i++){

                try {
                    System.out.println(i + " - " + Thread.currentThread().getName());
                    Thread.sleep((long)Math.random() * 100);
                }catch (InterruptedException e){}
            }
            System.out.println("Finally i am going to travel to: "+ Thread.currentThread().getName());
            System.out.println(main.getState());
        };


        Thread v1 = new Thread(viaje,"isla hawai");
        Thread v2 = new Thread(viaje,"las vegas");
        Thread v3 = new Thread(viaje,"new york");

        v1.start();
        v2.start();
        v3.start();

        v1.join();
        v2.join();
        v3.join();


        System.out.println("going on with the main" + main.getName());


        //The differences between join and sleep is that sleep only stop the current thread and join stop other threads to finish and the will continue with it others threads
        */









        //Synchronized






        /*
        * Lo que hace la sincronizacion es terminar que se ejecute un hijo despues de ejecuta otro y asi evitando que se ejecuten de manera concurrente el orden no sera
        * como esta declarados sino se ejecutaran desordenadamente los hilos
        * */



        //Modificador synchronized para sincronizacion de hilos.
        /*
        * El modificador synchronized en Java nos permite que un hilo entre de forma sincronizada en un método/función, ¿qué significa exactamente? Quiere decir que cuando un hilo o proceso ejecute ese método/función, ningún otro podrá acceder hasta que el primero acabe.
        *
        * La utilidad de que un método/función se utiliza para controlar el acceso de multiples hilos a un recurso compartido.
        *
        * */










        //METHODS wait() and notify()
        /*
        *Vamos a tener un productor que fabrica algo y un consumidor que lo consume
        *
        * la idea es tener un producto tanto consumidor como productor interactuan
        * al mismo tiempo sobre este producto es como un recurso compartido y aqui tenemos
        * que sincronizar un productor no puede fabricar mas de lo que el cliente consume
        * y vise versa un cliente no puede consumir mas de lo que un productor esta fabricando
        * tenemos que organizar sincronizar se fabrica 1 se consume 1 se fabrica otro se consume otro
        *
        * en este caso vamos hacer una panaderia
        *
        * 1 hilo productor
        * 1 hilo consumidor
        *
        * wait para esperar y notify para notificar
        *
        * no podemos utilizar wait() y notify() si no tenemos el metodo syncronizado
        * */







        /*USANDO TIMER AND TIMERTASK*/




        /*
        * Las tareas programadas se declaran utilizando las clases Timer y TimerTask
        *
        * es una clase abstracta podemos crear una instancia
        *
        * o podemos crear una clase aparte y heredar de esta
        *
        * o crear una clase anonima implementar el metodo run
        *
        * esta clase al final por detras implementa la interfaz Runnable por lo tanto
        * tenemos que sobrescribir el metodo run para hacer una tarea que va ser programable
        * en el tiempo ya sea que parta en 5s en 2horas o 1 dia etc o incluso que se repita cada
        * cierto tiempo son tareas programadas
        *
        * */





        //EXECUTOR FRAMEWORK SINGLE THREAD EXECUTOR

        /*
        *Es parte del JDK permite ejecutar tareas de forma
        * asincrona y concurrente pero desacoplando completamente
        * la creacion de los threads
        *
        * solo creamos nuestras tareas y las asignamos al executor y listo el se encarga
        * de gestionar todos los threads
        *
        * tambien tenemos callables
        *
        * */

















       //t.start();

        //We recommend to use Runnable interface because it can be use using java 8 and we can implement other clases using extends
        /*
        * Ciclo de vida de un Thread lifecycle and state of a Thread
        *
        * 1-Un Thread NEW es uno que se ha creado pero que aun no se ha iniciado con el metodo start():
        *
        * Runnable runnable = new CalculoRunnable();
        *
        * Thread t = new Thread(runnable);
        *
        * System.out.println(t.getState());
        *
        *
        *
        *
        * 2-Un Thread RUNNABLE es uno que se ha creado e iniciado con el start():
        *
        * Runnable runnable = new CalculoRunnable();
        *
        * Thread t = new Thread(runnable);
        *
        * t.start();
        *
        * System.out.println(t.getState());//RUNNABLE
        *
        *
        *3-Un Thread esta en estado BLOCKED cuando actualmente no es elegible para ejecutarse.
        *
        * Entra en este estado cuando esta esperando un bloqueo del monitor e intenta acceder a una seccion de codigo
        * que esta bloqueada por algun otro Thread en un metodo sincronizado.
        *
        * El Thread BLOCKED tiene que esperar hasta que el otro Thread libere o se salga de este metodo sincronizado
        *
        * public static void main(String[] args) throws InterruptedException{
        *
        *   Runnable runnable = ()-> recurso();
        *
        *   Thread t1 = new Thread(runnable);
        *   Thread t2 = new Thread(runnable);
        *   t1.start();
        *   t2.start();
        *
        *   Thread.sleep(1000);
        *
        *   System.out.println(t2.getState()); // BLOCKED
        *
        *
        *
        * }
        *
        * public static synchronized void recurso(){
        *   \\Realizando algun proceso compartido entre hilos
        *   while(true){}
        *
        * }
        *
        *
        * 4-Un Thread esta en estado WAITING cuando esta esperando que otro Thread
        * realice una accion en particular
        *
        * Un Thread puede entrar en este estado llamando a cualquiera de los dos metodos
        * wait() y join()
        *
        * public static void main(String [] args){
        *   Thread t1 = Thread.currentThread();
        *   Thread t2 = new Thread(()->{
        *       try{
        *           Thread.sleep(5000);
        *       }catch(InterruptedException e){}
        *       System.out.println(t1.getState());//WAITING
        *
        *
        * });
        *
        * t2.start();
        * t2.join();
        *
        * }
        *
        *5-Este es el estado final de un Thread muerto. Esta en el estado TERMINATED
        * cuando ha finalizado la ejecucion o se termino de forma anormal.
        * Tambien podemos usar el metodo isAlive() para determinar si el Thread esta vivo o no.
        *
        * public static void main(String[] args) throws InterruptedException{
        *   Thread t1 = new Thread(()->{
        *       //Doing some task quickly
        * });
        *
        * t1.start();
        * Thread.sleep(1000);
        *
        * System.out.println(t1.getState());
        * System.out.println(t1.isAlive());
        *
        *
        * }
        *
        *
        * 6-METHODS simpre se utilizan estos 3 metodos en methods synchronized
        *   -wait()
        *   -notify()
        *   -notifyAll()
        *
        * La clase Object tiene tres metodos que permiten que los Threads se sincronicen
        * y cominiquen sobre el estado bloqueado de un recurso.
        *
        * Wait()--> libera el bloqueo para que otros hilos tengan la oportunidad de acceder a un recurso compartido
        * (metodo sincronizado) y queda esperando indefinidamente hasta que otro hilo invoca notify() o notifyAll().
        *
        * notify() y notifyAll() --> se usa para despertar los Threads que estan esperando un acceso a un recurso compartido (monitor).
        *
        *
        * 7-METHOD sleep()
        *
        * Thread.sleep()--> envia el Thread actual al estado TIMED_WAITING durante algun tiempo
        *
        * Permanece dormido hasta que el tiempo expire o se llame al metodo interrupt();
        *
        * public static void main(String[]args) throws InterruptedException{
        *   Thread t1 - new Thread(()->{
        *   try{
        *       Thread.sleep(5000);
        *   }catch(InterruptedException e){}
        * });
        *
        *   t1.start();
        *
        *   Thread.sleep(1000);
        *
        *   System.out.println(t1.getState()); // TIME_WAITING
        *
        * }
        *
        * Diferencias entre Sleep y wait
        *
        *  1- wait() libera el recurso tanto como el objeto para que otro Thread puede hacer uso de el
        *  Mientras que el sleep no pero sigue consumiendo recurso solo hace una pausa de tiempo
        *
        *
        *
        *
        * */


    }
}
