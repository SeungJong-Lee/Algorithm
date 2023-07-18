package unsolved;

import java.io.*;
import java.util.*;

public class Solution_1 {
	static int N, Ans;
	static int[][] map;
	static boolean[][] v;
	static ArrayList<Point> list;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./SeungJong/input/Solution_1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			Ans = 0;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			v = new boolean[N][N];
			list = new ArrayList<Point>();
			list.add(new Point(0, 0, Integer.MIN_VALUE, 0, 0));
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] > 0) list.add(new Point(i, j, map[i][j], 0, 0));
				}
			}
			Collections.sort(list);
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
			solve(0, 0, list);
			System.out.println("#"+tc+" "+Ans);
		}
	}
	
	private static void solve(int r, int c, ArrayList<Point> list) {
		for (int i = 0; i < list.size(); i++) {
			v = new boolean[N][N];
			v[list.get(i).r][list.get(i).c] = true;
			Queue<Point> queue = new LinkedList<Point>();
			queue.offer(list.get(i));
			while(!queue.isEmpty()) {
				Point p = queue.poll();
				// 그냥 가기, 1번 회전하고 가기
				int nr1 = p.r + dr[p.dir%4];
				int nc1 = p.c + dc[p.dir%4];
				
				if(nr1 < 0 || nc1 < 0 || nr1 >= N || nc1 >= N) continue;
				if(nr1 == list.get(i).r && nc1 == list.get(i).c) {
					Ans += p.cnt;
					break;
				}
				else {
					queue.offer(new Point(nr1, nc1, p.val, p.dir, p.cnt));
				}
				p.dir++;
				p.cnt++;
				int nr2 = p.r + dr[p.dir%4];
				int nc2 = p.c + dc[p.dir%4];
				
				if(nr2 < 0 || nc2 < 0 || nr2 >= N || nc2 >= N) continue;
				if(nr2 == list.get(i).r && nc2 == list.get(i).c) {
					Ans += p.cnt;
					break;
				}
				else {
					queue.offer(new Point(nr1, nc1, p.val, p.dir, p.cnt));
				}
				
				
			}
		}
	}

	private static class Point implements Comparable<Point>{
		int r, c, val, dir, cnt;

		public Point(int r, int c, int val, int dir, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.val = val;
			this.dir = dir;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.val, o.val);
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", val=" + val + ", dir=" + dir + ", cnt=" + cnt + "]";
		}
	}
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
}

