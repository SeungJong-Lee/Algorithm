package baekjoon.boj6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_2606_바이러스 {
	
	public static class Node {
		List<Integer> list;
		public Node() {
			this.list = new ArrayList<>();
		}
	}
	static Node[] node;
	static int Ans = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		node = new Node[V+1];
		for (int i = 1; i <= V; i++) {
			node[i] = new Node();
		}
		for (int i = 0; i < E; i++) {
			StringTokenizer st =  new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			node[s].list.add(e);
			node[e].list.add(s);
		}
		dfs(1, new boolean[V+1]);
		System.out.println(Ans-1);
	}
	private static void dfs(int current, boolean[] v) {
		v[current] = true;
		Ans++;
		for (int next : node[current].list) {
			if(!v[next]) {
				dfs(next, v);
			}
		}
	}

}
