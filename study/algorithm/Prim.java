package study.algorithm;

/*
 * MST(Minimum Spanning Tree) 알고리즘 중 하나로
 * 정점 기준 알고리즘이다. 정점 리스트와 Priority Queue를 사용하여 Prim 알고리즘을 구현한다.
 * 정점 리스트이기 때문에 ArrayList<Node>[시작 정점] 의 형식으로 사용한다.
 * 따라서 Node에는 도착정점과 가중치가 들어간다. 
 * MST를 만들어서 가중치의 합을 구한다.
 */

import java.io.*;
import java.util.*;

public class Prim {

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
		int sum = 0;											// 자동으로 정렬이 되는 효과를 볼 수 있다.
		while(!queue.isEmpty()) {
			Node node = queue.poll();							
			if(!v[node.end]) {
				v[node.end] = true;
				sum += node.weight;
				for (Node next : list[node.end]) {	//node.end를 시작점으로 하는 정점들	// 해당 노드에서 연결된 노드들 모두 탐색
					if(!v[next.end] && dist[next.end] > next.weight) {	// 더 가중치가 작은 노드를 queue에 넣는다.
						dist[next.end] = next.weight;					// 우선순위 큐이기 때문에 queue에 넣은것 중에서
						queue.offer(next);								// 가중치가 가장 작은 노드가 먼저 나올것이다.
					}
				}
			}
		}
		System.out.println(Arrays.toString(dist));
		System.out.println(sum);
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
