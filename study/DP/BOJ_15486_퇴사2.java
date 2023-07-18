package study.DP;

import java.io.*;
import java.util.*;

public class BOJ_15486_퇴사2 {
	static int N, Ans;
	static int[][] map;
	static int[] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][2];
		dp = new int[N+2];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		solve(1);
	}
	private static void solve(int start) {
		for (int i = start ; i <= N; i++) {
			Ans = Math.max(Ans, dp[i]);
			if(i+map[i][0] < dp.length) {
				dp[i+map[i][0]] = Math.max(map[i][1] + Ans, dp[i+map[i][0]]);
			}
		}
		System.out.println(Ans>dp[N+1]?Ans:dp[N+1]);
	}
}
