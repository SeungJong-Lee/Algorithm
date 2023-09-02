package b_lecture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea3282_01Knapsack {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] w = new int[N+1];
			int[] v = new int[N+1];
			int[][] dp = new int[N+1][K+1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				w[i] = Integer.parseInt(st.nextToken());
				v[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i <= N; i++) { // 크기
				for (int j = 1; j <= K; j++) { // 가치
					dp[i][j] = dp[i-1][j];
					
					if(w[i] <= j) {
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - w[i]] + v[i]);
					}
				}
			}
			System.out.println("#"+tc+" "+dp[N][K]);
		}
	}

}
