package Test_1;

//import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test4_이승종 {

	public static void main(String[] args) throws FileNotFoundException {
//		Scanner in = new Scanner(System.in);
//		Scanner in = new Scanner(new File("Test4.txt"));
		System.setIn(new FileInputStream("Test4.txt"));
		Scanner sc = new Scanner(System.in);
		int T, N;
		int[] arr;
		T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			double sum = 0;
			double count = 0;
			double avg = 0;
			N = sc.nextInt();
			arr = new int[N];
			for (int j = 0; j < N; j++) {
				arr[j] = sc.nextInt();
				sum += arr[j];
			}
			avg = sum/N;
			for (int j = 0; j < N; j++) {
				if(arr[j] < avg) {
					count += 1;
				}
			}
			double rate = count/N;
			rate = Math.round(rate * 100000);
			rate = rate/1000;
			System.out.printf("#%d %.3f%%\n", i+1, rate);
		}
		
		sc.close();
	}
}
