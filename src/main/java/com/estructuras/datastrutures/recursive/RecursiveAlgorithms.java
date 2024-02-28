package com.estructuras.datastrutures.recursive;

public class RecursiveAlgorithms {


    public long fibonacci(long n){
        if((n==0) || (n==1)){
            return n;
        }else{

            return fibonacci(n-1)+fibonacci(n-2);
        }
    }

    public <T extends Number> long fibonacciCollections(T n){
        if((n.equals(0)) || (n.equals(1))){
            return n.longValue();
        }else{
            return fibonacciCollections(n.longValue()-1)+fibonacciCollections(n.longValue()-2);
        }
    }

    public long factorial(long number){

        if(number==0){
            return 1;
        }else{

            return number*factorial(number-1);

        }
    }





}
