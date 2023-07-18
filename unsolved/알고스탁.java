package unsolved;

import java.io.*;
import java.util.*;

public class 알고스탁 {
	static int Ms, Ma, N, L, Ans, benefit;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./SeungJong/input/알고스탁.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			benefit = 0;
			Ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			Ms = Integer.parseInt(st.nextToken());
			Ma = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][L+1];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < L+1; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			solve(Ms, 0);
			System.out.println("#"+tc+" "+Ans);
		}
	}
	private static void solve(int money, int month) {
		if(month == L) {
			int result = money - (Ms  + Ma*L);
			Ans = Math.max(Ans, result);
			return;
		}

		ArrayList<Option> buy = new ArrayList<Option>();
		for (int i = 0; i < N; i++) {
			if(map[i][month] < map[i][month+1]) {
				buy.add(new Option(i, map[i][month+1] - map[i][month]));
			}
		}
		benefit = 0;
		if(buy.size()>0)dfs(money, month, 0, 0, buy);
		money += benefit;
		solve(money+Ma, month+1);
	}
	
	private static void dfs(int money, int month, int index, int profit, ArrayList<Option> buy) {
		if(index == buy.size()) {
			benefit = Math.max(benefit, profit);
			return;
		}
		int idx = buy.get(index).index;
		if(money - map[idx][month] > 0) {
			dfs(money - map[idx][month], month, index, profit+map[idx][month+1]-map[idx][month], buy);
		}
		dfs(money, month, index+1, profit, buy);
	}

	private static class Option{
		int index, profit;

		public Option(int index, int profit) {
			super();
			this.index = index;
			this.profit = profit;
		}

		@Override
		public String toString() {
			return "Option [index=" + index + ", profit=" + profit + "]";
		}
	}
}