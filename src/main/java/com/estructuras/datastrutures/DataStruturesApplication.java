package com.estructuras.datastrutures;

import com.estructuras.datastrutures.tree.Dog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;


@SpringBootApplication
public class DataStruturesApplication implements CommandLineRunner{


	private Logger logger = LoggerFactory.getLogger(DataStruturesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DataStruturesApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {


		int[] numbers = {6,5,6,8,8,8,6,6,6};


		/*for(int i=0; i<numbers.length;i++){
			for(int j=0; j<numbers.length-1;j++){
				if(numbers[j]>=numbers[j+1]){
					int aux=0;
					aux=numbers[j];
					numbers[j]=numbers[j+1];
					numbers[j+1]=aux;
				}
			}
		}

		Arrays.stream(numbers).forEach(System.out::println);*/

		//count how many times the number is repeated
		/*
		for(int i=0;i<numbers.length; i++){
			int value = numbers[i];
			int count=0;
			for(int j = 0; j<numbers.length;j++){
				if(value==numbers[j])
					count+=1;
			}

			//numbers=Arrays.stream(numbers).filter(item->item!=value).toArray();
			logger.info("The number="+value+" was counted "+ count);

		}
			*/

		while(numbers.length!=0){
			int value = numbers[0];
			long count=0;
			int[] numbersFiltered = Arrays.stream(numbers).filter(number->number==value).toArray();
			numbers=Arrays.stream(numbers).filter(number->number!=value).toArray();
			count=Arrays.stream(numbersFiltered).count();

			logger.info("The number "+value+" has "+count);

		}

		//invert the words
		
		String word = "rogelio adrian chacon orozco";
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


		//factorial recursivo
		System.out.println(factorial(5));

		for (int i=0;i<=10;i++){
			System.out.println(fib(i));
		}
	}

	public long factorial(long number){

		if(number==0){
			return 1;
		}else{

			return number*factorial(number-1);

		}
	}

	public static long fib(long n) {
		if ((n == 0) || (n == 1))
			return n;
		else
			return fib(n - 1) + fib(n - 2);
	}


}
