package org.niraj.util;

public class TotalCharacterCount {
	public static void main(String[] args) {

	    String string = "Kerala-based Manappuram Finance leads the list of ten companies from the BSE 500 stocks that have doubled in 2016 so far. Manappuram's stock has gained nearly 210%, which the analysts attributed to the firm's efforts to diversify its loan book. Other strong performers were Escorts and Gujarat Narmada Valley Fertiliser, which have gained around 133% and 126% respectively.";

	    int count = 0;
	    int countTotal = 0;
	    for(int i =0; i < string.length(); i++){
	        if(string.charAt(i) == 'i'){
	            count++;
	            }
	        if(string.charAt(i) != ' ' ){
		        countTotal++;
	        }
	    }
	    System.out.println("The number of letter i is " + count);
	    System.out.println("The number of letter is "   + countTotal);		
	}
}
