package baekjoon.boj1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15649_N과M_3 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		recurisve(new int[M], 0, new boolean[N]);
		System.out.println(sb);
	}

	private static void recurisve(int[] sel, int k, boolean[] v) {
		// basis part
		if(k == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				sb.append(sel[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < v.length; i++) {
			sel[k] = i+1;
			recurisve(sel, k+1, v);
		}
	}

}
