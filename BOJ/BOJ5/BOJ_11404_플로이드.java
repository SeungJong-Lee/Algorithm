package BOJ.BOJ5;

import java.io.*;
import java.util.*;

public class BOJ_11404_플로이드 {
	static final int INF = 9999999;
	static int N;
	static int[][] adjMatrix;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		adjMatrix = new int[N][N];
		int edge = Integer.parseInt(br.readLine());
		for (int i = 0; i < edge; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			if(adjMatrix[start][end] != 0) adjMatrix[start][end] = Math.min(adjMatrix[start][end], weight);
			else adjMatrix[start][end] = weight;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i==j) continue;
				if(adjMatrix[i][j] == 0) adjMatrix[i][j] = INF;
			}
		}
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if(i == k) continue;
				for (int j = 0; j < N; j++) {
					if(i==j || k==j) continue;
					if(adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j])
						adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(adjMatrix[i][j] == INF) System.out.print("0 ");
				else System.out.print(adjMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}
