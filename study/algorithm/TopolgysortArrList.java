package study.algorithm;

import java.io.*;
import java.util.*;

public class TopolgysortArrList {
	static int N, M;
	static ArrayList<Integer>[] adjlist;
	static int[] inDegree;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjlist = new ArrayList[N+1];
		for (int i = 1; i < adjlist.length; i++) {
			adjlist[i] = new ArrayList<Integer>();
		}
		inDegree = new int[N+1];
		int from, to;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			adjlist[from].add(to);
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
			
			for (Integer next : adjlist[cur]) {
				if(--inDegree[next] == 0) {
					queue.offer(next);
				}
			}
			
		}
		return orderList;
	}
}
