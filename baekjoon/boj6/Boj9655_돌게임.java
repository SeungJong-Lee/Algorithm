package baekjoon.boj6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj9655_돌게임 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		if(N==1) System.out.println("SK");
		else if(N==2) System.out.println("CY");
		else if(N==3) System.out.println("SK");
		else {
			dp[1] = 1;
			dp[2] = -1;
			dp[3] = 1;
			for (int i = 4; i <= N; i++) {
				if(dp[i-1] == 1 || dp[i-3] == 1) dp[i] = -1;
				else dp[i] = 1;
			}
			System.out.println(dp[N]==1?"SK":"CY");
		}
	}
}
