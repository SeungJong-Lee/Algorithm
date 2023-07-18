package study.source;

public class PowerSet {

	static int[] arr = {1,3,5};
	public static void main(String[] args) {
		powerset(0, new boolean[arr.length]);
	}
	private static void powerset(int idx, boolean[] v) {
		if(idx == v.length) {
			for (int i = 0; i < v.length; i++) {
				if(v[i]) {
					System.out.print(arr[i]+" ");
				}
			}
			System.out.println();
			return;
		} else {
			v[idx] = true;
			powerset(idx+1, v);
			v[idx] = false;
			powerset(idx+1, v);		
		}
	}
}
