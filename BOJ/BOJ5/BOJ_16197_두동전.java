package BOJ.BOJ5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16197_두동전 {
    static int N, M;
    static char[][] map;
    static boolean[][][][] v;
    static Queue<Point> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        v = new boolean[N][M][N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'o') {
                    queue.offer(new Point(i, j, 0));
                }
            }
        }
        bfs();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Point p1 = queue.poll();
            Point p2 = queue.poll();

            if(p1.cnt >= 10) {
                System.out.println(-1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr1 = p1.r + dr[i];
                int nc1 = p1.c + dc[i];
                int nr2 = p2.r + dr[i];
                int nc2 = p2.c + dc[i];

                int check = 0;

                if(nr1<0 || nc1<0 || nr1>=N || nc1>=M) check++;
                if(nr2<0 || nc2<0 || nr2>=N || nc2>=M) check++;

                if(check == 1) {
                    System.out.println(p1.cnt + 1);
                    return;
                }

                // 둘 다 떨어지면 의미 없는 행동
                if(check == 2) continue;

                // 둘다 벽에 막혀서 못가면 의미가 없는 행동
                if(map[nr1][nc1] == '#' && map[nr2][nc2] == '#') continue;

                if(!v[nr1][nc1][nr2][nc2]) {
                    // 2번째 동전만 이동 가능할 때
                    // 1번째 동전은 원래 자리에 있어야 한다.
                    if(map[nr1][nc1] == '#' && map[nr2][nc2] != '#') {
                        nr1 = p1.r;
                        nc1 = p1.c;
                    }

                    // 1번째 동전만 이동 가능할 때
                    // 2번째 동전은 원래 자리에 있어야 한다.
                    else if(map[nr2][nc2] == '#' && map[nr1][nc1] != '#') {
                        nr2 = p2.r;
                        nc2 = p2.c;
                    }
                    v[nr1][nc1][nr2][nc2] = true;
                    queue.offer(new Point(nr1, nc1, p1.cnt + 1));
                    queue.offer(new Point(nr2, nc2, p2.cnt + 1));
                }
            }
        }
        System.out.println(-1);
    }

    static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "r=" + r +
                    ", c=" + c +
                    ", cnt=" + cnt +
                    '}';
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
}
