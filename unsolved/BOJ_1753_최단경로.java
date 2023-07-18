package unsolved;

import java.io.*;
import java.util.*;

public class BOJ_1753_최단경로 {
	static int V, E, start;
	static ArrayList<Vertex>[] list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		list = new ArrayList[V+1];
		for (int i = 1; i < list.length; i++) {
			list[i] = new ArrayList<Vertex>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Vertex(end, weight));
		}
		int[] distance = new int[V+1];
		boolean[] visit = new boolean[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
		queue.add(new Vertex(start, 0));
		
		while(!queue.isEmpty()) {
			Vertex node = queue.poll();
			
			if(visit[node.end]) continue;
			visit[node.end] = true;
			
			for (Vertex next : list[node.end]) {
				if(!visit[next.end] && distance[next.end] > distance[node.end] + next.weight ) {
					distance[next.end] = distance[node.end] + next.weight;
					queue.add(new Vertex(next.end, distance[next.end]));
				}
			}
		}
		
//		for (int i = 1; i < list.length-1; i++) {
//			int minIdx = -1;
//			int minVal = Integer.MAX_VALUE;
//			for (int j = 1; j < list.length; j++) {
//				if(!visit[j] && minVal > distance[j]) {
//					minIdx = j;
//					minVal = distance[j];
//				}
//			}
//			if(minIdx == -1) break;
//			visit[minIdx] = true;
//
//			for (Vertex vertex : list[minIdx]) {
//				if(!visit[vertex.end] && distance[vertex.end] > distance[minIdx] + vertex.weight) {
//					distance[vertex.end] = distance[minIdx] + vertex.weight;
//				}
//			}
//		}
		
		for (int i = 1; i < distance.length; i++) {
			System.out.println(distance[i]==Integer.MAX_VALUE?"INF":distance[i]);
		}
	}
	
	private static class Vertex implements Comparable<Vertex>{
		int end, weight;
		public Vertex(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}
