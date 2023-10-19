package com.estructuras.datastrutures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import com.estructuras.datastrutures.infija_a_prefija.Prefija;


@SpringBootApplication
public class DataStruturesApplication implements CommandLineRunner{

	int AA=5; int AB=0; int BB=2;

	private Logger logger = LoggerFactory.getLogger(DataStruturesApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(DataStruturesApplication.class, args);

	}





	@Override
	public void run(String... args) throws Exception {

		Prefija prefija = new Prefija();
		String entrefijo="(3*X^2)+(1/2*Y)-(3*Z)^(1/2)";
		//prefija.convertirAPosfijo(entrefijo);
		/*
		int[] data = { 8, 7, 2, 1, 0, 9, 6 };
		DataStructured dataStructured = new DataStructured();
		dataStructured.quicksort(data,0,(data.length-1));
		*/
		//System.out.println(Arrays.toString(data));














		//factorial recursivo
		//System.out.println(factorial(5));

		/*for (int i=0;i<=10;i++){
			System.out.println(fib(i));
		}*/


		/*
		int AA = 1; int AB=2; int BB=1;

		StringBuilder result = new StringBuilder();



		while(AA>0 || BB>0){
			if(AA>BB){
				if(AA>=2 && !(result.toString().endsWith("AA"))){
					result.append("AA");
					AA-=2;
				}else if(AA==1 && !(result.toString().endsWith("AA"))){
					result.append("AA");
					AA--;
				}

				if(BB>0){
					result.append("BB");
					BB--;
				}
			}else{
				if(BB>=2){
					result.append("BB");
					BB-=2;
				}else if(BB == 1){
					result.append("BB");
					BB--;
				}
				if(AA>0 && !(result.toString().endsWith("AA"))){
					result.append("AA");
					AA--;
				}
			}
		}

		while (AB>0){

			if(result.toString().endsWith("AA") && result.toString().startsWith("BB") && result.toString().length()%2==0){
				result.insert(result.toString().length()/2,"AB");
				AB--;
			}else{
				result.append("AB");
				AB--;
			}

		}



		System.out.println(result.toString());
		*/





        /*
		StringBuilder txt = new StringBuilder();

		while(AA!=0 || AB !=0 || BB!=0){

			if(AB>2){
				txt.append("AB");
				AB-=2;
			}else if(AB>=1){
				txt.append("AB");
				AB--;
			}

			if(AA>2){
				txt.append("AA");
				AA-=2;
			}else if(AA>=1)
			{
				txt.append("AA");
				AA--;
			}
			if(BB==10){
				txt.append("BB");
				BB=0;
			}
			if(BB>2){
				txt.append("BB");
				BB-=2;
			}else if(BB>=1)
			{
				txt.append("BB");
				BB--;
			}


		}

		System.out.println(txt.toString());

        */

        int A[] = {2,2,2,2,2,2};
        int B[] = {7,4,2,5,1,2};

        int typeOfCandies=0;


		/*A=uniqueValues(A);

		typeOfCandies=A.length;

		B=uniqueValues(B);

		Integer[] boxedArray = Arrays.stream(A)
				.boxed()
				.toArray(Integer[]::new);

		for(int i=0;i<B.length;i++){
			int aux=B[i];

			long repeat = Arrays.asList(boxedArray).stream().filter(candy->candy==aux).count();

			if(repeat==0 ){
				typeOfCandies++;
			}


		}*/

		//System.out.println(typeOfCandies);
		/*
		int []array=join(A,B);

		array=uniqueValues(array);

		System.out.println(array.length);
		*/





	}
	public static int[] join(int[] a, int[] b)
	{
		return IntStream.concat(Arrays.stream(a), Arrays.stream(b))
				.toArray();
	}
	public int[] uniqueValues(int[] arr){
		Set<Integer> set = new HashSet<>();

		for (int i : arr) {
			set.add(i);
		}

		int[] result = new int[set.size()];
		int k = 0;
		for (int i: set) {
			result[k++] = i;
		}

		return result;
	}

	public StringBuilder caseAB(StringBuilder txt){
		if(AB>2){
			txt.append("AB");
			AB-=2;
		}else if(AB>=1){
			txt.append("AB");
			AB--;
		}

		return txt;
	}

	public StringBuilder caseAA(StringBuilder txt){
		if(AA>2){
			txt.append("AA");
			AA-=2;
		}else if(AA>=1)
		{
			txt.append("AA");
			AA--;
		}

		return txt;
	}

	public StringBuilder caseBB(StringBuilder txt){
		if(BB>2){
			txt.append("BB");
			BB-=2;
		}else if(BB>=1)
		{
			txt.append("BB");
			BB--;
		}

		return txt;
	}

















}
