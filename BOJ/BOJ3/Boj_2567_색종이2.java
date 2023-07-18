package BOJ.BOJ3;

import java.io.*;
import java.util.*;


public class Boj_2567_색종이2 {
	
	static int N;
	static int[][] map = new int[101][101];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int count = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			
			for (int j = r; j < r+10; j++) {  // map그리기
				for (int k = c; k < c+10; k++) {
					map[j][k] = 1;
				}
			}
			
		}
		
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if(map[i][j] == 0) {
					count += aa(i, j);  // 1인 좌표 4방 탐색 시 외각자리이거나 주위에 0이 있다면 카운트 증가
				}
			}
		}
		System.out.println(count);
	}

	
	private static int aa(int r, int c) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr < 0 || nc < 0 || nr > 100 || nc > 100) continue;
			if(map[nr][nc] == 1) {
				count++;; // 주위에 0이 있다면 1리턴
			}
		}
		return count; // 외곽이나 0이 없다면 0리턴
	}

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

}
