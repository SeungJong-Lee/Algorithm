package study.source;

public class 하노이탑 {

	public static void main(String[] args) {
		hanoi(3, 1, 3, 2);
	}

	private static void hanoi(int n, int from, int to, int im) {
		if(n==0) return;
		hanoi(n-1, from, im, to);
		System.out.println(n + "번원판: " + from + " -> " + to+"\n");
		hanoi(n-1, im, to, from);	
	}
}
