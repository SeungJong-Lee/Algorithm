package b_lecture;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Swea1231_중위순회 {
	static int N;
	static char[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[N+1];
			for (int i = 1; i <= N; i++) {
				arr[i] = br.readLine().split(" ")[1].charAt(0);
			}
			System.out.print("#"+tc+" ");
			dfs(1);
			System.out.println();
		}
	}
	private static void dfs(int i) {
		if(i > N) return;
		dfs(i*2);
		System.out.print(arr[i]);
		dfs(i*2 + 1);
	}
}
