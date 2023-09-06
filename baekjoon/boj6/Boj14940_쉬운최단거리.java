package baekjoon.boj6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14940_쉬운최단거리 {
    static int N, M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    private static class Point{
        int r;
        int c;
        int v;

        public Point(int r, int c, int v) {
            this.r = r;
            this.c = c;
            this.v = v;
        }
    }
    static int[][] map;
    static boolean[][] visit;
    static Point start;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    start = new Point(i, j, 0);
                }
            }
        }
        bfs();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j] && map[i][j] != 0) System.out.print(-1+" ");
                else System.out.print(map[i][j] +" ");
            }
            System.out.println();
        }
    }

    private static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        visit[start.r][start.c] = true;
        map[start.r][start.c] = start.v;
        queue.offer(start);
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc] || map[nr][nc] == 0) continue;

                map[nr][nc] = p.v + 1;
                visit[nr][nc] = true;
                queue.offer(new Point(nr, nc, p.v + 1));
            }
        }
    }
}
