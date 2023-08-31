package baekjoon.boj6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_17213_과일서리 {
	static int N, M, Ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		duplicatedCombination(new int[M-N], 0, 0);
		System.out.println(Ans);
	}
	private static void duplicatedCombination(int[] sel, int k, int idx) {
		if(sel.length == k) {
			System.out.println(Arrays.toString(sel));
			Ans++;
			return;
		}
		for (int i = idx; i < N; i++) {
			sel[k] = i;
			
			duplicatedCombination(sel, k+1, i);
		}
	}

}
