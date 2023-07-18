package unsolved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 스도쿠 {

	static int[][] map;
	static class Point{
		int r,c;
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static ArrayList<Point> list = new ArrayList<Point>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) list.add(new Point(i, j));
			}
		}
		
		solve(0); // 빈칸의 index = list의 index
		
	}
	private static void solve(int k) {  // k = 빈 좌표 index
		// basis part
		if(k == list.size()) {
			print();
			System.exit(0);
		}
		
		// inductive part
		int r = list.get(k).r;
		int c = list.get(k).c;
		
		for (int i = 1; i <= 9; i++) {
			// 가지치기
			if(check(r, c, i)) {
//			if(isRowCheck(r, c, i) && isColCheck(r, c, i) && isSquareCheck(r, c, i)) {
				map[r][c] = i;
				solve(k+1);
				map[r][c] = 0;				
			}
		}
		
	}
	
	// 중복되는 값이 없으면 true
	// 아니면 false
	private static boolean check(int r, int c, int val) {
		for (int i = 0; i < 9; i++) {
			if(map[r][i] == val || map[i][c] == val) return false;
		}
		r = r/3*3;
		c = c/3*3;
		for (int i = r; i < r+3; i++) {
			for (int j = c; j < c+3; j++) {
				if(map[i][j] == val) return false;
			}
		}
		return true;
	}
	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
//	private static boolean isSquareCheck(int r, int c, int val) {
//		ArrayList<Integer> square = new ArrayList<Integer>();
//		r = r/3*3;
//		c = c/3*3;
//		for (int i = r; i < r+3; i++) {
//			for (int j = c; j < c+3; j++) {
//				if(map[i][j] != 0) square.add(map[i][j]);
//			}
//		}
//		if(square.contains(val)) return false;
//		else return true;
//	}
//	private static boolean isColCheck(int r, int c, int val) {
//		ArrayList<Integer> col = new ArrayList<Integer>();
//		for (int i = 0; i < 9; i++) {
//			if(map[i][c] != 0) col.add(map[i][c]);
//		}
//		if(col.contains(val)) return false;
//		else return true;
//	}
//	private static boolean isRowCheck(int r, int c, int val) {
//		ArrayList<Integer> row = new ArrayList<Integer>();
//		for (int i = 0; i < 9; i++) {
//			if(map[r][i] != 0) row.add(map[r][i]);
//		}
//		if(row.contains(val)) return false;
//		else return true;
//	}
}
