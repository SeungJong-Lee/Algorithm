package study.source;

public class pr_1_3 {

	public static void main(String[] args) {
		int num = 1;
		int num2 = 1;
		int num3 = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.printf("   ");
			}
			for (int j = 5-i; j >= 1; j--) {
				System.out.printf("%2d ", num++);
			}
			System.out.println("");
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < i; j++) {
				System.out.printf("   ");
			}
			for (int j = 0; j < 5 - (i*2); j++) {
				System.out.printf("%2d ", num2++);
			}
			System.out.println("");
		}
		for (int i = 2; i > 0; i--) {
			for (int j = 1; j < i; j++) {
				System.out.printf("   ");
			}
			for (int j = 0; j < 5 - ((i-1)*2); j++) {
				System.out.printf("%2d ", num2++);
			}
			System.out.println("");
		}
		for (int i = 3; i > 0 ; i--) {
			for (int j = 1; j < i ; j++) {
				System.out.printf("   ");
			}
			for (int j = 0; j < 5 - ((i-1)*2); j++) {
				System.out.printf("%2d ", num3++);
			}
			System.out.println("");
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < i+1; j++) {
				System.out.printf("   ");
			}
			for (int j = 0; j < 5 - ((i+1)*2); j++) {
				System.out.printf("%2d ", num3++);
			}
			System.out.println("");
		}
		
		
		
		
		
	}

}
