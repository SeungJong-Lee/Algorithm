package baekjoon.boj6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2503_숫자야구 {
	private static class Num{
		String givenNumber;
		int strike;
		int ball;
		public Num(String givenNumber, int strike, int ball) {
			super();
			this.givenNumber = givenNumber;
			this.strike = strike;
			this.ball = ball;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Num[] inputNumber = new Num[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());
			inputNumber[i] = new Num(str, strike, ball);
		}
		int cntStrike;
		int cntBall;
		int ans = 0;
		for (int i = 123; i <= 987; i++) {
			if(Integer.toString(i).charAt(0)==Integer.toString(i).charAt(1) || 
					Integer.toString(i).charAt(1) == Integer.toString(i).charAt(2) || 
					Integer.toString(i).charAt(0) == Integer.toString(i).charAt(2)) continue;
			if(Integer.toString(i).charAt(0)=='0' || Integer.toString(i).charAt(1)=='0' || Integer.toString(i).charAt(2) =='0') continue;
			boolean flag = true;
			for (int j = 0; j < N; j++) {
				cntStrike = 0;
				cntBall = 0;
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						if(Integer.toString(i).charAt(k) == inputNumber[j].givenNumber.charAt(l)) {
							if(k == l) cntStrike++;
							else cntBall++;
						}
					}
				}
				if(cntStrike != inputNumber[j].strike || cntBall != inputNumber[j].ball) {
					flag = false;
					break;
				}
			}
			if(flag) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}
