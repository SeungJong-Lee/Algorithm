package unsolved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_14226_이모티콘 {

	static int N, Ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dfs(1, 0, 0);
//		bfs();
		System.out.println(Ans);
	}
	



	private static void bfs() {
		Queue<Emoticon> queue = new LinkedList<Emoticon>();
		queue.offer(new Emoticon(1, 0, 0));
		while(!queue.isEmpty()) {
			Emoticon e = queue.poll();
			if(e.window == N) {
				Ans = Math.min(Ans, e.cnt);
				return;
			}
			if(e.window == e.clipboard) queue.offer(new Emoticon(e.window+e.clipboard, e.clipboard, e.cnt+1));
			else {
				if(e.window > N) queue.offer(new Emoticon(e.window-1, e.clipboard, e.cnt+1));
				else {
					if(e.clipboard != 0) queue.offer(new Emoticon(e.window+e.clipboard, e.clipboard, e.cnt+1));
					queue.offer(new Emoticon(e.window, e.window, e.cnt+1));
				}
			}
		}
	}


	public static class Emoticon{
		int window, clipboard, cnt;

		public Emoticon(int window, int clipboard, int cnt) {
			super();
			this.window = window;
			this.clipboard = clipboard;
			this.cnt = cnt;
		}
		
	}
	private static void dfs(int window, int clipboard, int count) {
		if(window == N) {
			Ans = Math.min(Ans, count);
//			System.out.println(window +" "+ clipboard+" " + count);
			return;
		}
		if(window == clipboard) dfs(window+clipboard, clipboard, count+1);
		else {
			if(window > 1 && count+1 < Ans) dfs(window-1, clipboard, count+1);
			if(clipboard != 0) dfs(window+clipboard, clipboard, count+1);
			dfs(window, window, count+1);
		}
		
	}
}
