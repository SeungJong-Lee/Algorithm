package study.source;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS_BFS {

	static int N;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
//		bfs();
		dfs(0, 0, 1, new boolean[N][N]);
//		System.out.println(cnt);
	}
	private static void dfs(int r, int c, int cnt, boolean[][] v) {
		if(r == N-1 && c == N-1) {
			print(map);
			return;
		}
		v[r][c] = true;
		
		for (int d = 0; d < dc.length; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= N || v[nr][nc]) continue;
			if(map[nr][nc] != -1) {
				v[nr][nc] = true;
				map[nr][nc] = cnt;
				dfs(nr, nc, cnt+1, v);
			}
		}
	}
	static int cnt;
	private static void bfs() {
		Queue<Point> Q = new LinkedList<Point>();
		Q.add(new Point(0, 0));
		boolean[][] v = new boolean[N][N];
		v[0][0] = true;
		int step = 1;
		int level = 0;
		map[0][0] = level++;
		while(!Q.isEmpty()) {
			int size = Q.size();
			for (int i = 0; i < size; i++) {
				Point p = Q.poll();
				if(p.r == N-1 && p.c == N-1) {
					cnt++;
					print(map);
					return;
				}
				
				for (int d = 0; d < dr.length; d++) {
					int nr = p.r + dr[d];
					int nc = p.c + dc[d];
					if(nr < 0 || nc < 0 || nr >= N || nc >= N || v[nr][nc]) continue;
					if(map[nr][nc] != -1) {
						v[nr][nc] = true;
						map[nr][nc] = level;						
						Q.add(new Point(nr, nc));
					}
				}				
			}
			level++;
		}
	}
	
	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int[] dr = {1, 0, 0, -1};
	static int[] dc = {0, 1, -1, 0};
	

}
