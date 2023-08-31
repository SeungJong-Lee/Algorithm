package swea.swea2;

import java.io.*;
import java.util.*;

public class SWEA_5643_키순서 {
	static int N, M;
	static ArrayList<Integer>[] list;
	static boolean[] v;
	static int[] visit;
	static ArrayList<Integer> addList;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./SeungJong/input/input_swea5643.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			list = new ArrayList[N+1];
			for (int i = 0; i < N+1; i++) {
				list[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				list[start].add(end);
			}
			visit = new int[N+1];
			for (int i = 1; i <= N; i++) {
				addList = new ArrayList<Integer>();
				v = new boolean[N+1];
				if(list[i].size()>0) {
					dfs(i);
					visit[i] += addList.size()-1;
					for (int j = 0; j < addList.size(); j++) {
						if(addList.get(j) != i) {
							visit[addList.get(j)]++;
						}
					}
				}
			}
			int cnt = 0;
			for (int i = 0; i < visit.length; i++) {
				if(visit[i] == N-1) cnt++;
			}
			System.out.println("#"+tc+" "+cnt);
		}
	}
	private static void dfs(int start) {
		v[start] = true;
		addList.add(start);
		for (Integer next : list[start]) {
			if(!v[next]) {
				v[next] = true;
				dfs(next);
			}
		}
	}
}
