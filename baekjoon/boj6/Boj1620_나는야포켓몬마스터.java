package baekjoon.boj6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj1620_나는야포켓몬마스터 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<Integer, String> map = new HashMap<>();
		HashMap<String, Integer> map2 = new HashMap<>();
 		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			map.put(i, str);
			map2.put(str, i);
		}
		for (int i = 0; i < M; i++) {
			String check = br.readLine();
			if(check.charAt(0)-'0' >= 1 && check.charAt(0)-'0' <= 9) {
				System.out.println(map.get(Integer.parseInt(check)));
			}
			else {
				System.out.println(map2.get(check));
			}
		}
	}
}
