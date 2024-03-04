package com.estructuras.datastrutures.threads;

public class ImprimirFrasesSynchronized implements Runnable {

    private String frase1, frase2;

    public ImprimirFrasesSynchronized(String frase1, String frase2) {
        this.frase1 = frase1;
        this.frase2 = frase2;
    }

    @Override
    public void run() {
        EjemploSincronizacionThread.imprimirFrases(this.frase1,this.frase2);
    }



}
