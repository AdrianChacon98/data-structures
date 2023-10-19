package com.estructuras.datastrutures.infija_a_prefija;

import java.util.Stack;

public class Prefija {



    public Prefija(){

    }

    public void convertirAPosfijo(String entrefijo)
    {
        char caracter=' ';

        String posfijo="";
        Stack<Character> pila=new Stack <Character>();

        for(int i=0;i<entrefijo.length();)
        {
            caracter=entrefijo.charAt(i);

            if(isOperando(caracter))
            {
                posfijo+=caracter;
            }
            else if(isOperador(caracter))
            {
                //buscar el operador para comparar
                while(!pila.empty() && jerarquia(pila.peek())>=jerarquia(caracter))
                {
                    posfijo+=pila.pop();
                }
                pila.push(caracter);
            }
            else if(isParentesisAbre(caracter))
            {
                pila.push(caracter);
            }
            else if(isParentesisCierra(caracter))
            {

                while(!pila.empty())
                {
                    char parentesisOpen=pila.pop();
                    if(isParentesisAbre(parentesisOpen))
                    {

                        break;
                    }
                    posfijo+=parentesisOpen;

                }

            }
            i++;



        }

        while(!pila.empty())//mientras la pila no este vacia
        {
            posfijo+=pila.pop();//guardar los signos diferentes
        }

        System.out.println(posfijo);
    }

    public static boolean isOperando(char caracter)
    {
        return(caracter>='A' && caracter <='Z' || caracter>='a' && caracter<='z' || caracter>='0' && caracter<='9');
    }

    public static boolean isOperador(char caracter)
    {
        return (caracter=='+' || caracter=='-' || caracter=='%' || caracter=='/' || caracter=='*' || caracter=='^');
    }



    public static int jerarquia(char caracter)
    {
        if(caracter=='+' || caracter=='-')
            return 1;
        else if(caracter=='*' || caracter=='/' || caracter=='%')
            return 2;
        else if(caracter=='^')
            return 3;
        else
            return 0;
    }
    public static boolean isParentesisAbre(char caracter)
    {
        return(caracter=='(' || caracter=='{' || caracter=='[');
    }
    public static boolean isParentesisCierra(char caracter)
    {
        return(caracter==')' || caracter=='}' || caracter==']');
    }





}
