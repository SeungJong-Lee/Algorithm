package study.algorithm;

/*
 * 부분집합
 * k, booelan v -> 선택할 경우와 선택하지 않을 경우를 나타내는 배열
 */

import java.io.*;

public class PowerSet {

	static int N, M, Cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		powerSet(0, new boolean[N]);
		System.out.println("cnt: " + Cnt);
	}
	private static void powerSet(int k, boolean[] v) {
		if(k == v.length) {
			Cnt++;
			for (int i = 0; i < v.length; i++) {
				if(v[i]) {
					System.out.print(i+" ");
				}
			}
			System.out.println();
			return;
		}
		v[k] = true;
		powerSet(k+1, v);
		v[k] = false;
		powerSet(k+1, v);
	}

}
