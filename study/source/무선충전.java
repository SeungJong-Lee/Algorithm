package study.source;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 무선충전 {
	static int T,Ans=Integer.MIN_VALUE;
	static class Charger implements Comparable<Charger>{
		int r,c,cover,power;

		public Charger(int r, int c, int cover, int power) {
			super();
			this.r = r;
			this.c = c;
			this.cover = cover;
			this.power = power;
			
			
		}

		@Override
		public String toString() {
			return "Charger [r=" + r + ", c=" + c + ", cover=" + cover + ", power=" + power + "]";
		}

		@Override
		public int compareTo(Charger o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.power, o.power);
		}
	}
	static int dr[] = {0,-1,0,1,0};
	static int dc[] = {0,0,1,0,-1};
	
	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("무선충전.txt"));
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			int M = sc.nextInt();
			int A = sc.nextInt();
			int[][] person = new int[2][M];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < M; j++) {
					person[i][j]=sc.nextInt();
				}
			}
			
//			for (int i = 0; i < 2; i++) {
//				System.out.println(Arrays.toString(person[i]));
//			}
			Charger[] charger = new Charger[A];
			for (int i = 0; i < A; i++) {
				int c = sc.nextInt();
				int r = sc.nextInt();
				charger[i]=new Charger(r, c, sc.nextInt(), sc.nextInt());
			}
			
			//System.out.println(Arrays.toString(charger));
			
			int personA_r = 1;
			int personA_c = 1;
			int personB_r = 10;
			int personB_c = 10;
			Ans=0;
			
			// personA and personB will go
			//
			for (int i = 0; i <= M; i++) {
				// A person 의 위치에서 가능한 충전기를 찾습니다
				List<Charger> chargerA =  getCharger(personA_r,personA_c,charger);
				// B person 의 위치에서 가능한 충전기를 찾습니다
				List<Charger> chargerB =  getCharger(personB_r,personB_c,charger);
				//System.out.println(chargerB);
				// 가능한 충전기중에 power가 젤 좋은 놈을 찾는다
				
				// A 만 충전가능
				if(chargerA.size()!=0 && chargerB.size()==0) {
					Ans += Collections.max(chargerA).power;
				}
				// B 만 충전가능
				if(chargerA.size()==0 && chargerB.size()!=0) {
					Ans += Collections.max(chargerB).power;
				}
				// 둘다 가능하다면 모든경우의 수에 대하여 충전량을 구해서 최대값을 찾는다
				if(chargerA.size()!=0 && chargerB.size()!=0) {
					int max = 0;
					
					
					for (int j = 0; j < chargerA.size(); j++) {
						for (int k = 0; k < chargerB.size(); k++) {
							int tmp = chargerA.get(j).power + chargerB.get(k).power;
							if(chargerA.get(j) == chargerB.get(k)) {
								tmp /= 2;
							}
							max = Math.max(max, tmp);
						}
					}
					Ans += max;
				}
				
				if(i==M) break;
				
				// 퍼슨에이와 퍼슨비의 이동
				personA_r += dr[person[0][i]];
				personA_c += dc[person[0][i]];
				personB_r += dr[person[1][i]];
				personB_c += dc[person[1][i]];
			}
			System.out.printf("#%d %d\n",tc,Ans);
		}
		
	}

	private static List<Charger> getCharger(int r, int c, Charger[] charger) {
		ArrayList<Charger> list = new ArrayList<>();
		// D = |XA – XB| + |YA – YB|
		for (int i = 0; i < charger.length; i++) {
			if(Math.abs(r - charger[i].r) + Math.abs(c - charger[i].c)<=charger[i].cover) {
				list.add(charger[i]);
			}
		}
		return list;
	}
}
