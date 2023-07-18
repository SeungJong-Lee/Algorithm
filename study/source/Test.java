package study.source;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long mul1 = 1;
		long mul2 = 1;
		for (int i = N; i >= N-M+1; i--) {
			mul1 *= i;
		}
		for (int i = 1; i <= M; i++) {
			mul2 *= i;
		}
//		System.out.println(mul1/mul2);
		System.out.println(mul1);
		System.out.println(mul2);
	}

}
