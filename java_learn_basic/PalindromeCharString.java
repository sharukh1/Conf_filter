
import java.util.Scanner;

public class PalindromeCharString 
{
public static void main(String[] args) {
	
	// Reading string from user input
	Scanner sc= new Scanner(System.in);
	
	System.out.println("Please enter the string to check palindrome:");
	String inputByUser= sc.nextLine();
	
	//converting string in to char array
	char[] stringInChar= inputByUser.toCharArray();
	for(char r:stringInChar){
		System.out.print(" "+r);
	}
	String reverseInput="";
	// reading char by char and forming a string
	for(int i=stringInChar.length-1;i>= 0;i--)
	{
		reverseInput= reverseInput+stringInChar[i];
	}
	System.out.println("Inout string:"+inputByUser);
	System.out.println("Reverse String:"+reverseInput);
	if(inputByUser.equals(reverseInput))
		System.out.println("Entered string is palindrome.");
	else
		System.out.println("Entered string is not palindrome.");
}
}