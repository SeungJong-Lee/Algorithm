package study.algorithm;

/*
 * MST(Minimum Spanning Tree) 알고리즘 중 하나로
 * 간선 기준의 알고리즘이다. union-find를 사용하여 구현한다.
 * 간선 리스트이기 때문에 간선에 시작정점, 끝 정점, 가중치가 들어간다.
 * MST를 만들어서 가중치의 합을 구한다.
 */

import java.io.*;
import java.util.*;

public class Kruskal {

	static int V, E;
	static ArrayList<Edge> edge = new ArrayList<Edge>();
	static int[] parents;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./src/study/algorithm/kruskal.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken()); // Vertex의 갯수
		E = Integer.parseInt(st.nextToken()); // Edge의 갯수
		for (int i = 0; i < E; i++) {  		  // 간선리스트 생성
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edge.add(new Edge(s, e, w));
		}
		parents = new int[V]; 	// Make-Set
		for (int i = 0; i < V; i++) parents[i] = i;
		
		Collections.sort(edge);	// 리스트를 가중치가 작은 순으로 정렬
		
		int sum = 0, cnt = 0;
		for (int i = 0; i < edge.size(); i++) {
			int start = edge.get(i).start; // 시작정점
			int end = edge.get(i).end;	   // 도착정점
			if(find(start) == find(end)) continue; // 같은 부모를 갖는다면 -> 순환이 된다.
			cnt++;
			union(start, end);
			sum += edge.get(i).weight;	// 최소 신장트리의 합을 구한다
			if(cnt == V-1) break; // E = V -1 이므로 모든 간선이 연결되었다는 뜻
		}
		
		System.out.println(sum);
		System.out.println(Arrays.toString(parents));
	}
	
	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa != pb) parents[pa] = pb;
		
	}

	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}

	private static class Edge implements Comparable<Edge>{
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}

}
