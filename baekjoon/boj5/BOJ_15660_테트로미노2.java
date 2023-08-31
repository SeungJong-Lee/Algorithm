package baekjoon.boj5;

import java.io.*;
import java.util.*;

public class BOJ_15660_테트로미노2 {
	static int N, M, Ans, Max;
	static int[][] map;
	static boolean[][] v;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				Max = Math.max(Max, map[i][j]);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				v[i][j] = true;
				solve(i, j, 1, map[i][j], false);
				v[i][j] = false;
			}
		}
		System.out.println(Ans);
	}
	private static void solve(int r, int c, int cnt, int sum, boolean flag) {
		if(flag && Ans>=sum+(Max*(4-cnt))) return;
		if(!flag && Ans>=sum+(Max*(8-cnt))) return;
		if(cnt == 4) {
			if(flag) {
				Ans = Math.max(Ans, sum);
				return;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(!v[i][j]) {
						v[i][j] = true;
						solve(i, j, 1, sum+map[i][j], true);
						v[i][j] = false;
					}
				}
			}
		}
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr<0 || nc<0 || nr>=N || nc>=M || v[nr][nc]) continue;
			v[nr][nc] = true;
			if(cnt==1) {
				for (int i = 0; i < 4; i++) {
					int nnr = nr + dr[i];
					int nnc = nc + dc[i];
					if(nnr<0 || nnc<0 || nnr>=N || nnc>=M || v[nnr][nnc]) continue;
					v[nnr][nnc] = true;
					solve(nr, nc, cnt+2, sum+map[nnr][nnc]+map[nr][nc], flag);
					v[nnr][nnc] = false;
				}
			}
			solve(nr, nc, cnt+1, sum+map[nr][nc], flag);
			v[nr][nc] = false;
		}
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
}
