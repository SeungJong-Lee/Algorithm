package study.algorithm;

/*
 * 중복순열
 * sel, k 필요함
 */

import java.io.*;
import java.util.*;

public class DuplicatedPermutation {

	static int N, M, Cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		duplicatedPermutation(new int[M], 0);
		System.out.println("cnt: " + Cnt);
	}
	private static void duplicatedPermutation(int[] sel, int k) {
		if(k == sel.length) {
			Cnt++;
			System.out.println(Arrays.toString(sel));
			return;
		}
		for (int i = 0; i < N; i++) {
			sel[k] = i;
			duplicatedPermutation(sel, k+1);
		}
	}

}
