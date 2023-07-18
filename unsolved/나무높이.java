package unsolved;

import java.io.*;
import java.util.*;

// 1. 처음에 키가 가장 큰 나무를 찾는다
// 2. 가장 큰 나무를 제외한 다른 나무들을 /2, %2 한다
// 3. 홀수 부분이 0이 되면 짝수에 있는 것을 홀수로 가지고 온다
// 4. 단, 짝수가 1일 시 날짜의 홀짝을 따져서 계산한다

public class 나무높이 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("./SeungJong/input/나무높이.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());

			int[] heights = new int[N];
			int[] diffHeights = new int[N];

			int max = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, heights[i]);
			}

			int sum = 0; // max 높이 나무만큼 커야하는 나무 키의 합
			for (int i = 0; i < N; i++) {
				diffHeights[i] = max - heights[i];
				sum += diffHeights[i];
			}

			int ans = sum / 3 * 2; // 홀(1),짝(2) = 1+2 , 홀/짝 꽉 채워 물을 주는 최소 일수

			if (sum % 3 == 1)
				ans++; // 홀/짝 꽉 채워주고 1만큼 키를 더 키운다면 하루 더 필요함
			else if (sum % 3 == 2)
				ans += 2;// 홀/짝 꽉 채워주고 2만큼 키를 더 키운다면 이틀 더 필요함

			int evenDay = 0; // 실제 키와 비교하여 2씩 물을 줄수 있는 필요 짝수 일수 계산
			for (int h : diffHeights)
				evenDay += h / 2;

			// 실제 2씩 물을 주어야하는 필요 짝수 일수로 홀/짝 꽉 채워 키운 키의 합보다 모든 나무의 커야하는 키가 크다면
			// 실제 2씩 물을 주어야하는 필요 짝수 일수로 홀/짝 꽉 채운 필요 최소 일수 다시 세팅
			if (sum > evenDay * 3)
				ans = evenDay * 2;

			int remain = sum - evenDay * 3; // 필요한 짝수일의 개수를 이용해 홀/짝 꽉 채우고 나눈 나머지(즉,커야하는 남은키가 1씩 남은 경우임)

			// 남은 1씩 커야하는 나머지 키로 필요한 홀수일수 계산
			if (remain > 0)
				ans += remain * 2 - 1;

			System.out.println("#" + tc + " " + ans);
		}
	}
}