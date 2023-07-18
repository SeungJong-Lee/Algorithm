package SWEA.SWEA2;

/*
 * 중복순열로 N개의 벽돌 위치 (열)을 정해서 시뮬레이션 실시
 */

import java.io.*;
import java.util.*;

public class SWEA_5656_벽돌깨기 {
	static int N, R, C, Ans;
	static int[][] map;
	static Stack<Integer> stack = new Stack<Integer>();
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./SeungJong/input/input_swea5656.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			Ans = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < C; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			permutation(new int[N], 0);
			System.out.println("#"+tc+" "+Ans);
		}
	}
	private static void permutation(int[] sel, int k) {
		if(k == sel.length) {
			int cnt = 0;
			int[][] arr = new int[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					arr[i][j] = map[i][j];
				}
			}
//			System.out.println(Arrays.toString(sel));
			simulation(arr, sel);
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(arr[i][j] != 0) cnt++;
				}
			}
//			System.out.println(cnt);
//			System.out.println();
			Ans = Math.min(Ans, cnt);
			return;
		}
		for (int i = 0; i < C; i++) {
			sel[k] = i;
			permutation(sel, k+1);
		}
	}
	private static void simulation(int[][] arr, int[] sel) {
		for (int i = 0; i < sel.length; i++) {
			// i : i 번째 공 투척
			// 0 인덱스부터 R방향으로 하나씩 내려가면서 가장 먼저 만나는 벽돌 폭발
			int r = 0;
			int k = 0;
			while(true) {
				if(r >= R) {
					r = -1;
					break;
				}
				if(arr[r][sel[i]] != 0) {
					k = arr[r][sel[i]];
					break;
				}
				r++;
			}
			if(r != -1) {
				boomb(arr, r, sel[i], k);
				sort(arr);
//				print(arr);
			}
		}
	}

	private static void sort(int[][] arr) {
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				if(arr[j][i] != 0) {
					stack.push(arr[j][i]);
					arr[j][i] = 0;
				}
			}
			int index = R-1;
			while(!stack.isEmpty()) {
				arr[index--][i] = stack.pop();
			}
		}
	}
	private static void boomb(int[][] arr, int r, int c, int k) {
		arr[r][c] = 0;
		for (int i = 1; i < k; i++) {
			for (int j = 0; j < 4; j++) {
				int nr = r + (dr[j]*i);
				int nc = c + (dc[j]*i);
				
				if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
				if(arr[nr][nc] != 0) {
					boomb(arr, nr, nc, arr[nr][nc]);
				}
			}
		}
	}
	private static void print(int[][] arr) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println(); 
		}
		System.out.println();
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

}
