package study.DP;

import java.io.*;
import java.util.*;

public class BOJ_12865_평범한배낭 {
	static int N, M;
	static int[][] dp;
	static int[] weight;
	static int[] value;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		weight = new int[N+1];
		value = new int[N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		dp = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if(weight[i] <= j) {
					dp[i][j] = Math.max(dp[i-1][j], value[i] + dp[i-1][j-weight[i]]);
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[N][M]);
	}
}
