package study.source;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호짝짓기 {

	static int ans;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./seungJong/input/input_괄호짝짓기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			Stack<Character> s1 = new Stack<Character>();
			Stack<Character> s2 = new Stack<Character>();
			for (int i = 0; i < str.length(); i++) {
				s1.push(str.charAt(i));
			}
			while(!s1.isEmpty()) {
				if(checkType(s1.peek()) < 0) {
					s2.push(s1.pop());
				} else if(s1.peek() > 1) {
					int t1 = checkType(s1.peek());
					int t2 = checkType(s2.peek());
					if(s2.isEmpty()) {
						break;
					} else if(Math.abs(t1) != Math.abs(t2)) {
						break;
					}
					else {
						s1.pop();
						s2.pop();
					}
				}
			}
			if(s1.isEmpty() && s2.isEmpty()) ans = 1;
			else ans = 0;
			System.out.println("#"+tc+" "+ans);
		}
	}

	private static int checkType(Character c) {
		switch (c) {
		case '(':
			return 1;
		case '[':
			return 2;
		case '{':
			return 3;
		case '<':
			return 4;
		case ')':
			return -1;
		case ']':
			return -2;
		case '}':
			return -3;
		case '>':
			return -4;
		}
		return 0;
	}


}
