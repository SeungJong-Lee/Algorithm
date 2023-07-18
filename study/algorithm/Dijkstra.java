package study.algorithm;

/*
 * 최단거리 구하기 알고리즘
 * 가중치가 있을 때 사용한다. (양의 가중치)
 */

import java.io.*;
import java.util.*;

public class Dijkstra {

	static int V, E;
	static ArrayList<Node>[] list;
	static int[] dist;
	static boolean v[];
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./src/study/algorithm/kruskal.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken()); // Vertex의 갯수
		E = Integer.parseInt(st.nextToken()); // Edge의 갯수
		list = new ArrayList[V]; // 시작 정점이 0이기 때문에 V개 , 1부터 이면 V+1 개
		dist = new int[V];
		v = new boolean[V];
		for (int i = 0; i < list.length; i++) list[i] = new ArrayList<Node>();
		for (int i = 0; i < E; i++) {  		  // 정점리스트 생성
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[s].add(new Node(e, w));   // 가중치가 있는 무향 그래프
			list[e].add(new Node(s, w));
		}
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0; // 임의의 시작정점 0
		PriorityQueue<Node> queue = new PriorityQueue<Node>();  // 가중치가 작은 순으로 정렬되고 반복문에서
		queue.offer(new Node(0, 0));							// 방문배열을 통해 중복을 방지하기 때문에
		while(!queue.isEmpty()) {								// 자동으로 정렬이 되는 효과를 가져올 수 있다
			Node node = queue.poll();							
			if(!v[node.end]) {
				v[node.end] = true;
				for (Node next : list[node.end]) {	//node.end를 시작점으로 하는 정점들	 해당 노드에서 연결된 노드들 모두 탐색
					if(!v[next.end] && dist[next.end] > dist[node.end] + next.weight) {	// 다음으로 갈 곳의 dist의 값과 현재까지의 dist합 + 가중치를 비교
						dist[next.end] = dist[node.end] + next.weight;					// 비교를 통해 더 작은 것을 dist에 저장
						queue.offer(new Node(next.end, dist[next.end]));				// queue에 넣을 때 누적된 dist를 넣어야 하기 때문에 새로 Node를 생성한다.
					}
				}
			}
		}
		System.out.println(dist[V-1]);
		System.out.println(Arrays.toString(dist));
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

}
