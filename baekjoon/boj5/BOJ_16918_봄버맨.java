package baekjoon.boj5;

import java.io.*;
import java.util.*;

public class BOJ_16918_봄버맨 {
	static int R, C, N;
	static char[][] map;
	static ArrayList<Point> list = new ArrayList<Point>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'O')
					list.add(new Point(i, j));
			}
		}
		if (N == 1)
			print();
		else if (N == 3) {
			setMap('O');
			for (int i = 0; i < list.size(); i++) {
				int r = list.get(i).r;
				int c = list.get(i).c;
				map[r][c] = '.';
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (nr < 0 || nc < 0 || nr >= R || nc >= C)
						continue;
					map[nr][nc] = '.';
				}
			}
			print();
		} else if (N % 2 == 0) {
			setMap('O');
			print();
		} else {
			N = N % 4;
			solve();
		}
	}

	private static void solve() {
		setMap('O');
		for (int i = 0; i < list.size(); i++) {
			int r = list.get(i).r;
			int c = list.get(i).c;
			map[r][c] = '.';
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr < 0 || nc < 0 || nr >= R || nc >= C)
					continue;
				map[nr][nc] = '.';
			}
		}
		// 3상태에서 폭탄들이 1에 터진다
		ArrayList<Point> oneCount = new ArrayList<Point>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'O') {
					oneCount.add(new Point(i, j));
				}
			}
		}
		setMap('O');
		for (int i = 0; i < oneCount.size(); i++) {
			int r = oneCount.get(i).r;
			int c = oneCount.get(i).c;
			map[r][c] = '.';
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr < 0 || nc < 0 || nr >= R || nc >= C)
					continue;
				map[nr][nc] = '.';
			}
		}
		if(N==1) {
			print();
			return;
		}else {
			// 1상태의 폭탄들이 3에 터진다
			ArrayList<Point> threeCount = new ArrayList<Point>();
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] == 'O') threeCount.add(new Point(i, j));
				}
			}
			setMap('O');
			for (int i = 0; i < threeCount.size(); i++) {
				int r = threeCount.get(i).r;
				int c = threeCount.get(i).c;
				map[r][c] = '.';
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (nr < 0 || nc < 0 || nr >= R || nc >= C)
						continue;
					map[nr][nc] = '.';
				}
			}
			print();
		}
	}

	private static void setMap(char val) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = val;
			}
		}
	}

	private static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	private static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
}
