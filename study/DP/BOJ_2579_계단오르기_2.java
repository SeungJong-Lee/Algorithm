package study.DP;

import java.io.*;
import java.util.Arrays;

public class BOJ_2579_계단오르기_2 {
	static int[] memo;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		memo = new int[n+1];
		Arrays.fill(memo, -1);
		for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		memo[0] = arr[0];
		memo[1] = arr[1];
		if(n>1) memo[2] = arr[1] + arr[2];
		System.out.println(recursive(n));
	}
	private static int recursive(int n) {
		if(memo[n] == -1) {
			memo[n] = Math.max(recursive(n-2), recursive(n-3)+arr[n-1]) + arr[n];
		}
		return memo[n];
	}
}
