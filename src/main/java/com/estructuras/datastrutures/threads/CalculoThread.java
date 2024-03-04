package com.estructuras.datastrutures.threads;

/*
* Concurrency --> is when two or more tasks can start, run, and complete in overlapping time periods. It doesn't necessarily mean they'll ever both be running at the same instant.
* For example, multitasking on a single-core machine.
*
* for instance if you have 3 tasks to do the cpu will use single core you execute these 3 tasks at the same time
*
*Parallelism --> is when tasks literally run at the same time, e.g., on a multicore processor.
*
* for instance if you have 3 tasks to do the cpu will use 3 core one for each task at the same time
*
*
*
*
* */



public class CalculoThread extends Thread{


    public CalculoThread(String name){
        super(name);
    }

    @Override
    public void run() {
        //do something

        System.out.println("It starts the Thread"+ getName());

        for(int i=0;i<10;i++){
            System.out.println(this.getName());
        }

        System.out.println("it finish the Thread");

    }

}
