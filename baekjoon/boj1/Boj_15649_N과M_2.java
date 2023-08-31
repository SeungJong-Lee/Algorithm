package baekjoon.boj1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15649_N과M_2 {

	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		recurisve(new int[M], 1, 0);
	}
	private static void recurisve(int[] sel, int idx, int k) {
		if(k==sel.length) {
			StringBuilder sb = new StringBuilder();
			for (int i : sel) {
				sb.append(i+" ");
			}
			System.out.println(sb);
			return;
		}
		for (int i = idx; i <= N; i++) {
			sel[k] = i;
			recurisve(sel, i+1, k+1);
		}
	}
}
