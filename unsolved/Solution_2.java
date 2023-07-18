package unsolved;

/*
 * 3번 포를 움직였을 때 잡을 수 있는 장기 말의 수
 * solve(횟수, 잡는 장기말의 수)
 * if(횟수 == 3) return;
 * 잡을 때 마다 map을 업데이트 하고 돌아오면서 기존 map으로 바꿔줘야 한다.
 * 사방탐색을 해서 가장 먼저 잡히는 1은 패스하고 (flag생성)
 * 이후 0의 위치에서 횟수를 증가하여 탐색, 알이 있을 경우 그 뒤로는 갈 수 없다.
 */

import java.io.*;
import java.util.*;

public class Solution_2 {
	static int N, Ans;
	static int[][] map;
	static Point po;
	static ArrayList<Point> set;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./SeungJong/input/Solution_2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			set = new ArrayList<Point>();
			Ans = 0;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 2) {
						// 시작 지점 위치만 기억하고 map에는 빈칸으로 생성
						map[i][j] = 0;
						po = new Point(i, j, false);
					}
				}
			}
			// 초기 방향을 4방향을 주고 탐색 시작!
			solve(0, 0, 0, po);
			System.out.println("#"+tc+" "+Ans);
		}
	}
	
	private static void solve(int jump, int cnt, int dir, Point po) {
		if(jump == 4) {
			return;
		}
		// 만약 flag가 true인 상태로 왔다면 알 하나를 뛰어 넘었다는 소리.
		// 같은 방향으로 다음 알이 나오지 않는다면 계속해서 해당 칸에서 탐색을 해봐야함
		// repeat가 아직 3이 되지 않았으면 다음으로 뛰어넘는 말을 찾아야함
		// dir = 상, 하, 좌, 우 순서
		boolean flag = po.flag;
		if(!flag) { // flag가 false라면 다음 알을 찾아야 한다.
			for (int i = 0; i < 4; i++) {
				Point temp = find(po.r, po.c, i); // 현재 장기 말 위치에서
									//한 방향으로 탐색하며 다음 알을 찾는다.
				if(temp != null) { // 만약 넘어간 위치가 괜찮은 위치라면
					solve(jump+1, cnt, i, temp); // flag = true;
				}
				
			}
		}else { // 한번 뛰어 넘었다면 같은 방향에서 알이 나오기 전까지 다시 한번 find
			int nr = po.r;		// 넘어 가서도 
			int nc = po.c;
			if(map[nr][nc] == 1) { // 넘어온 위치에 알이 있다면 1추가하고 그 위치에서 또 다른 지역 찾는다
				boolean bk = false;
				for (int i = 0; i < set.size(); i++) {
					if(set.get(i).r == nr && set.get(i).c == nc) {
						bk = true;
						break;
					}
				}
				if(!bk) {
					set.add(new Point(nr, nc, false));
					Ans++;
				}
				map[nr][nc] = 0;
				solve(jump, cnt+1, dir, new Point(nr, nc, false));
				map[nr][nc] = 1;
			} else { // 넘어온 위치에 알이 없다면 빈 공간에서도 다음 곳으로 점프 할 수 있는지 탐색
				while(true) {
					if(nr < 0 || nc < 0 || nr >= N || nc >= N) break;
					if(map[nr][nc] == 1) {
						boolean bk = false;
						for (int i = 0; i < set.size(); i++) {
							if(set.get(i).r == nr && set.get(i).c == nc) {
								bk = true;
								break;
							}
						}
						if(!bk) {
							set.add(new Point(nr, nc, false));
							Ans++;
						}
						map[nr][nc] = 0;
						solve(jump, cnt, dir, new Point(nr, nc, false));
						map[nr][nc] = 1;
						break;
					}
					solve(jump, cnt, dir, new Point(nr, nc, false));
					nr += dr[dir];
					nc += dc[dir];
					// 범위를 벗어나지 않는다면 현재 위치에서 새로운 탐색
				}
			}
		}
		
	}
	private static Point find(int r, int c, int dir) {
	
		// 현재 위치에서 계속해서 한 방향으로 진행 했을 때 범위를 벗어나지 않고
		// 알을 찾는 다음, 그 다음 위치가 범위 안에 있다면 
		// flag를 true로 한 다음 재귀
		int nr = r;
		int nc = c;
		while(true) {
			nr += dr[dir];
			nc += dc[dir];
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) return null;
			if(map[nr][nc] == 1) {
				int nextNr = nr + dr[dir];
				int nextNc = nc + dc[dir];
				if(nextNr < 0 || nextNc < 0 || nextNr >= N || nextNc >= N) return null;
				return new Point(nextNr, nextNc, true);
			}
		}
	}

	private static class Point{
		int r, c;
		boolean flag;
		public Point(int r, int c, boolean flag) {
			super();
			this.r = r;
			this.c = c;
			this.flag = flag;
		}
		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", flag=" + flag + "]";
		}
	}

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
}
