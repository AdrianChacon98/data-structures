package com.estructuras.datastrutures;

import com.estructuras.datastrutures.TraversalTree.Node;
import com.estructuras.datastrutures.TraversalTree.TraversalTree;
import com.estructuras.datastrutures.leetcode.LeetCode;
import com.estructuras.datastrutures.tree.Tree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

		//Prefija prefija = new Prefija();
		//String entrefijo="(3*X^2)+(1/2*Y)-(3*Z)^(1/2)";
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

        //int A[] = {2,2,2,2,2,2};
        //int B[] = {7,4,2,5,1,2};

        //int typeOfCandies=0;


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


		/*
		int number = 11;


		if(number%2==1){
			System.out.println("it a prime number");
		}else{
			System.out.println("it not a prime number");
		}
		*/

		/*

		int [] AB=join(A,B);

		int [] uniqueArray = uniqueValues(AB);

		for(int i : uniqueArray){
			//System.out.println(i);
		}



		int invest=1000;

		int interest=10;

		double years = 0.5;

		//System.out.println(compoundingInterest(invest,interest,years));









		String str1="ABCDPQRS";
		String str2="DCABQRPS";

		char [] str1Array=str1.toCharArray();
		char [] str2Array=str2.toCharArray();

		str1Array=bubbleSort(str1Array);

		str1="";

		for(char value : str1Array){
			str1+=value;
		}

		str2Array=bubbleSort(str2Array);

		str2="";
		for(char value : str2Array){
			str2+=value;
		}

		System.out.println(str1);
		System.out.println(str2);

		if(str1.equalsIgnoreCase(str2))
			System.out.println("Str2 is an Anagrams");
		else
			System.out.println("Str2 is not an Anagrams");


		*/






		//

		//int result = factorial(5);



		//System.out.println(result);

		//int resultFibonaci = fibbonaci(10);

		//System.out.println(resultFibonaci);
		/*
		String [] anagrams = {"eat","tea","tan","ate","nat","bat"};

		groupAnagrams(anagrams).stream().forEach(System.out::println);

		//Check a palindrome
		String word="adrian".toLowerCase();
		String newWord=reversArray(word.toCharArray());

		char [] wordArray = word.toCharArray();
		char [] newWordArray = newWord.toCharArray();

		boolean isPalindrome=false;

		for(int i=0; i<wordArray.length;i++){
			char aux = wordArray[i];

			char aux2 = newWordArray[(newWordArray.length-(i+1))];

			if(aux==aux2)
				isPalindrome=true;
			else{
				isPalindrome=false;
				break;
			}

		}

		if(isPalindrome)
			System.out.println("it is a palindrome");
		else
			System.out.println("it is not a palindrome");

	*/


	/*

			1
        /          \
     2           	3
       |         /        \
     4          5          6


	1. Design a table (plsql)
   	Data structure (Java)

	2. Recursive function
	Stn1 - Stn2 - Stn4
	Stn1 - Stn3 - Stn5
	Stn1 - Stn3 - Stn6


	  private void preOrderRec(Node root){
        if(root!=null){
            logger.info("Value:"+root.key);
            preOrderRec(root.left);
            preOrderRec(root.right);

        }
    }

	 */
		/*

		TraversalTree tree = new TraversalTree();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left=new Node(4);
		tree.root.right.left = new Node(5);
		tree.root.right.right= new Node(6);

		System.out.print(tree.root.key+" ");
		System.out.print(tree.root.left.key+" ");
		System.out.print(tree.root.left.left.key);

		System.out.println("");

		System.out.print(tree.root.key+" ");
		System.out.print(tree.root.right.key+" ");
		System.out.print(tree.root.right.left.key+" ");

		System.out.println("");

		System.out.print(tree.root.key+" ");
		System.out.print(tree.root.right.key+" ");
		System.out.print(tree.root.right.right.key+" ");




		for(int i = 0; i<3;i++){
			if(i==0){
				System.out.println(tree.root.key);
				tree.preOrder(tree.root.left);
			}else if(i==2){
				System.out.println(tree.root.key);
				tree.preOrder(tree.root.right);
			}else if(i==3){
				System.out.println(tree.root.key);
				tree.preOrder(tree.root.right.right);
			}

		}



	*/
		/*
		String binary_string="0101010110101";


		//char binaryArray []=binary_string.toCharArray();

		int sum=0;

		for(int i=0;i<binary_string.length();i++){

			char aux=binary_string.charAt((binary_string.length()-(i+1)));

			int binaryNumber= Character.getNumericValue(aux);

			//System.out.println(binaryNumber);

			int result = (int) Math.pow(2,i);

			System.out.println(result);

			int finalResult = result * binaryNumber;

			sum+=finalResult;

			System.out.println(finalResult);

		}

		System.out.println(sum);

		*/




		//Trapping water rain

		//int [] height={4,2,0,3,2,5};
