package study.DP;

import java.io.*;
import java.math.BigInteger;

public class BOJ_1793_타일링 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String input = br.readLine();
			if(input == null) break;
			int n = Integer.parseInt(input);
			BigInteger[] arr = new BigInteger[n+1];
			arr[0] = new BigInteger("1");
			if(n>0) arr[1] = new BigInteger("1");
			if(n>1) {
				arr[2] = new BigInteger("3");
				for (int i = 3; i < arr.length; i++) {
					arr[i] = arr[i-1].add(arr[i-2].multiply(BigInteger.valueOf(2)));
				}
			}
			System.out.println(arr[n]);
		}
	}
}
