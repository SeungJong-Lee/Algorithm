package SWEA.SWEA2;

import java.io.*;
import java.util.*;

public class 산악구조로봇2 {
	static int N, Ans;
	static Point[][] map;
	static ArrayList<Node>[] list;
	static boolean[] v;
	static int[] dist;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./SeungJong/input/산악구조로봇.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			Ans = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			map = new Point[N][N];
			list = new ArrayList[N*N];
			for (int i = 0; i < list.length; i++) {
				list[i] = new ArrayList<Node>();
			}
			int index = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = new Point(index++, Integer.parseInt(st.nextToken()));
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
						if(map[i][j].val > map[nr][nc].val) {
							list[map[i][j].index].add(new Node(map[nr][nc].index, 0));
						}
						else if(map[i][j].val == map[nr][nc].val) {
							list[map[i][j].index].add(new Node(map[nr][nc].index, 1));
						}
						else if(map[i][j].val < map[nr][nc].val) {
							list[map[i][j].index].add(new Node(map[nr][nc].index, (map[nr][nc].val-map[i][j].val)*2));
						}
					}
				}
			}
			dist = new int[N*N];
			v = new boolean[N*N];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[0] = 0;
			PriorityQueue<Node> queue = new PriorityQueue<Node>();
			queue.add(new Node(0, 0));
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				if(v[node.end]) continue;
				v[node.end] = true;
				
				for (Node next : list[node.end]) {
					if(!v[next.end] && dist[next.end] > dist[node.end] + next.weight) {
						dist[next.end] = dist[node.end] + next.weight;
						queue.add(new Node(next.end, dist[next.end]));
					}
				}
			}
			System.out.println("#"+tc+" "+dist[index-1]);
		}
	}
	
	private static class Node implements Comparable<Node>{
		int end, weight;
		public Node(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	private static class Point{
		int index, val;
		public Point(int index, int val) {
			super();
			this.index = index;
			this.val = val;
		}
	}


	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
}
