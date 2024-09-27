package Test;

public class Array_Exploration {

	public static void main(String[] args) {
		int [] arr = {2,3,4,5,5};
		System.out.println(arr[0]);
		System.out.println(arr[4]);
		int add = 0;
		for (int a = arr.length-1; a>=0; a--) {	
			System.out.println(arr[a]);
			add = add+arr[a];	
			}
		System.out.println(add);
		}
	}