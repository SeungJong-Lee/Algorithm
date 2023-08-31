package baekjoon.boj6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_1337_올바른배열 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(list);
		int ans = 0;
		for (int i = 0; i < N; i++) {
			int count = 0;
			for (int j = list.get(i); j < list.get(i)+5; j++) {
				if(list.contains(j)) count++;
			}
			ans = Integer.max(count, ans);
		}
		System.out.println(5-ans);
	}
}
