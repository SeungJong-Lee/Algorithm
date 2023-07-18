package study.source;

import java.util.Scanner;

public class hw_1_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("숫자를 입력하세요 : ");
		int N = sc.nextInt();
		while(N!=0) {
			for (int i = 1; i <= 9; i++) {
				System.out.println(N+" * "+i+" = "+(N*i));
			}
			System.out.printf("다음 숫자 입력 : ");
			N = sc.nextInt();		
		}
		System.out.println("프로그램 종료");
		sc.close();
	}

}
