package study.source;

import java.util.Arrays;

/*
 * 배열요소 값중 2개를 뽑아 출력하세요
 */
public class Combination {
	// 원본배열
	static int[] arr = {1,3,5};
	// 저장배열
	static int[] sel = new int[2];
	
	public static void main(String[] args) {
		recursive(0, 0); // 시작 index, 담을 배열에 몇개 쌓았나 
	}

	/*
	 * idx : 원본배열의 인덱스
	 * k : 저장배열의 인덱스
	 */
	private static void recursive(int idx, int k) {
		// basis part
		// 2개를 다 뽑았으면 그만
		if(idx == sel.length) {
			System.out.println(Arrays.toString(sel));
//			if(sumArray(sel) > 4) System.out.println(Arrays.toString(sel));
			return;
		}else {
			for (int i = k; i < arr.length; i++) {
				sel[idx] = arr[i];
				recursive(idx+1,  i);
			}
		}
	}
}
