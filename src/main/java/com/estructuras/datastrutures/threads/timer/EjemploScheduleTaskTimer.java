package com.estructuras.datastrutures.threads.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class EjemploScheduleTaskTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();

        //executing just once
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Tarea realizada en: "+ new Date() + "Nombre del Thread" + Thread.currentThread().getName() );
                System.out.println("Finaliza el tiempo");
                //cancel the timer if you are not going to do anymore
                timer.cancel(); //Even if we have a schedule task for example every day if something went wrong we can call this function to finish the task and not break the app

            }
        }, 5000);

        System.out.println("Agendamos una tarea para que se realize en 5 segundos");

        //executing task every specific time




    }
}
