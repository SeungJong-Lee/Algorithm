/*
 * 새로운 문자가 나올때마다 저장
 * 그 개수만큼 순열 돌려서 매칭 시 가장 큰 수 저장
 * 완탐으로 하니 시간초과
 * 시간을 줄이거나 그리디 기법으로 풀어보자
 */

package unsolved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BOJ_1339_단어수학 {

	static int Ans, N;
	static String[] arr;
	static Set<Character> set = new LinkedHashSet<Character>();
	static List<Character> list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new String[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = br.readLine();
			for (int j = 0; j < arr[i].length(); j++) {
				set.add(arr[i].charAt(j));
			}
		}
		list = new ArrayList<>(set);
		permutation(new int[set.size()], 0, 0);
		System.out.println(Ans);
		
	}
	private static void permutation(int[] sel, int k, int flag) {
		if( k == sel.length) {
			String temp[] = new String[N];
			for (int i = 0; i < temp.length; i++) {
				temp[i] = arr[i];
			}
			for (int i = 0; i < sel.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					temp[j] = temp[j].replace(list.get(i), Integer.toString(sel[i]).charAt(0) );
				}
			}
			int str = 0;
			for (int i = 0; i < temp.length; i++) {
				str += Integer.parseInt(temp[i]);
			}
			Ans = Integer.max(str, Ans);
			return;
		}
		for (int i = 9; i >= 10 - sel.length; i--) {
			if( (flag & (1<<i)) > 0) continue;
			sel[k] = i;
			permutation(sel, k+1, flag | (1<<i));
		}
	}

}
