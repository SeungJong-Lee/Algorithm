package study.source;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Recursive07 {
	static int arr;
	static int sel;
	static long sum = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = Integer.parseInt(st.nextToken());
		sel = Integer.parseInt(st.nextToken());
		recursive(0, 0);
		bw.write(sum+"");
		bw.flush();
	}

	private static void recursive(int idx, int k) {
		// basis part
		if(idx == sel) {
			sum++;
			return;
		} else {
			for (int i = k; i < arr; i++) {
				recursive(idx+1, i+1);
			}
		}
	}
}
