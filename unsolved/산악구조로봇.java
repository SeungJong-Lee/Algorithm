package unsolved;

import java.io.*;
import java.util.*;

public class 산악구조로봇 {
	static int N, Ans;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./SeungJong/input/산악구조로봇.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			Ans = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			visit[0][0] = true;
			dfs(0, 0, 0);
			System.out.println("#"+tc+" "+Ans);
		}
	}
	private static void dfs(int r, int c, int val) {
		if(r == N-1 && c == N-1) {
			Ans = Math.min(Ans,  val);
			return;
		}
		if(val < Ans) {
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc]) continue;
				if(map[nr][nc] == map[r][c]) {
					if(val+1 >= Ans) continue;
					visit[nr][nc] = true;
					dfs(nr, nc, val+1);
					visit[nr][nc] = false;
				}
				else if(map[nr][nc] < map[r][c]) {
					visit[nr][nc] = true;
					dfs(nr, nc, val);
					visit[nr][nc] = false;
				}
				else if(map[nr][nc] > map[r][c]) {
					if(val+((map[nr][nc]-map[r][c])*2) >= Ans) continue;
					visit[nr][nc] = true;
					dfs(nr, nc, val+((map[nr][nc]-map[r][c])*2));
					visit[nr][nc] = false;
				}
			}
		}
	}

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
}
