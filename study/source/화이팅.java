package study.source;
import java.util.*;
import java.io.*;
public class 화이팅 {
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R= Integer.parseInt(st.nextToken());
		//배열 A
		int[][] arr = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//R번 회전시킴
	
		
		int square = Math.min(N, M)/2;
		
		for (int i = 0; i < R; i++) {
			
			for(int cnt=0;cnt<square;cnt++) {
				int temp = arr[cnt][cnt];
				int startx = cnt;
				int starty = cnt;
				int dirr = 0;
				while(dirr!=4) {
					
					arr[startx][starty]= arr[startx+dir[dirr][0]][starty+dir[dirr][1]];
					startx = startx+dir[dirr][0];
					starty = starty+dir[dirr][1];
					if(starty >= M - cnt -1 && dirr == 0) {
						dirr++;
					}
					else if(startx >= N - cnt -1 && dirr == 1) {
						dirr++;
					}
					else if(starty <= cnt && dirr == 2) {
						dirr++;
					}
					else if(startx <= cnt && dirr == 3) {
						dirr++;
					}	
				}
				arr[cnt+1][cnt] = temp;
			}
		}
		print(arr, N, M);
		
		
	}
	private static void print(int[][] arr, int n, int m) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
