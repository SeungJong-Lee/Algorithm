package year2024.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_13239_Combinations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Cnt = Integer.parseInt(br.readLine());
        for (int j = 0; j < Cnt; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N+1][K+1];
            arr[0][0] = 1;

            for(int i=1; i<=N; i++){
                for(int k=0; k<=K; k++){
                    if(i==k||k==0)arr[i][k]=1;
                    else arr[i][k]=(arr[i-1][k-1]+arr[i-1][k])%1000000007;
                }
            }
            System.out.println(arr[N][K]);
        }
    }
}