package baekjoon.boj6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj11725_트리의부모찾기 {
	private static class Node {
		List<Integer> list;
		public Node() {
			list = new ArrayList<>();
		}
	}
	static Node[] node;
	static int[] parents;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		node = new Node[N+1];
		parents = new int[N+1];
		for (int i = 1; i <= N; i++) {
			node[i] = new Node();
		}
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			node[s].list.add(e);
			node[e].list.add(s);
		}
		dfs(1, new boolean[N+1]);
		for (int i = 2; i < N+1; i++) {
			System.out.println(parents[i]);
		}
	}

	private static void dfs(int index, boolean[] v) {
		v[index] = true;
		for (int next : node[index].list) {
			if(!v[next]) {
				parents[next] = index;
				dfs(next, v);
			}
		}
	}
}
