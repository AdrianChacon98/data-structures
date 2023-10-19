package com.estructuras.datastrutures.data_structured;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class SortedAlgorithms {

    private Logger logger = LoggerFactory.getLogger(SortedAlgorithms.class);

    public SortedAlgorithms(){

    }

    public void printUniqueValues(){
        String txt="abcb";
        String uniqueValues="";
        String [] uniqueArray= txt.split("");
        for(int i=0; i<txt.length();i++)
        {
            char aux = txt.charAt(i);

            long numberOfCaracters = Arrays.asList(uniqueArray).stream().filter(letter->letter.equals(String.valueOf(aux))).count();

            if(numberOfCaracters==1){
                uniqueValues+=String.valueOf(aux)+"\n";
            }


        }

        System.out.println(uniqueValues);
    }

    public static long fibonaci(long n) {
        if ((n == 0) || (n == 1))
            return n;
        else
            return fibonaci(n - 1) + fibonaci(n - 2);
    }

    public long factorial(long number){

        if(number==0){
            return 1;
        }else{

            return number*factorial(number-1);

        }
    }

    public void invertWords(String word){

        String[] words = word.split(" ");
        String newWord="";
        for(int i=0; i<words.length;i++){
            char[] aux=  words[i].toCharArray();

            for(int j=aux.length;j>0;j--){
                newWord+=aux[j-1];
            }
            newWord+=" ";

        }
        System.out.println(newWord);
    }

    public void countNumbersRepeatedArray(){

        int[] numbers = {6,5,6,8,8,8,6,6,6};

        for(int i=0;i<numbers.length; i++){
            int value = numbers[0];
            int count=0;
            for(int j = 0; j<numbers.length;j++){
                if(value==numbers[j])
                    count+=1;
            }

            numbers=Arrays.stream(numbers).filter(item->!(item==value)).toArray();
            logger.info("The number="+value+" was counted "+ count);

        }
    }

    public void countNumbersRepeatedArray2(){
        int[] numbers = {6,5,6,8,8,8,6,6,6};
        while(numbers.length!=0){
            int value = numbers[0];
            long count=0;
            int[] numbersFiltered = Arrays.stream(numbers).filter(number->number==value).toArray();
            numbers=Arrays.stream(numbers).filter(number->number!=value).toArray();
            count=Arrays.stream(numbersFiltered).count();

            logger.info("The number "+value+" has "+count);

        }
    }

    public void bubbleSort(){
        int[] numbers = {6,5,6,8,8,8,6,6,6};


        for(int i=0; i<numbers.length;i++){
            for(int j=0; j<numbers.length-1;j++){
                if(numbers[j]>=numbers[j+1]){
                    int aux=0;
                    aux=numbers[j];
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=aux;
                }
            }
        }

        Arrays.stream(numbers).forEach(System.out::println);
    }

    public void quicksort(int array[], int low, int high){
        if(low<high){


            int position=partition(array,low,high);

            quicksort(array,low,position-1);

            quicksort(array,position+1,high);

        }

    }

    public int partition(int array[], int low, int high){
        int  pivot=array[high];

        int i = (low-1);

        for(int j=low; j<high; j++){
            if (array[j]<=pivot) {
                i++;

                int temp = array[i];
                array[i]=array[j];
                array[j]=temp;
            }
        }

        int temp = array[i+1];

        array[i+1]=array[high];
        array[high]=temp;

        return (i+1);
    }




}
