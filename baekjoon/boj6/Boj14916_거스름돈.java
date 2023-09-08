package baekjoon.boj6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj14916_거스름돈 {
    private static int MAX_VALUE = 100001;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        Arrays.fill(dp, MAX_VALUE);
        if (N == 1 || N == 3) System.out.println(-1);
        else if (N == 2 || N == 5) System.out.println(1);
        else if (N == 4) System.out.println(2);
        else {
            dp[2] = 1;
            dp[4] = 2;
            dp[5] = 1;
            for (int i = 6; i <= N; i++) {
                if (dp[i-2] == MAX_VALUE && dp[i-5] == -1) dp[i] = MAX_VALUE;
                else dp[i] = Math.min(dp[i-2]+1, dp[i-5]+1);
            }
            System.out.println(dp[N]==MAX_VALUE?-1:dp[N]);
        }
    }
}
