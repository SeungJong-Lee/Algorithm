package study.algorithm;

import java.io.*;
import java.util.*;

public class Topolgysort {
	static int N, M;
	static class Node{
		int vertes;
		Node link;
		public Node(int vertes, Node link) {
			super();
			this.vertes = vertes;
			this.link = link;
		}
	}
	static Node[] adjlist;
	static int[] inDegree;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjlist = new Node[N+1];
		inDegree = new int[N+1];
		int from, to;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			adjlist[from] = new Node(to, adjlist[from]);
			inDegree[to]++;
		}
		ArrayList<Integer> list = topologySort();
		if(list.size() == N) {
			for (Integer vertex : list) {
				System.out.print(vertex+" ");
			}
			System.out.println();
		} else System.out.println("cycle");
	}
	static ArrayList<Integer> topologySort() {
		ArrayList<Integer> orderList = new ArrayList<Integer>();
		Queue<Integer> queue =new ArrayDeque<Integer>();
		for (int i = 1; i <= N; i++) {
			if(inDegree[i] == 0) queue.offer(i);
		}
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			orderList.add(cur);
			
			for(Node temp = adjlist[cur]; temp != null; temp = temp.link) {
				if(--inDegree[temp.vertes] == 0) {
					queue.offer(temp.vertes);
				}
			}
		}
		return orderList;
	}
}
