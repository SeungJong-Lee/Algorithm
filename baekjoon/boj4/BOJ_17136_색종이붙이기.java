package baekjoon.boj4;

/*
 * 1. 1을 발견하면 색종이의 최대 사이즈를 구한다.
 * 2. 색종이의 사이즈를 1부터 최대 사이즈까지 붙이면서 백트래킹 시도.
 */

import java.io.*;
import java.util.*;

public class BOJ_17136_색종이붙이기 {
	static int[][] map = new int[10][10];
	static int[] paper = {0, 5, 5, 5, 5, 5};
	static int Ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve(0);
		System.out.println(Ans==Integer.MAX_VALUE?-1:Ans);
	}
	private static void solve(int cnt) {
		int r = -1, c = -1;
		L:for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(map[i][j] == 1) {
					r = i;
					c = j;
					break L;
				}
			}
		}
		if(r == -1 || c== -1) {
			Ans = Math.min(Ans, cnt);
			return;
		}
		if(cnt < Ans) {
			int size = findMaxSize(r, c);
			fillMap(r, c, size, cnt);
		}
	}
	private static int findMaxSize(int r, int c) {
		int cnt = 0;
		for (int size = 5; size >= 1; size--) {
			boolean find = true;
			L:for (int i = r; i < r+size; i++) {
				for (int j = c; j < c+size; j++) {
					if(i >= 10 || j >= 10 || map[i][j] != 1) {
						find = false;
						break L;
					}
				}
			}
			if(find) {
				cnt = size;
				return cnt;
			}
		}
		return cnt;
	}
	
	private static void fillMap(int r, int c, int maxSize, int cnt) {
		for (int size = 1; size <= maxSize; size++) {
			if(paper[size] > 0) {
				paper[size]--;
				for (int i = r; i < r+size; i++) {
					for (int j = c; j < c+size; j++) {
						map[i][j] = 0;
					}
				}
				solve(cnt+1);
				paper[size]++;
				for (int i = r; i < r+size; i++) {
					for (int j = c; j < c+size; j++) {
						map[i][j] = 1;
					}
				}
			}
		}
	}
}
