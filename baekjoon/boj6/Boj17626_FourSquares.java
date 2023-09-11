package baekjoon.boj6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj17626_FourSquares {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		dp[1] = 1;
		int cnt = 0;
		for (int i = 2; i <= N; i++) {
			cnt = 250;
			for (int j = 1; j*j <= i; j++) {
				int val = i - (j*j);
				cnt = Math.min(cnt, dp[val]);
			}
			dp[i] = cnt + 1;
		}
		System.out.println(dp[N]);
	}

}
