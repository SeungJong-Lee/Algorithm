package study.algorithm;

import java.io.*;
import java.util.*;

public class DFS_BFS {

	static int N, Cnt;
	static int[][] map;
	static boolean[][] v;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v = new boolean[N][N];
		bfs(0, 0, 1);
		print(map);
		System.out.println("------------- START DFS --------------");
		map = new int[N][N];
		v = new boolean[N][N];
		v[0][0] = true;
		dfs(0, 0, 1);
		System.out.println(Cnt);
	}
	private static void bfs(int r, int c, int val) { // 가중치가 없는 최단거리를 구할 때 사용, 가중치가 있다면 Dijkstra
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(r, c, val));
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			v[p.r][p.c] = true;
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || v[nr][nc]) continue;
				map[nr][nc] = p.val;
				v[nr][nc] = true;
				queue.offer(new Point(nr, nc, p.val+1));
			}
		}
	}
	
	private static void dfs(int r, int c, int val) { // 목적지 까지 가는 경우의 수를 구할 때 사용
		if(r == N-1 && c == N-1) {
			Cnt++;
			print(map);
			return;
		}
//		v[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= N || v[nr][nc]) continue;
			v[nr][nc] = true;
			map[nr][nc] = val;
			dfs(nr, nc, val+1);
			
			// 백 트래킹 기법으로 다양한 방법으로 N-1, N-1 까지 가는 부분 추가
			v[nr][nc] = false;
			map[nr][nc] = 0;
		}
	}
	
	private static class Point{
		int r, c, val;

		public Point(int r, int c, int val) {
			super();
			this.r = r;
			this.c = c;
			this.val = val;
		}
		
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	
	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
