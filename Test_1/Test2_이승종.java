package Test_1;

public class Test2_이승종 {

	public static void main(String[] args) {

		int[]  su=  {45, 80, 68, 19, 34, 55, 27, 63, 38, 7 };
		double avg_su = 0;
		double sum = 0;
		double max_diff = 0;
		int index = 0;
		int su_val = 0;
		for (int i = 0; i < su.length; i++) {
			sum += su[i];
		}
		avg_su = sum/su.length;
		for (int i = 0; i < su.length; i++) {
			if(Math.abs(avg_su - su[i]) > max_diff) {
				max_diff = avg_su - su[i];
				index = i;
				su_val = su[index];
			}
		}
		System.out.println(sum/su.length + " " + su_val);
	}
}
