package b_lecture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pb_2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int i = 1; i <= TC; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int check = (1<<N) -1; // N개 자리 1로 셋하여 맨 뒤 N개가 모두 1인지 확인하는 마스킹 비트
			// &연산하여 마스킹 비트와 같다면 ON 다르다면 OFF
			System.out.println((M & check) == check ? "#"+i+" ON":"#"+i+" OFF");
		}
	}
}
