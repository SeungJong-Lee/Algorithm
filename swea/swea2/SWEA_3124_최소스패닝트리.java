package swea.swea2;

import java.io.*;
import java.util.*;

public class SWEA_3124_최소스패닝트리 {

	static int V, E;
	static Edge[] edge;
	static int[] parents;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			edge = new Edge[E];
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edge[i] = new Edge(start, end, weight);
			}
			parents = new int[V+1];
			for (int i = 1; i <= V; i++) {
				parents[i] = i;
			}
			
			long sum = 0, count = 0;
			Arrays.sort(edge);
			for (int i = 0; i < edge.length; i++) {
				int s = edge[i].s;
				int e = edge[i].e;
				if(find(s) != find(e)) {
					count++;
					sum += edge[i].w;
					union(s, e);					
					if(count == V-1) break;
				}
			}
			System.out.println("#"+tc+" "+sum);
			
		}
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
		int s, e, w;
		public Edge(int s, int e, int w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
}
