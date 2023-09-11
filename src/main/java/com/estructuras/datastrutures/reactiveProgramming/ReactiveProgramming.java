package com.estructuras.datastrutures.reactiveProgramming;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

public class ReactiveProgramming {

    private Logger logger = Logger.getLogger(ReactiveProgramming.class.getName());


    public void run(){

        //mono just 1 Mono<T>
        //flux more than 1 Flux<T>
        Flux<String> names = Flux.just("Adrian","Rogelio","Pedro","Uriel");

        names.doOnNext(element->System.out.println(element));


        names.subscribe(
                log->System.out.println(log),
                error->System.out.println(error),
                new Runnable(){
                    @Override
                    public void run(){
                        System.out.println("It was finished successfully");
                    }
                });



        //Operator map

        Flux<String> companyNames = Flux.just("google","Facebook","Amazon","twiter");

        companyNames
                .doOnNext(company->System.out.println(company))
                .map(company->company.toUpperCase())
                .doOnNext(company->System.out.println(company));

        companyNames.subscribe(element->System.out.println(element));

        //filter

        //Observables are immutable

        Flux<String> dogs = Flux.just("firulais","charl","jejuos");

        //thats why you need to save these changes in a new flux variable thats the only way that the observables
        //are mutable
        Flux<String> name=  dogs.filter(dog->dog.startsWith("f"));


        name.subscribe(e->System.out.println(e));

        //Creating a Flux from an arraylist

        List<String> products = Arrays.asList("soap","cheese","tomato","potato");

        Flux.fromIterable(products)
                .map(product->product.toUpperCase())
                .flatMap(product->Mono.just(products))
                .subscribe(element->System.out.println(element));

        //flatMap receives an inputs and return a lot of outputs

        List<List<String>> words = new ArrayList<>();

        words.add(Arrays.asList("hola","casa","dolar","peso"));
        words.add(Arrays.asList("perro","pajaro","vaca","tienda"));

        Flux.fromIterable(words)
                .flatMap(word->{
                    return Flux.fromIterable(word)
                            .flatMap(word2->{
                                return Mono.just(word2);
                            });
                })
                .subscribe(element->System.out.println(element));

        //Convert a Flux observable to a Mono.

        Flux.fromIterable(products)
                .collectList()
                .subscribe(lista->{
                    lista.forEach(System.out::println);
                });

        //Joining 2 observables

        dogs.zipWith(companyNames)
                .subscribe(list->{
                    list.forEach(System.out::println);
                });





    }


}
