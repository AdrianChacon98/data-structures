package com.estructuras.datastrutures.functionalProgramming;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Functional {


    public double calculate(double a, double b, Maths lambda){
        return lambda.operation(a,b);
    }

    public boolean isAdult(int age,Maths lambda){
        return lambda.isAdult(age);
    }



    public Functional(){
        /*
        Maths sum = (a,b)->a+b;
        Maths res = (a,b)->a-b;
        System.out.println(this.calculate(10.0,20.20,sum));

        Maths isOld =(age)->{
            if(age>=18)
                return false;
        };*/
    }


    public void createStream()
    {
        Stream<String> names = Stream.of("Adrian","Tarj","Beto","Jonson");

        names.forEach(System.out::println);

        String [] args={"adrian","Rogelio","Chacon","Orozco"};

        Stream<String> names2 = Arrays.stream(args);

        Stream<String> names3 = Stream.<String>builder().add("Adrian").add("pedro").build();

    }

    public void operators(){
        List<String> names = new ArrayList<>();
        names.add("adrian");
        names.add("ari");
        names.add("ana");
        names.add("alejandro");
        names.add("rogelio");
        names.add("julio");
        names.add("pedro");

        List<String>namesUppercase=names.stream()
                .map(name->{
                    return name.toUpperCase();
                })
                .peek(name->System.out.println(name))
                .collect(Collectors.toList());

        namesUppercase.stream()
                .filter(name->name.startsWith("A"));



        List<Integer>numbers1=Arrays.asList(1,2,3);
        List<Integer>numbers2=Arrays.asList(4,5,6);
        List<Integer>numbers3=Arrays.asList(7,8,9);

        List<Integer>numbers=Stream.of(numbers1,numbers2,numbers2)
                .flatMap(list->list.stream())
                .collect(Collectors.toList());

        numbers.stream().forEach(System.out::println);


        List<Integer> duplicated = Arrays.asList(1,2,3,4,4,5,2,3,3,5,45,1,2,1,2,1,2);

        duplicated.stream().sorted().forEach(System.out::println);

        duplicated.stream().sorted(Comparator.reverseOrder()).limit(5).forEach(System.out::println);

        duplicated.forEach(System.out::println);

        duplicated=duplicated.stream().distinct().collect(Collectors.toList());

        duplicated.forEach(System.out::println);

        // ended operators
        /*
        * AllMatch()
        * anyMatch()
        * noneMatch()
        * collect()
        * count()
        * forEach()
        * min()
        * max()
        * reduce()
        * findFirst()
        * findAny()
        * toArray()
        * */

        Map<String,Integer> age = new HashMap<>();

        age.put("Adrian",24);
        age.put("rogelio",26);


    }

    public void FunctionalProgramming(){

        Consumer<String> consumer = name ->{
            System.out.println(name);
        };

        consumer.accept("Adrian");

        BiConsumer<String,String> biConsumer = (name1,name2)->{
            System.out.println(name1+" "+name2);
        };

        biConsumer.accept("Rogelio","Adrian");

        //methods reference
        Consumer<String> consumerReference = System.out::println;

        List<String> names = Arrays.asList("adrian","rogelio","chacon","Orozco");

        names.forEach(consumerReference);

        // Supplier return <T> using method called get()

        Supplier<String> proovider = ()-> "hello world";

        System.out.println(proovider.get());

        //Function<ReceiveParam T,ReturnParam T> use it using the method called apply

        Function<String,String> convertToUppercase = param->{
            return param.toUpperCase();
        };

        System.out.println(convertToUppercase.apply("adrian"));

        //Using methods reference

        Function<String,String> lastname = String::toUpperCase;

        System.out.println(lastname.apply("chacon"));


        //BiFunction we receive 2 arguments
        BiFunction<String,String,String> biFunction = (a,b)->{
            return a.toUpperCase().concat(b.toUpperCase());
        };

        System.out.println(biFunction.apply("adrian","rogelio"));


        //Predicate  return boolean

        Predicate<Integer> isAdult = age ->{
            if(age>=18)
                return true;
            return false;
        };

        System.out.println(isAdult.test(18));

        //BiPredicate receive 2 arguments and return a boolean

        BiPredicate<String,String> compare = (a,b)->{
            if(a.equalsIgnoreCase(b))
                return true;
            return false;
        };

        System.out.println(compare.test("Adrian","Rogelio"));

        BiPredicate<String,String> compareReference = String::equalsIgnoreCase;

        System.out.println(compareReference.test("Adrian","Rogelio"));









    }



}

