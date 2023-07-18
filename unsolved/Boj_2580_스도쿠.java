package unsolved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_2580_스도쿠 {

	static int[][] map = new int[9][9];
	static int totalCnt;
	static ArrayList<Integer> num = new ArrayList<Integer>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			num.add(i+1);
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) totalCnt++;
			}
		}
		
		dfs(0, 0, 0);

	}
	private static void print() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	private static void dfs(int r, int c, int cnt) {
		if(cnt == totalCnt) {
			print();
			System.exit(0);
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(map[i][j] == 0) {
					for (int k = 1; k <= 9; k++) {
						if(check(i, j, k)) {
							map[i][j] = k;
							dfs(i, j, cnt+1);
							map[i][j] = 0;			
						}
					}
				}
			}
		}
	}
	
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
//	
	

}
