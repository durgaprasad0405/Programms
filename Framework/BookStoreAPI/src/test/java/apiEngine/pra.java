package apiEngine;

import java.util.Iterator;
import java.util.Scanner;

public class pra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		 int n, a = 0, b = 1,c;
//	        Scanner sc = new Scanner(System.in);
//	        System.out.print("Enter value of n:");
//	        n = sc.nextInt();
//	        for(int i = 1; i <= n; i++)
//	        {
//	           c = a + b;
//	           a=b;
//	           b=c;
//	            System.out.print(a+" ");
//	        }
		
		
		 Scanner sc = new Scanner(System.in);
		 System.out.print("Enter value of n:");
		 String a=sc.nextLine(), b="";
		for (int i=a.length()-1; i>=0; i--) {
			b=b+a.charAt(i);
			
		}
		if (a.equalsIgnoreCase(b)) {
			System.out.println(b+" it is palendrom");
		}
		else
			System.out.println(b+" it is  not palendrom");

	}

}
