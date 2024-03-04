package com.estructuras.datastrutures.threads;

public class EjemploSincronizacionThread {


    public static void main(String[] args) throws InterruptedException {
        new Thread(new ImprimirFrasesSynchronized("hola ", "Que tal!")).start();
        new Thread(new ImprimirFrasesSynchronized("Quien eres ", "Tu?")).start();

        Thread.sleep(100);

        Thread h3 = new Thread(new ImprimirFrasesSynchronized("Muchas ", "gracias amigo!"));

        h3.start();

        Thread.sleep(100);

        System.out.println(h3.getState());


    }


    //varia Threads van a acceder a este metodo sincronizadamente
    //The order doesnt matter it is going to print inorder but sinchronized
    public synchronized static void imprimirFrases(String frase1, String frase2){
        System.out.print(frase1);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(frase2);
    }






}
