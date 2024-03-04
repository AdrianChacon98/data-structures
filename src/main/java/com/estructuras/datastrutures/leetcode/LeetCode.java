package com.estructuras.datastrutures.leetcode;

import com.estructuras.datastrutures.data_structured.SortedAlgorithms;
import com.estructuras.datastrutures.recursive.RecursiveAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode {

    //Remember that |1 is the wall and |0 is the water and finally |- is empty what we want to count is how many |0 is trapped

    private int [] height;
    private int columnSize;
    private int rowSize;

    private String [][] mapping;

    public LeetCode(){
    }
    public LeetCode(int [] height){
        this.height=height;
        this.columnSize=height.length;
        this.assignTheBiggestNumberOfTheArray();
        this.mapping = new String[rowSize][columnSize];
    }


    //get the biggest number of the array
    private void assignTheBiggestNumberOfTheArray(){

        int [] arraySorted = Arrays.stream(Arrays.stream(height).toArray()).sorted().toArray();

        this.rowSize=arraySorted[arraySorted.length-1];

    }

    public void createTheTrappingWaterRainMap(){
        for(int column=0;column<this.height.length;column++){

            int number = this.height[column];

            for(int row=this.rowSize-1;row>=0;row--){

                if(number!=0){
                    this.mapping[row][column]="|1";
                    number-=1;
                }else
                    this.mapping[row][column]="|-";

            }
        }
    }


    public void mappingTheWaterTrappedByRain(){

        for(int column=0;column<this.height.length;column++){
            for(int row=0;row<this.rowSize;row++){

                if(this.mapping[row][column]=="|1"){

                    boolean is1Close=false;

                    for(int i=(column+1);i<this.height.length;i++){

                        if(this.mapping[row][i]=="|1" && !(is1Close)){
                            is1Close=true;
                            i=(column+1);
                        }

                        if(this.mapping[row][i]=="|-" && is1Close){
                            this.mapping[row][i]="|0";
                        }else if(this.mapping[row][i]=="|1" && is1Close){
                            break;
                        }



                    }

                }
            }

        }

    }

    public int getWaterTrapped(){
        int countWaterTrapped=0;


        for(int column=0;column<height.length;column++){
            for(int row=0;row<rowSize;row++){

                if(mapping[row][column]=="|0")
                    countWaterTrapped+=1;
            }
        }

        return countWaterTrapped;

    }

    public void printMap(String [][] mapping,int rowSize,int [] height){
        for(int row=0;row<rowSize;row++){
            for(int column=0; column<height.length;column++){
                System.out.print(mapping[row][column]);
            }
            System.out.println("");
        }
    }


    //Generate a string consisting of characters ‘a’ and ‘b’ that satisfy the given conditions

    /*
    * Given two integers A and B, the task is to generate and print a string str such that:
    *
    *str must only contain the characters ‘a’ and ‘b’.
    *str has length A + B and the occurrence of the character ‘a’ is equal to A and the occurrence of character ‘b’ is equal to B
    *The sub-strings “aaa” or “bbb” must not occur in str.
    *Note: For the given values of A and B, a valid string can always be generated.
    *
    * */

    private String str="";
    private int A=6;
    private int B=2;

    public void generateStringCombination(){

        while(0 < A || 0 < B){

            //More 'b', append "bba"

            if(A<B){
                if(0<B--)
                    str+= 'b';
                if(0<B--)
                    str+='b';
                if(0<A--)
                    str+='a';
            }
            //More 'a', append "aab"
            else if (B<A) {

                if(0<A--)
                    str+='a';
                if(0<A--)
                    str+='a';
                if(0<B--)
                    str+='b';
            }

            //Equal number of 'a' and 'b'
            //append "ab"
            else{

                if(0<A--)
                    str+='a';
                if(0<B--)
                    str+='b';

            }


        }

        System.out.println(str);

    }

    //Binary Sum

    private String stringBinary="0101010110101";

    private void binarySum(){
        char binaryArray [] = stringBinary.toCharArray();
        int sum=0;

        for(int i=0; i<stringBinary.length();i++){
            char aux=stringBinary.charAt(stringBinary.length()-(i+1));

            int binaryNumber = Character.getNumericValue(aux);

            int result = (int) Math.pow(2,i);

            result = result * binaryNumber;

            sum+=result;

        }

        System.out.println("The binary sum is="+sum);

    }

    /*
    public ArrayList<ArrayList<String>> groupAnagrams() {

        String[] arrayWords = {"eat", "tea", "tan", "ate", "nat", "bat"};

        String[] sortedArrayWords = new String[arrayWords.length];

        ArrayList<ArrayList<String>> groupAnagrams = new ArrayList<>();

        for (int i = 0; i < arrayWords.length; i++) {
            sortedArrayWords[i] = bubbleSort(arrayWords[i]);
        }

        for (int i = 0; i < arrayWords.length; i++) {

            ArrayList<String> group = new ArrayList<>();

            for (int j = 0; j < arrayWords.length; j++) {

                if (sortedArrayWords[i] == sortedArrayWords[j]) {
                    group.add(arrayWords[j]);
                }

            }

            //delete all
            //Arrays.asList(arrayWords).stream().filter();

        }

        return null;
    }*/

    public List<List<String>> groupAnagrams(){
        ArrayList<String> str = new ArrayList<>();

        str.add("eat");
        str.add("tea");
        str.add("tan");
        str.add("ate");
        str.add("nat");
        str.add("bat");


        ArrayList<String> anagrams = new ArrayList<>();
        ArrayList<List<String>> groupAnagrams = new ArrayList<>();
        for(int i=0;i<str.size();){
            String aux1 = bubbleSort(str.get(i));
            anagrams.add(str.get(i));
            for(int j=i+1;j<str.size();j++)
            {
                String aux2 = bubbleSort(str.get(j));

                if(aux1.equalsIgnoreCase(aux2))
                    anagrams.add(str.get(j));


            }
            groupAnagrams.add(anagrams);

            for(String aux : anagrams){
                str= (ArrayList<String>) str.stream().filter(item->item!=aux).collect(Collectors.toList());
            }



            anagrams = new ArrayList<>();





        }

        for(List<String> aux : groupAnagrams ){
            System.out.println(aux);
        }

        return groupAnagrams;
    }


    public String bubbleSort(String word)
    {
        char[] wordArray = word.toCharArray();

        for(int i=0; i<wordArray.length; i++){
            for(int j=0; j<wordArray.length-1;j++){
                if(wordArray[j]>wordArray[j+1]){
                    char aux=' ';
                    aux=wordArray[j];
                    wordArray[j]=wordArray[j+1];
                    wordArray[j+1]=aux;
                }

            }
        }


        return String.valueOf(wordArray);
    }




    /*
    * Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
    * cannot use additional data structures?
    * */


    /*
    * Check Permutation: Given two strings, write a method to decide if one is a permutation of the
    * other.
    *
    * */

    private String permutationWord="ABCD";
    private String wordTest="CBDA";
    private List<String> permutations;

    public void generatePermutations(){
        //get the factorial n! = 3! = 1 x 2 x 3 = 6
        RecursiveAlgorithms recursiveAlgorithms = new RecursiveAlgorithms();
        long numberOfCombinations=recursiveAlgorithms.factorial(permutationWord.length());
        int positionCompareWord=(int)numberOfCombinations-1;
        //Variables
        int swapIndex=0;
        int moveIndex=permutationWord.length();
        char [] charArray = permutationWord.toCharArray();
        String [] arrayString = new String[(int) numberOfCombinations]; //for add all the permutations
        int sizeCharArray=charArray.length;

        boolean isFirstAdded=false;

        while(sizeCharArray!=0){

            //add the first combination
            if(!isFirstAdded) {
                numberOfCombinations--;
                arrayString[((int) numberOfCombinations)] = charArray.toString();
                isFirstAdded=true;
            }else{

                //hacer el cambio y comparar despues agregar
                moveIndex--;
                if((moveIndex-1)!=0) {
                    //charArray = swap(charArray, moveIndex);
                    if(String.valueOf(charArray).equals(arrayString[positionCompareWord])){

                    }else{

                    }
                }
            }

        }

    }
    /*public char [] swap(char [] array,int position){
        if((position-1)!=0){
            char aux = array[position];
            array[position]=array[position-1];
            array[position-1]=aux;
        }
        return array;
    }*/


    /*
    public void generateCombinations(){
        RecursiveAlgorithms recursiveAlgorithms = new RecursiveAlgorithms();

        String word1="1234";
        String word2="4213";
        long posibleCombinations=recursiveAlgorithms.factorial(word1.length());

        String permutations [] = new String[(int)posibleCombinations];

        char [] arrayWord1=word1.toCharArray();

        int word1LengthCombinations = word1.length();

        int indexWordCompare=(int) posibleCombinations-1;

        boolean isFirstCombinationAdded=false;

        int indexSwapPosition=word1.length()-1;
        int indexSwapValue=1;

        while(word1LengthCombinations!=0){

            if(!isFirstCombinationAdded){
                posibleCombinations--;

                permutations[(int)posibleCombinations]=String.valueOf(arrayWord1);
                isFirstCombinationAdded=true;

            }else{



                //make swap
                arrayWord1 = swap(arrayWord1,indexSwapPosition,false);
                //compare is not equal to the indexWordCompare position
                //swap pisition 0 to 1 if is equal to the indexWordCompare
                if(permutations[indexWordCompare]==String.valueOf(arrayWord1) ){

                    arrayWord1 = swap(arrayWord1,indexSwapValue,true);
                    posibleCombinations--;
                    //addValue
                    permutations[(int)posibleCombinations]=String.valueOf(arrayWord1);
                    indexWordCompare=(int)posibleCombinations;
                    indexSwapValue++;
                    indexSwapPosition=word1.length()-1;
                    word1LengthCombinations--;
                }else{
                    indexSwapPosition--;
                    posibleCombinations--;
                    //addValue
                    permutations[(int)posibleCombinations]=String.valueOf(arrayWord1);
                }
                //compare indexSwapPosition == 1 then get again word1.lenth()-1
                if(indexSwapPosition==1){
                    indexSwapPosition=word1.length()-1;
                }

            }


        }


    }*/



   /* public void generateCombinations(){
        RecursiveAlgorithms recursiveAlgorithms = new RecursiveAlgorithms();

        String word1="12345";
        String word2="13245";
        long posibleCombinations=recursiveAlgorithms.factorial(word1.length());

        String permutations [] = new String[(int)posibleCombinations];



        char [] arrayWord1=word1.toCharArray();

        int word1LengthCombinations = word1.length();

        int indexWordCompare=(int) posibleCombinations-1;

        posibleCombinations--;

        int indexSwapPosition=word1.length()-1;
        int indexSwapValue=1;

        while (word1LengthCombinations != 0) {


            //compare is not equal to the indexWordCompare position
            //swap pisition 0 to 1 if is equal to the indexWordCompare
            if (String.valueOf(arrayWord1).equals(permutations[indexWordCompare])) {

                arrayWord1 = swap(arrayWord1, indexSwapValue, true);

                //addValue
                permutations[(int) posibleCombinations] = String.valueOf(arrayWord1);
                indexWordCompare = (int) posibleCombinations;
                posibleCombinations--;
                indexSwapValue++;
                indexSwapPosition = word1.length() - 1;
                word1LengthCombinations--;
            } else {

                if(!(permutations[indexWordCompare] == String.valueOf(arrayWord1))){

                    //addValue
                    permutations[(int) posibleCombinations] = String.valueOf(arrayWord1);
                    posibleCombinations--;
                }

            }


            //make swap
            arrayWord1 = swap(arrayWord1, indexSwapPosition, false);
            indexSwapPosition--;

            //compare indexSwapPosition == 1 then get again word1.lenth()-1
            if (indexSwapPosition == 1) {
                indexSwapPosition = word1.length() - 1;
            }
            //the array permutation is full it means that already find all the combinations
            if(posibleCombinations<0)
                break;
        }

        for(String aux : permutations){
            System.out.println(aux);
            if(aux.equals(word2))
                System.out.println("Is equal to =" +aux);
        }


    }
    public char[] swap(char [] array, int position,boolean changeCombination){

        if(changeCombination){
            char aux=array[0];
            array[0]=array[position];
            array[position]=aux;
        }else {
            char aux=array[position-1];
            array[position-1]=array[position];
            array[position]=aux;
        }

        return array;
    }*/
    /*

    public void generateCombinations() {
        RecursiveAlgorithms recursiveAlgorithms = new RecursiveAlgorithms();

        String word1 = "12345";
        String word2 = "13245";
        long possibleCombinations = recursiveAlgorithms.factorial(word1.length());

        String[] permutations = new String[(int) possibleCombinations];

        char[] arrayWord1 = word1.toCharArray().clone(); // Trabajar con una copia

        int indexWordCompare = (int) possibleCombinations - 1;
        possibleCombinations--;

        int indexSwapPosition = word1.length() - 1;
        int indexSwapValue = 1;

        while (possibleCombinations >= 0) {
            if (String.valueOf(arrayWord1).equals(permutations[indexWordCompare])) {
                arrayWord1 = swap(arrayWord1.clone(), indexSwapValue, true);
                permutations[(int) possibleCombinations] = String.valueOf(arrayWord1);
                indexWordCompare = (int) possibleCombinations;
                possibleCombinations--;
                indexSwapValue++;
                indexSwapPosition = word1.length() - 1;
            } else {
                if (!(permutations[indexWordCompare] == String.valueOf(arrayWord1))) {
                    permutations[(int) possibleCombinations] = String.valueOf(arrayWord1);
                    possibleCombinations--;
                }
            }

            arrayWord1 = swap(arrayWord1.clone(), indexSwapPosition, false);
            indexSwapPosition--;

            if (indexSwapPosition == 0) {
                indexSwapPosition = word1.length() - 1;
            }

            if (possibleCombinations < 0) {
                break;
            }
        }

        for (String aux : permutations) {
            System.out.println(aux);
            if (aux.equals(word2)) {
                System.out.println("Is equal to =" + aux);
            }
        }
    }

    public char[] swap(char[] array, int position, boolean changeCombination) {
        if (changeCombination) {
            char aux = array[0];
            array[0] = array[position];
            array[position] = aux;
        } else {
            char aux = array[position - 1];
            array[position - 1] = array[position];
            array[position] = aux;
        }

        return array;
    }

    */

    /*public void generateCombinations() {
        RecursiveAlgorithms recursiveAlgorithms = new RecursiveAlgorithms();

        String word1 = "1234";
        String word2 = "1234";
        long possibleCombinations = recursiveAlgorithms.factorial(word1.length());

        String[] permutations = new String[(int) possibleCombinations];

        char[] arrayWord1 = word1.toCharArray().clone(); // Trabajar con una copia

        int indexWordCompare = (int) possibleCombinations - 1;
        possibleCombinations--;

        int indexSwapPosition = word1.length() - 1;
        int indexSwapValue = 1;

        while (possibleCombinations >= 0) {
            if (indexWordCompare >= 0 && String.valueOf(arrayWord1).equals(permutations[indexWordCompare])) {
                arrayWord1 = swap(arrayWord1.clone(), indexSwapValue, true);
                permutations[(int) possibleCombinations] = String.valueOf(arrayWord1);
                indexWordCompare = (int) possibleCombinations - 1;  // Actualizar el índice correctamente
                possibleCombinations--;
                indexSwapValue++;
                indexSwapPosition = word1.length() - 1;
            } else {
                if (!(indexWordCompare >= 0 && (permutations[indexWordCompare] == String.valueOf(arrayWord1)))) {
                    permutations[(int) possibleCombinations] = String.valueOf(arrayWord1);
                    possibleCombinations--;
                }
            }

            arrayWord1 = swap(arrayWord1.clone(), indexSwapPosition, false);
            indexSwapPosition--;

            if (indexSwapPosition == 0) {
                indexSwapPosition = word1.length() - 1;
            }

            if (possibleCombinations < 0) {
                break;
            }
        }

        for (String aux : permutations) {
            System.out.println(aux);
            if (aux.equals(word2)) {
                System.out.println("Is equal to =" + aux);
            }
        }

        System.out.println(permutations.length);
    }

    public char[] swap(char[] array, int position, boolean changeCombination) {
        if (position >= 0 && position < array.length) {
            if (changeCombination) {
                char aux = array[0];
                array[0] = array[position];
                array[position] = aux;
            } else {
                char aux = array[position - 1];
                array[position - 1] = array[position];
                array[position] = aux;
            }
        } else {
            System.out.println("Invalid position: " + position);
        }

        return array;
    }
    */

    public void generatePermutations(String word1, String word2) {
        RecursiveAlgorithms recursiveAlgorithms = new RecursiveAlgorithms();

        long possibleCombinations = recursiveAlgorithms.factorial(word1.length());

        String[] permutations = new String[(int) possibleCombinations];

        char[] arrayWord1 = word1.toCharArray().clone();

        int indexWordCompare = (int) possibleCombinations - 1;
        possibleCombinations--;

        int indexSwapPosition = word1.length() - 1;
        int indexSwapValue = 1;

        while (possibleCombinations >= 0) {
            if (indexWordCompare >= 0 && String.valueOf(arrayWord1).equals(permutations[indexWordCompare])) {
                arrayWord1 = swap(arrayWord1.clone(), indexSwapValue, true);
                indexWordCompare = (int) possibleCombinations - 1;
                possibleCombinations--;
                indexSwapValue++;
                indexSwapPosition = word1.length() - 1;
            } else {
                if (!(indexWordCompare >= 0 && (permutations[indexWordCompare] == String.valueOf(arrayWord1)))) {
                    permutations[(int) possibleCombinations] = String.valueOf(arrayWord1);
                    possibleCombinations--;
                }
            }

            arrayWord1 = swap(arrayWord1.clone(), indexSwapPosition, false);
            indexSwapPosition--;

            if (indexSwapPosition == 0) {
                indexSwapPosition = word1.length() - 1;
            }

            if (possibleCombinations < 0) {
                break;
            }
        }

        for (String aux : permutations) {
            if (aux != null) {
                System.out.println(aux);
                if (aux.equals(word2)) {
                    System.out.println("Is equal to =" + aux);
                }
            }
        }
    }

    public char[] swap(char[] array, int position, boolean changeCombination) {
        if (position >= 0 && position < array.length) {
            if (changeCombination) {
                char aux = array[0];
                array[0] = array[position];
                array[position] = aux;
            } else {
                char aux = array[position - 1];
                array[position - 1] = array[position];
                array[position] = aux;
            }
        } else {
            System.out.println("Invalid position: " + position);
        }

        return array;
    }


}


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

