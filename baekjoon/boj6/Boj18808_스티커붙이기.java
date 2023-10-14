package baekjoon.boj6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj18808_스티커붙이기 {
    static int N, M, K, ANS;
    static int[][] map;
    static int[][] sticker;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            sticker = new int[r][c];
            for (int i = 0; i < r; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < c; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < 4; i++) {
                if (solve(sticker, r, c)) break;
                else {
                	rotation(r, c);
                	int tmp = r;
                	r = c;
                	c = tmp;
                }
            }
        }
        System.out.println(ANS);
    }

    private static boolean solve(int[][] sticker,  int r, int c) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i + r > N) continue;
                if (j + c > M) continue;
                if (check(i, j, sticker, r, c)) {
                    attach(i, j, sticker, r, c);
                    return true;
                }
            }
        }
        return false;
    }

    private static void attach(int row, int col, int[][] sticker, int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (sticker[i][j] == 1) {
                    map[row+i][col+j] = sticker[i][j];
                    ANS++;
                }
            }
        }
    }

    private static boolean check(int row, int col, int[][] sticker, int r, int c) {
    	for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if ((map[row+i][col+j] & sticker[i][j]) == 1) return false;
            }
        }
        return true;
    }
    
    private static void rotation(int r, int c) {
    	int[][] temp = new int[r][c];
        for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				temp[i][j] = sticker[i][j];
			}
		}
        sticker = new int[c][r];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                sticker[i][j] = temp[r - 1 - j][i];
            }
        }
    }
}