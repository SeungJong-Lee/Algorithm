package swea.swea2;

import java.io.*;
import java.util.*;

public class SWEA_1238_Contact {
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static int E, start, Ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			Ans = 0;
			visit = new boolean[101];
			list = new ArrayList[101];
			for (int i = 1; i < 101; i++) {
				list[i] = new ArrayList<Integer>();
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			E = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
			}
			bfs(start, 0);
			System.out.println("#"+tc+" "+Ans);
		}
	}
	private static void bfs(int idx, int level) {
		Queue<Vertex> queue = new LinkedList<Vertex>();
		ArrayList<Vertex> lastPerson = new ArrayList<Vertex>();
		int maxIndex = -1;
		visit[idx] = true;
		queue.offer(new Vertex(idx, level));
		while(!queue.isEmpty()) {
			Vertex cur = queue.poll();
			if(cur.level > maxIndex) {
				maxIndex = cur.level;
				lastPerson.clear();
				lastPerson.add(cur);
			}
			else if(cur.level == maxIndex) {
				lastPerson.add(cur);
			}
			for (int vertex : list[cur.to]) {
				if(!visit[vertex]) {
					queue.offer(new Vertex(vertex, cur.level+1));
					visit[vertex] = true;
				}
			}
		}
		for (int i = 0; i < lastPerson.size(); i++) {
			Ans = Math.max(Ans, lastPerson.get(i).to);
		}
	}
	
	private static class Vertex {
		int to, level;
		public Vertex(int to, int level) {
			super();
			this.to = to;
			this.level = level;
		}
		@Override
		public String toString() {
			return "Vertex [to=" + to + ", level=" + level + "]";
		}
	}
}
