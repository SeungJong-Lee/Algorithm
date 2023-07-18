package study.algorithm;

/*
 * Graph의 DFS, BFS
 * 정점 리스트를 만들고 한 정점에서 모든 정점을 탐색하는 알고리즘
 * 정점이 끊어져 있다면 이동하지 못한다. 때문에 무리의 개수를 구할 때
 * 사용할 수 있다.
 */

import java.io.*;
import java.util.*;

public class Graph_DFS_BFS {

	static int V, E;
	static ArrayList<Integer>[] list;
	static boolean v[];
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./src/study/algorithm/kruskal.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken()); // Vertex의 갯수
		E = Integer.parseInt(st.nextToken()); // Edge의 갯수
		list = new ArrayList[V]; // 시작 정점이 0이기 때문에 V개 , 1부터 이면 V+1 개
		v = new boolean[V];
		for (int i = 0; i < list.length; i++) list[i] = new ArrayList<Integer>();
		for (int i = 0; i < E; i++) {  		  // 정점리스트 생성
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			@SuppressWarnings("unused")
			int w = Integer.parseInt(st.nextToken()); // 입력에 가중치가 있지만 생략
			list[s].add(e);
			list[e].add(s);
		}
		
		for (int i = 0; i < list.length; i++) {
			if(!v[i]) bfs(i);
		}
		System.out.println();
		v = new boolean[V];
		for (int i = 0; i < list.length; i++) {
			if(!v[i]) dfs(i);
//			v = new boolean[V];
//			dfs(i);
//			System.out.println();
		}
	}
	private static void bfs(int index) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(index);
		v[index] = true;
		while(!queue.isEmpty()) {
			int q = queue.poll();
			System.out.print(q+" ");
			for (int next : list[q]) {
				if(!v[next]) {
					v[next] = true;
					queue.offer(next);
				}
			}
		}
	}
	private static void dfs(int index) {
		v[index] = true;
		System.out.print(index+" ");
		for (int next : list[index]) {
			if(!v[next]) {
				v[next] = true;
				dfs(next);
			}
		}
	}
}
