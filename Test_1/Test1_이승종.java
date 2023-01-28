package Test_1;

import java.util.Scanner;

public class Test1_이승종 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputnum;
		int num = 1;
		char num2 = 'a';
		inputnum = sc.next();
		if(inputnum.charAt(0) == '1') {
			for (int i = 1; i <= 4; i++) {
				for (int j = 1; j <= i; j++) {
					System.out.printf("%d ", num++);
				}
				System.out.println("");
			}
		}
		else if(inputnum.charAt(0) == 'a') {
			for (int i = 5; i > 0; i--) {
				for (int j = 1; j < i; j++) {
					System.out.printf("  ");
				}
				for (int j = 0; j < 6-i; j++) {
					System.out.printf("%c ", num2);
					num2 += 1;
				}
				System.out.println("");
			}
		}
		sc.close();
	}

}
