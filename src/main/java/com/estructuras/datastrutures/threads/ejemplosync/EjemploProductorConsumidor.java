package com.estructuras.datastrutures.threads.ejemplosync;

public class EjemploProductorConsumidor {

    public static void main(String[] args) {
        Panaderia p = new Panaderia();

        new Thread(new Panadero(p)).start();
        new Thread(new Consumidor(p)).start();



    }
}
