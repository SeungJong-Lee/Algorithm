/*
 * 양념치킨 가격, 후라이드 가격, 반반치킨 가격, 양념 최소 마리수, 후라이드 최소 마리수
 */
package BOJ.BOJ6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16917_양념반후라이드반 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		int price = 0;
		int min = Integer.MAX_VALUE;
		int Z = 0;
		for(int i=0; i<=100000; i++) {
			Z = 2 * i;
			price = (Z * C) + Math.max(0, X-Z/2) * A + Math.max(0, Y-Z/2) * B;
			if(min > price) min = price;
		}
		
		System.out.println(min);
	}
	

}
