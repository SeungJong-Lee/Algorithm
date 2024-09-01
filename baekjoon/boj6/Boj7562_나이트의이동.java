package baekjoon.boj6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7562_나이트의이동 {
    static int N, Ans, T;
    static int[][] map;
    static boolean[][] v;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T ; tc++) {
            Ans = 0;
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            v = new boolean[N][N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            st = new StringTokenizer(br.readLine());
            Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            bfs(start, end);
            System.out.println(Ans);
        }
    }

    private static void bfs(Point s, Point e) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(s);
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            v[p.r][p.c] = true;

            for (int i = 0; i < 8; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N || v[nr][nc] == true) continue;
                v[nr][nc] = true;
                if (nr == e.r && nc == e.c) {
                    Ans = p.val + 1;
                    break;
                }
                else {
                    queue.offer(new Point(nr, nc, p.val + 1));
                }
            }
        }
    }

    private static class Point {
        int r;
        int c;
        int val;

        Point(int r, int c, int val) {
            super();
            this.r = r;
            this.c = c;
            this.val = val;
        }
    }

    private static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};
}
