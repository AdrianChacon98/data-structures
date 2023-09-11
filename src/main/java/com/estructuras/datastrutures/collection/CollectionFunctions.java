package com.estructuras.datastrutures.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionFunctions {


    /*
    * E->Element
    * K->Key
    * N->Number
    * T->Type
    * V->Value
    * S,U,V->represent other types
    */


    //generic Methods

    public <T> List<T> fromArrayToList(T[] array){
        return Arrays.asList(array);
    }


    public <T,G> List<T> fromArrayToList(T[] array,G[] x){
        for(G element: x){
            System.out.println(element);
        }
        return Arrays.asList(array);
    }

    //Bounded Generics
    //we can limit our generic methods just only for receive specific types op data
    //we use <T extend Number>

    public <T extends Number> List<T> fromArrayToList(T[] numbers){
        return Arrays.asList(numbers);
    }

    public <T extends Person> List<T> fromArrayToList(T[]people){
        return Arrays.asList(people);
    }

    //if we want to use more than one type we need add & and the other type we are going to accept in our method

    public <T extends Number & Comparable<T>> List<T> fromArrayToList(T[] people, T number){

        if (number.compareTo(number)>5){
            System.out.println("Error");
        }

        return Arrays.asList(people);
    }


    //Wildcards
    //we can only use them using list

    //List<? extends Person> & List<? super Person>


    class Person {

        private String name;
        private int age;

        public Person(){

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }




}
