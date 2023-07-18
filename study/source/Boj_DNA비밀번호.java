package study.source;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Boj_DNA비밀번호 {
	
	static int Ans = 0;
	static int N, M;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		String str = sc.next();
		arr = new int[4];
		for (int i = 0; i < 4; i++) {
			arr[i] = sc.nextInt();
		}
		HashMap<Character, Integer> hs = new HashMap<>();
		hs.put('A', 0);
		hs.put('C', 0);
		hs.put('G', 0);
		hs.put('T', 0);
		
		for (int i = 0; i < M; i++) {
			hs.put(str.charAt(i), hs.get(str.charAt(i))+1);
		}
		Set<Character> keys = hs.keySet();
//		for (Character key : keys) {
//			System.out.println(hs.get(key));
//		}
		if(check(hs)) Ans++;
		
		// 슬라이딩 윈도우
		for (int i = 1; i+M-1 < N; i++) {
			char del = str.charAt(i-1);
			char add = str.charAt(i+M-1);
			
			// 지나간 문자
			hs.put(del, hs.get(del)-1);
			// 새로 들어올 문자
			hs.put(add, hs.get(add)+1);
			if(check(hs)) Ans++;
		}
		System.out.println(Ans);
	}
	
	// 조건에 맞는지 확인
	private static boolean check(HashMap<Character, Integer> hs) {
		for (Character key : hs.keySet()) {
			if(key == 'A') {
				if(hs.get('A') < arr[0]) return false;
			}
			if(key == 'C') {
				if(hs.get('C') < arr[1]) return false;
			}
			if(key == 'G') {
				if(hs.get('G') < arr[2]) return false;
			}
			if(key == 'T') {
				if(hs.get('T') < arr[3]) return false;
			}
		}
		return true;
	}
}
