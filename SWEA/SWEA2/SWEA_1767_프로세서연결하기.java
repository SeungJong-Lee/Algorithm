package SWEA.SWEA2;

/*
 * 백트래킹 문제
 * 1. 가장자리에 연결되지 않은 core에서 한 방향으로 전선을 연결해본다.
 * 2. 전선을 연결한 후 맵을 깊은 복사해서 다른 core에 가장자리로 연결해본다.
 * 3. 모든 core가 연결 됐다면 전선의 길이 최소를 구한다.
 */

import java.io.*;
import java.util.*;

public class SWEA_1767_프로세서연결하기 {

	static int N, Ans, Conect;
	static int[][] map;
	static ArrayList<Point> list;
	static boolean[][] v;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./SeungJong/input/input_swea1767.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			Conect = 0;
			Ans = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			v = new boolean[N][N];
			list = new ArrayList<Point>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						if(i==0 || j==0 || i == N-1 || j == N-1) continue;
						list.add(new Point(i, j, 0));
					}
				}
			}
			solve(0, 0, 0);
			System.out.println("#"+tc+" "+Ans);
		}
	}
	
	private static void solve(int index, int con, int wire) {
		if(index == list.size()) {
			if(con > Conect) {
				Ans = wire;
				Conect = con;
			}
			else if(con == Conect) Ans = Math.min(Ans, wire);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nr = list.get(index).r;
			int nc = list.get(index).c;
			int k = 0;
			while(true) {
				nr += dr[i];
				nc += dc[i];
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) {
					break;
				}
				if(map[nr][nc] != 0) {
					k = 0;
					break;
				}
				k++;
			}
			int x = list.get(index).r;
			int y = list.get(index).c;
			for (int j = 0; j < k; j++) {
				x += dr[i];
				y += dc[i];
				map[x][y]  = 2;
			}
			if(k == 0) solve(index+1, con, wire);
			else {
				solve(index+1, con+1, wire+k);
				x = list.get(index).r;
				y = list.get(index).c;
				for (int j = 0; j < k; j++) {
					x += dr[i];
					y += dc[i];
					map[x][y]  = 0;
				}
			}
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

}
