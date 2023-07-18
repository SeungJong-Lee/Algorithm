package study.algorithm;

/*
 * 조합
 * sel (선택할 갯수), idx, k 필요
 */

import java.io.*;
import java.util.*;

public class Combination {

	static int N, M, Cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		combination(new int[M], 0, 0);
		System.out.println("cnt: " + Cnt);
	}
	private static void combination(int[] sel, int idx, int k) {
		if(k == sel.length) {
			Cnt++;
			System.out.println(Arrays.toString(sel));
			return;
		}
		for (int i = idx; i < N; i++) {
			sel[k] = i;
			combination(sel, i+1, k+1);
		}
	}

}
