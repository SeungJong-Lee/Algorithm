package study.DP;

import java.io.*;
import java.util.*;

public class BOJ_1520_내리막길 {
	static int N, M, Ans;
	static int[][] map;
	static int[][] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
//		dp[0][0] = 1;
//		solve(0, 0);
//		System.out.println(Ans);
		System.out.println(solveDp(0,0));
		System.out.println(Arrays.deepToString(dp));
	}
	private static void solve(int r, int c) {
		if(r == N-1 && c == M-1) {
			Ans++;
			return ;
		}
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr<0 || nc<0 || nr>=N || nc>= M) continue;
			if(map[nr][nc] < map[r][c]) {
				solve(nr, nc);
			}
		}
	}
	private static int solveDp(int r, int c) {
		if(r == N-1 && c == M-1) {
			return 1;
		}
		if(dp[r][c] != -1) return dp[r][c];
		dp[r][c] = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr<0 || nc<0 || nr>=N || nc>= M) continue;
			if(map[nr][nc] < map[r][c]) {
				dp[r][c] = Math.max(solveDp(nr, nc)+dp[r][c], dp[r][c]);
			}
		}
		return dp[r][c];
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
}
