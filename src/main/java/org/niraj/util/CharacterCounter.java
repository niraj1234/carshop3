package org.niraj.util;

public class CharacterCounter {

public static void main(String[] args){
    String string = "sashimi";

    int count = 0;
    for(int i =0; i < string.length(); i++){
        if(string.charAt(i) == 'i'){
            count++;
            }
    }
    System.out.println("The number of letter i is " + count);
  } 
}