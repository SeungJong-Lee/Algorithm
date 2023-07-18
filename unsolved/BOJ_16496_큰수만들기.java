package unsolved;

import java.util.*;
import java.io.*;
public class BOJ_16496_큰수만들기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		String[] num = new String[N];
        for(int i=0; i<N; i++) {
            num[i] = st.nextToken();
        }
        Arrays.sort(num, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
			}
		});
        String answer = "";
        for(int i=0; i<N; i++){
            answer+=num[i];
        }
        System.out.println(answer.charAt(0)=='0'?"0":answer);
	}
}

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class BOJ_16496_큰수만들기 {
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int T = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//        String[] arr = new String[T];
//
//        for (int i = 0; i < T; i++) {
//            arr[i] = st.nextToken();
//        }
//
//        Arrays.sort(arr, ((x, y) -> (y + x).compareTo(x + y)));
//
//        StringBuilder sb = new StringBuilder();
//        for (String s : arr) {
//            sb.append(s);
//        }
//        
//        if (sb.charAt(0) == '0') {
//            System.out.println(0);
//        } else {
//            System.out.println(sb);
//        }
//        
//        br.close();
//    }
//}