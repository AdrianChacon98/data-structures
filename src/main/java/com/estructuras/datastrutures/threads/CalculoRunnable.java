package com.estructuras.datastrutures.threads;

public class CalculoRunnable implements Runnable{

    private String name;

    public CalculoRunnable (String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public void run() {
        //do something

        for(int i=0; i<10; i++){

            try {
                System.out.println(i + " - " + this.name);
                Thread.sleep((long)Math.random() * 100);
            }catch (InterruptedException e){}
        }
        System.out.println("Finally i am going to travel to: "+ this.name);

    }
}
