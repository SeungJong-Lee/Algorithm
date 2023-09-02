package b_lecture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea3304_최장공통부분수열 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			int[][] dp = new int[str1.length()+1][str2.length()+1];
			for (int i = 1; i <= str1.length(); i++) {
				for (int j = 1; j <= str2.length(); j++) {
					if(str1.charAt(i-1) == str2.charAt(j-1)) {
						dp[i][j] = dp[i-1][j-1] + 1;
					} else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					}
				}
			}
			System.out.println("#"+tc+" "+dp[str1.length()][str2.length()]);
		}
	}

}
