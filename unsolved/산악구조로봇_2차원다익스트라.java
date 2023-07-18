package unsolved;

import java.io.*;
import java.util.*;

public class 산악구조로봇_2차원다익스트라 {
	static int N, Ans;
	static int[][] map;
	static boolean[][] visit;
	static int[][] dist;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./SeungJong/input/산악구조로봇.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			Ans = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visit = new boolean[N][N];
			dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dijkstra();
			System.out.println("#"+tc+" "+Ans);
		}
	}
	private static void dijkstra() {
		for (int i = 0; i < dist.length; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		dist[0][0] = 0;
		PriorityQueue<Point> queue = new PriorityQueue<Point>();
		queue.offer(new Point(0, 0, 0));
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(!visit[p.r][p.c]) {
				visit[p.r][p.c]= true;
				if(p.r == N-1 && p.c == N-1) {
					Ans = Math.min(Ans, p.fuel);
				}
				
				for (int i = 0; i < 4; i++) {
					int nr = p.r + dr[i];
					int nc = p.c + dc[i];
					
					if(nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc]) continue;
					int temp = map[nr][nc];
					int val;
					if(map[p.r][p.c] > temp) val = 0;
					else if(map[p.r][p.c] == temp) val = 1;
					else val = (temp-map[p.r][p.c])*2;
					if(dist[nr][nc] > p.fuel+val) {
						dist[nr][nc] = p.fuel+val;
						queue.offer(new Point(nr, nc, dist[nr][nc]));
					}
				}
			}
		}
	}
	
	private static class Point implements Comparable<Point>{
		int r, c, fuel;

		public Point(int r, int c, int fuel) {
			super();
			this.r = r;
			this.c = c;
			this.fuel = fuel;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.fuel, o.fuel);
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
}
