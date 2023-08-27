package b_lecture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Pb_3 {

	static StringTokenizer st;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			list = new ArrayList<Integer>();
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				char command = st.nextToken().charAt(0);
				int index = Integer.parseInt(st.nextToken());
				calc(command, index);
			}
			System.out.print("#"+tc+" ");
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		}
	}
	private static void calc(char command, int index) {
		int n;
		switch(command) {
		case 'I' :
			// x = index
			// y = n
			n = Integer.parseInt(st.nextToken());
			for (int i = 0, insertIdx = index; i < n; i++, insertIdx++) {
				list.add(insertIdx, Integer.parseInt(st.nextToken()));
			}
			break;
		case 'D' :
			// x = index
			// y = n
			n = Integer.parseInt(st.nextToken());
			for (int i = 0; i < n; i++) {
				list.remove(index);
			}
			break;
		case 'A' :
			// y = index
			for (int i = 0; i < index; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			break;
		}
	}

}