/*
		int [] height={1,0,5,0,3};
		int columnSize=height.length;

		int [] arrayMayor = Arrays.stream(Arrays.stream(height).toArray()).sorted().toArray();

		int rowSize=arrayMayor[height.length-1];

		String [][] mapping = new String[rowSize][columnSize];

		for(int column=0;column<height.length;column++){

			int number = height[column];

			for(int row=rowSize-1;row>=0;row--){

				if(number!=0){
					mapping[row][column]="|1";
					number-=1;
				}else
					mapping[row][column]="|-";

			}
		}




		printMap(mapping,rowSize,height);



		for(int column=0;column<height.length;column++){
			for(int row=0;row<rowSize;row++){

				if(mapping[row][column]=="|1"){

					boolean is1Close=false;

					for(int i=(column+1);i<height.length;i++){

						if(mapping[row][i]=="|1" && !(is1Close)){
							is1Close=true;
							i=(column+1);
						}

						if(mapping[row][i]=="|-" && is1Close){
							mapping[row][i]="|0";
						}else if(mapping[row][i]=="|1" && is1Close){
							break;
						}



					}

				}
			}

		}


		System.out.println("--------------AFTER--------------");
		printMap(mapping,rowSize,height);


		int countWaterTrapped=0;


		for(int column=0;column<height.length;column++){
			for(int row=0;row<rowSize;row++){

				if(mapping[row][column]=="|0")
					countWaterTrapped+=1;
			}
		}

		System.out.println("The total water trapped is="+countWaterTrapped);


*/
		/*
		int array[] = {2,1,4,3,8,5,6,7,9,10};

		int pivotLeft=0;
		int pivotRight=array.length-1;

		quicksort(array,pivotLeft,pivotRight);
		*/


		String phrase ="este es mi nombre";

		phrase = Arrays.asList(phrase.split(" ")).stream().map(word -> new StringBuilder(word).reverse()).collect(Collectors.joining(" "));


		//System.out.println(phrase);

		LeetCode leetCode = new LeetCode();

		leetCode.generatePermutations("1234","4213");


		




	}
























	public int[] quicksort(int array[],int pivotLeft, int pivotRight){

		int position=0;
		while(!(pivotLeft==pivotRight)) {

			 position = partition(array,pivotLeft,pivotRight);



			quicksort(array,pivotLeft,position-1);
			quicksort(array,position+1,pivotRight);
		}

		return array;

	}

	public int partition(int array[],int pivotLeft, int pivotRight){
		boolean isChanged=false;
		boolean isSwap=false;

		while(!(pivotLeft==pivotRight)){

			if(!isChanged) {

				if (array[pivotLeft] > array[pivotRight]) {
					int aux = array[pivotLeft];
					array[pivotLeft] = array[pivotRight];
					array[pivotRight] = aux;
					pivotLeft++;
					isChanged=true;
					isSwap=true;
				} else {
					pivotRight--;
				}

			}else{
				if (array[pivotLeft] > array[pivotRight]) {
					int aux = array[pivotLeft];
					array[pivotLeft] = array[pivotRight];
					array[pivotRight] = aux;
					pivotRight--;
					isChanged=false;
					isSwap=false;
				} else {
					pivotLeft++;
				}

			}

		}
		if(!isSwap){
			//return position left
			return (pivotLeft+=1);
		}

		return pivotLeft;

	}






































	public String reversArray(char [] array){

		String aux="";
		for(int i=array.length-1;i>=0;i--){
			aux+=array[i];
		}
		return aux;
	}




	//group of anagrams

	public List<List<String>> groupAnagrams(String [] anagrams){

		List<List<String>> groupAnagramsList = new ArrayList<>();

		for(int i=0;i<anagrams.length;){
			List<String> auxList = new ArrayList<>();
			String aux=anagrams[i];
			auxList.add(aux);
			for(int j=(i+1);j<anagrams.length;j++){

				if(isAnagram(aux,anagrams[j]))
					auxList.add(anagrams[j]);
			}
			groupAnagramsList.add(auxList);
			//Stream<String> removeElement = Arrays.stream(anagrams).filter(item->(item!=aux));
			//anagrams=removeElement.toArray(String[]::new);
			anagrams=removeAnagrams(auxList,anagrams);
		}

		return groupAnagramsList;

	}


	//remove duplicate anagrams

	public String [] removeAnagrams(List<String> anagramsList,String [] anagrams)
	{

		for(int i=0;i<anagramsList.size();i++){
			String aux=anagramsList.get(i);
			Stream<String> removeElement = Arrays.stream(anagrams).filter(item->item!=aux);
			anagrams=removeElement.toArray(String[]::new);
		}

		return  anagrams;

	}

	public boolean isAnagram(String str1, String str2){

		str1=bubbleSort2(str1.toCharArray());
		str2=bubbleSort2(str2.toCharArray());

		return str1.equalsIgnoreCase(str2);
	}




	public int factorial(int number){

		if(number==0)
			return 1;
		else
			return number * factorial(number-1);

	}

	public int fibbonaci(int number){
		if((number == 0) || (number==1))
			return number;
		else
			return fibbonaci((number-1))+fibbonaci((number-2));
	}
















	public char [] bubbleSort(char [] strArray){



		for(int i=0; i<strArray.length;i++){
			for(int j=0; j<strArray.length-1;j++){
				if(strArray[j]>=strArray[j+1]){
					char aux=' ';
					aux=strArray[j];
					strArray[j]=strArray[j+1];
					strArray[j+1]=aux;
				}
			}
		}

		return strArray;

	}

	public String bubbleSort2(char [] strArray){

		for(int i=0; i<strArray.length;i++){
			for(int j=0; j<strArray.length-1;j++){
				if(strArray[j]>=strArray[j+1]){
					char aux=' ';
					aux=strArray[j];
					strArray[j]=strArray[j+1];
					strArray[j+1]=aux;
				}
			}
		}

		return String.valueOf(strArray);

	}



	//CI method recursive

	public int compoundingInterest(int invest,int interest, double years)
	{
		if(years==0)
			return invest;
		else {


			invest += invest * interest / 100;

			return compoundingInterest(invest,interest,(years-1));
		}

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
