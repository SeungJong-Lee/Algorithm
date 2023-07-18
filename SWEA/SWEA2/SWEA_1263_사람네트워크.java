package SWEA.SWEA2;

import java.io.*;
import java.util.*;

public class SWEA_1263_사람네트워크 {
	static int INF = 9999999;
	static int N;
	static int[][] adjList;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./SeungJong/input/input_swea1263.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			adjList = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					adjList[i][j] = Integer.parseInt(st.nextToken());
					if(i != j && adjList[i][j] == 0) adjList[i][j] = INF;
				}
			}
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if(i == k) continue;
					for (int j = 0; j < N; j++) {
						if(i==j || k==j) continue;
						if(adjList[i][j] > adjList[i][k] + adjList[k][j]) {
							adjList[i][j] = adjList[i][k] + adjList[k][j];
						}
					}
				}
			}
			int Ans = Integer.MAX_VALUE;
			for (int[] is : adjList) {
				int sum = 0;
				for (int num : is) {
					sum += num;
				}
				Ans = Math.min(Ans, sum);
			}
			System.out.println("#" + tc + " " +Ans);
		}
	}
}
