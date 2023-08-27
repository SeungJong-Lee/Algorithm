package b_lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pb_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int checkValue = (1 << 10) - 1; // 0 ~ 9 까지의 모든 수 확인
		for (int i = 1; i <= T; i++) {
			int num = Integer.parseInt(br.readLine());
			int visited = 0;
			int count = 0;
			for(count = 1;; count++) {
				char[] arr = String.valueOf(num * count).toCharArray();
				for (char c : arr) {
					int n = c - '0';
					visited |= (1 << n);
				}
				if(visited == checkValue) break;
			}
			System.out.println("#" + i +" "+num*count);
		}
	}
}
