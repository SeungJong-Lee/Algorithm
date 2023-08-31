package baekjoon.boj6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3049_다각형의대각선 {
	static int Ans, N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		combination(new int[4], 0, 0);
		System.out.println(Ans);
	}

	private static void combination(int[] sel, int k, int idx) {
		if(k == sel.length) {
			Ans++;
			return;
		}
		for (int i = idx; i < N; i++) {
			sel[k] = i;
			combination(sel, k+1, i+1);
		}
	}

}
