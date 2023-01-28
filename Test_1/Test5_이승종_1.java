package Test_1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test5_이승종_1 {
	static String[] arr = {"000000","001111","010011",
			"011100","100110","101001","110101","111010"};
	public static void main(String[] args) throws FileNotFoundException{
		System.setIn(new FileInputStream("Test5.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = "0";
		str += sc.next();
		String temp= "";
		String ans = "";
		int index = 0;
		boolean isBreak = false;
		int[] count = new int[8];
		for (int i = 1; i <= N*6; i++) {
			temp += str.charAt(i);		
			if(!isBreak) {
				if(i%6 == 0) {
					boolean isFind = false;
					isBreak = false;
					for (int j = 0; j < arr.length; j++) {
						if(temp.equals(arr[j])) {
							ans += j;
							isFind = true;
							break;
						}
					}
					if(!isFind) {
						for (int j = 0; j < 8; j++) {
							for (int k = 0; k < 6; k++) {
								if(temp.charAt(k) != arr[j].charAt(k)) {
									count[j] += 1;
								}								
							}
						}
						for (int j = 0; j < count.length; j++) {
							if(count[j] <= 1) {
								ans += j;
								isBreak = true;
								break;
							}
						}
						if(!isBreak) {
							for (int j = 0; j < count.length; j++) {
								if(count[j]>1) index = j;
								break;
							}
						}
						
					}
					temp = "";
				}	
			}
		}
		if(isBreak) {
			System.out.println(index);
		}
		else {
			for (int i = 0; i < ans.length(); i++) {
				System.out.println(ans.charAt(i));
			}
		}
		
		sc.close();
	}
	
}