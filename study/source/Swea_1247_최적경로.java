package study.source;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
class Point{
	int  x,y;
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
}
public class Swea_1247_최적경로 {
	static int T, Ans, N;
	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("최적경로.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			Ans = Integer.MAX_VALUE;
			N = sc.nextInt();
			// 입력
			Point[] cus = new Point[N];
			Point company = new Point(sc.nextInt(), sc.nextInt());
			Point home = new Point(sc.nextInt(), sc.nextInt());
			for (int i = 0; i < N; i++) {
				cus[i]=new Point(sc.nextInt(), sc.nextInt());
			}
			
			permutation(cus,new Point[cus.length],new boolean[cus.length],0,company,home);
			
			System.out.printf("#%d %d\n",tc,Ans);
		}
		sc.close();
		
		
	}
	private static void permutation(Point[] cus, Point[] sel, boolean[] v, int k, Point company, Point home) {
		// basis part
		if(k==sel.length) {
			//System.out.println(Arrays.toString(sel));
			// 고객의 집순서가 순열로 sel배열에 입력되었으니
			// 회사에서 1번째고객으로 방문
			// 고객들 방문
			// 마지막고객에서 집으로 고고생
			// 거리공식
			//  |x1-x2| + |y1-y2|
			
			int c = Math.abs(company.x  - sel[0].x) + Math.abs(company.y - sel[0].y);
			int h = Math.abs(sel[sel.length-1].x - home.x) + Math.abs(sel[sel.length-1].y-home.y);
			int sum = 0;
			for (int i = 0; i < N-1; i++) {
				sum += Math.abs(sel[i].x - sel[i+1].x) + Math.abs(sel[i].y - sel[i+1].y);
			}
			Ans = Math.min(Ans, c+h+sum);
			return;
		}
		
		// inductive part
		for (int i = 0; i < cus.length; i++) {
			if(!v[i]) {
				v[i]=true;
				sel[k]=cus[i];
				permutation(cus, sel, v, k+1, company, home);
				v[i]=false;
			}
		}
		
	}

}


