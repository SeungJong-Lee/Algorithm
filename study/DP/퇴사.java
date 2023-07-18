package study.DP;

import java.io.*;
import java.util.*;

public class 퇴사 {
	static int N, Ans;
	static int[][] map;
	static int[][] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][2];
		dp = new int[N+1][2];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
//		solve(1, 0);
//		System.out.println(Ans);
		solveDp();
	}
	private static void solveDp() {
		int[] dp = new int[N+2];
		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(dp[i], max);
			int endDay = i+map[i][0];
			if(endDay <= N+1) {
				dp[endDay] = Math.max(max+map[i][1], dp[endDay]);
			}
			dp[i+1] = Math.max(dp[i], dp[i+1]);
		}
		System.out.println(max>dp[N+1]?max:dp[N+1]);
	}
	private static void solve(int i, int sum) {
		if(i>N) {
			Ans = Math.max(Ans, sum);
			return;
		}
		if(i+map[i][0]-1 <= N) solve(i+map[i][0], sum+map[i][1]);
		if(i <= N) solve(i+1, sum);
	}
}
