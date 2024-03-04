package com.estructuras.datastrutures.threads.timer;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploScheduleTaskTimerPeriod {


    public static void main(String[] args) {
        Timer timer = new Timer();
        AtomicInteger counter = new AtomicInteger(3);
        //executing just once

        //Adding sound of alert

        Toolkit toolkit = Toolkit.getDefaultToolkit();



        //
        timer.schedule(new TimerTask() {
            //private  int counter=3;

            @Override
            public void run() {
                //int i = counter.getAndDecrement();
                if(counter.getAndDecrement()>0) {
                    //create a beep song
                    toolkit.beep();
                    System.out.println("Tarea periodica en: " + new Date() + "Nombre del Thread" + Thread.currentThread().getName());
                    //counter--;
                }else {
                    System.out.println("Finaliza el tiempo");
                    //cancel the timer if you are not going to do anymore
                    timer.cancel(); //Even if we have a schedule task for example every day if something went wrong we can call this function to finish the task and not break the app
                }
            }
        }, 0, 10000);

        System.out.println("Agendamos una tarea para que se realize en 5 segundos");

        //executing task every specific time




    }
}
