package study.source;

import java.util.Arrays;

/*
 *  배열요소값중 2개를 뽑아 출력하세요
 * 
 */
public class 순열 {
	// 원본배열
	static int[] arr = {2, 1, 1, 1};
	// 저장배열
	static int[] sel = new int[4];
	
	
	public static void main(String[] args) {
		boolean[] visited = new boolean[5];
		
		recursive(0,0, visited);
//		recursive(0,0);
	}
	/*
	 * idx : 원본배열의 인덱스
	 * k : 저장배열의 인덱스
	 */
	private static void recursive(int idx, int k, boolean[] visited) {
		// basis part
		// 2개를 다 뽑았으면 그만
		if(k==sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		// 더이상 고를값이 없는 경우
		if(idx==arr.length) return ;
		// inductive part
		for (int j = 0; j < arr.length; j++) {
			if(!visited[j]) {
				visited[j] = true;
				sel[k]=arr[j];
				recursive(idx+1, k+1, visited);
				visited[j] = false;
			}
		}
	}
//	private static void recursive(int idx, int k) {
//		// basis part
//		// 2개를 다 뽑았으면 그만
//		if(k==sel.length) {
//			System.out.println(Arrays.toString(sel));
//			return;
//		}
//		// 더이상 고를값이 없는 경우
//		if(idx==arr.length) return ;
//		// inductive part
//		for (int j = 0; j < arr.length; j++) {
//			sel[k] = arr[j];
//			recursive(idx,  k+1);
//			
//		}
//	}

}
