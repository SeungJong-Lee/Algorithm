package Test_1;

public class Test3_이승종 {
	
	public void execute(String msg) {
		int[] arr = new int[10];
		char[] num = {'0','1','2','3','4','5','6','7','8','9'};
		int a;
		for (int i = 0; i < msg.length(); i++) {
			a = msg.charAt(i)-'0';
			arr[a] += 1;
		}
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] != 0) {
				System.out.println(num[i]+ " : "+arr[i]);
			}
		}
		
	}
	
	public static void main(String[] args) {
		Test3_이승종 c=new Test3_이승종();
		c.execute("53290539955364534323455987827332679340558347453272569584"); 
		System.out.println("=======");
		c.execute("13334444555557777777"); 
	}
}
