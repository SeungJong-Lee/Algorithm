package year2025.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_1734_음식물피하기 {
    static int N;
    static int M;
    static int K;
    static int[][] map;
    static boolean[][] v;
    static int Sum;
    static int Ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        v = new boolean[N+1][M+1];
        Ans = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 1 && !v[i][j]) {
                    Sum = 1;
                    bfs(i, j);
                    Ans = Integer.max(Ans, Sum);
                }
            }
        }

        System.out.println(Ans);
    }

    static private void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int pr = cur[0];
            int pc = cur[1];
            v[pr][pc] = true;
            for (int i = 0; i < 4; i++) {
                int nr = pr + dr[i];
                int nc = pc + dc[i];
                if (nr < 1 || nc < 1 || nr >= N+1 || nc >= M+1 || v[nr][nc] || map[nr][nc] == 0) continue;
                v[nr][nc] = true;
                Sum++;
                q.offer(new int[]{nr, nc});

            }
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
}
