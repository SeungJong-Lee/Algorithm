package study.algorithm;

/*
 * 비트 순열
 * Sel배열 (선택할 갯수), k, flag가 필요함 
 */

/*
 * 기본 순열
 * Sel배열 (선택할 갯수), k, v배열 필요 (범위만큼의 boolean)
 */

import java.io.*;
import java.util.*;

public class Permutation {

	static int N, M, Cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
//		permutation(new int[M], 0, 0);
		originPermutation(new int[M], 0, new boolean[N]);
		System.out.println();
		permutation(new int[M], 0, 0);
		System.out.println("cnt: " + Cnt);
	}

	private static void originPermutation(int[] sel, int k, boolean[] v) {
		if( k == sel.length) {
			Cnt++;
			System.out.println(Arrays.toString(sel));
			return;
		}
		for (int i = 0; i < N; i++) {
			if(!v[i]) {
				v[i] = true;
				sel[k] = i;
				originPermutation(sel, k+1, v);
				v[i] = false;
			}
		}
	}

	private static void permutation(int[] sel, int k, int flag) {
		if(k == sel.length) {
//			Cnt++;
			System.out.println(Arrays.toString(sel));
			return;
		}
		for (int i = 0; i < N; i++) {
			if((flag & (1<<i)) > 0) continue;
			sel[k] = i;
			permutation(sel, k+1, flag | (1<<i) );
		}
	}

}
