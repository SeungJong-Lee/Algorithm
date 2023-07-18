package study.source;

public class Main {

	public static void main(String[] args) {
		int a = 4;
		int b = 4;
		if(++a<=4) System.out.println('1');
		else System.out.println('2');
		if(b>3 & b++<=4) System.out.println('3');
		System.out.println(true & true & false);
		
	    System.out.println("반복문 시작");
	    
	    for(int index = 1 ; index <= 5 ; index++) {
	    	
	        if(index == 3) {
	            continue;
	        }
	        System.out.println(index);
	    }
	    
	    System.out.println("반복문 종료");
	    
		
	
	}
	public static int add(int a, int b) {return a + b;}
//	int add(int x, int y) {return x + y;}
	public static long add(long x, int y) {return x * y;}
	
	
}
