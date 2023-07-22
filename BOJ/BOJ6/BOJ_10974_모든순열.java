package BOJ.BOJ6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10974_모든순열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		permutation(new int[n], 0, 0);
		
	}

	private static void permutation(int[] sel, int k, int flag) {
		if(k == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= sel.length; i++) {
			if(((1<<i) & flag) > 0) continue;
			sel[k] = i;
			permutation(sel, k+1, flag | (1<<i));
		}
	}

}
