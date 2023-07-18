package BOJ.BOJ1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15649_N과M_1 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		recurisve(new int[M], 0, new boolean[N]);
	}

	private static void recurisve(int[] sel, int k, boolean[] v) {
		// basis part
		if(k == sel.length) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < sel.length; i++) {
				sb.append(sel[i]+" ");
			}
			System.out.println(sb);
			return;
		}
		for (int i = 0; i < v.length; i++) {
			if(v[i] == false) {
				v[i] = true;
				sel[k] = i+1;
				recurisve(sel, k+1, v);
				v[i] = false;
			}
		}
	}

}
