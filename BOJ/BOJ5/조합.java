package BOJ.BOJ5;

import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class 조합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
        BigInteger[][] B = new BigInteger[N+1][M+1];
        for (int i = 0; i <= N; i++) {
				for (int j = 0, end = Math.min(i, M); j <= end; j++) {
					if(j==0 || i==j) B[i][j] = new BigInteger("1");
					else B[i][j] = B[i-1][j-1].add(B[i-1][j]);
				}
        }
        System.out.println(B[N][M]);
    }
}
        