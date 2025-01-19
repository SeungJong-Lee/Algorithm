package year2025.baekjoon;

import java.io.*;
import java.util.*;

public class S2_17086_아기상어2 {
    static int N, M, Ans;
    static int[][] map;
    static boolean[][] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    v = new boolean[N][M];
                    bfs(i, j);
                }
            }
        }
        System.out.println(Ans);
    }
    private static void bfs(int row, int col) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(row, col, 0));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            v[p.r][p.c] = true;
            for (int i = 0; i < 8; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (nr<0 || nc<0 || nr>=N || nc>=M || v[nr][nc]) continue;
                if (map[nr][nc] == 1) {
                    Ans = Integer.max(Ans, p.w + 1);
                    return;
                } else {
                    v[nr][nc] = true;
                    queue.offer(new Point(nr, nc, p.w + 1));
                }
            }
        }
    }

    private static class Point{
        int r, c, w;
        Point(int r, int c, int w){
            this.r = r;
            this.c = c;
            this.w = w;
        }
    }

    private static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
}
