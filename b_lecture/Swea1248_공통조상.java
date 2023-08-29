package b_lecture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Swea1248_공통조상 {
	static Node[] node;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			node = new Node[V+1];
			List<Integer> ancestorA = new ArrayList<>();
			List<Integer> ancestorB = new ArrayList<>();
			for (int i = 0; i <= V; i++) {
				node[i] = new Node();
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				node[s].child.add(e);
				node[e].parent = s;
			}
			traverse(A, ancestorA);
			traverse(B, ancestorB);
			int ans = 0;
			for (int i = 0; i < V; i++) {
                if (!ancestorA.get(i).equals(ancestorB.get(i))) break;
                ans = ancestorA.get(i);
            }
			System.out.println("#"+tc+" "+ans+" "+dfs(ans));
		}
	}
	
	private static int dfs(int idx) {
		int res = 1;
		for (int ch : node[idx].child) {
			res += dfs(ch);
		}
		return res;
	}

	private static void traverse(int idx, List<Integer> ancestor) {
		if(node[idx].parent != 0) {
			traverse(node[idx].parent, ancestor);
		}
		ancestor.add(idx);
	}

	static class Node {
		List<Integer> child;
		int parent;
		
		public Node() {
			this.child = new ArrayList<>();
			this.parent = 0;
		}
	}
}
