package unsolved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1062_가르침 {

	static int N, K, ans;
	static String[] inputStr;
	static String[] setChar = {"a","n","t","i","c"};
	static String[] combinationStr;
	static ArrayList<String> arrtemp = new ArrayList<String>();
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			String tempS = br.readLine();
			if(tempS.length() > K) arrtemp.add(tempS);
			else ans++;
		}
		inputStr = new String[arrtemp.size()];
		inputStr = arrtemp.toArray(new String[arrtemp.size()]);

		if(K<5) {  // antic -> 앞에 anta로 시작 tica로 끝나기 때문에 무조건 필요함
			System.out.println("0");
			return;
		}
		else if(K==5) {  // antic를 다 지웠는데 빈 문자열이 되면 ++
			if(inputStr.length>0) {
				defaultSet();
			}
			System.out.println(ans);				
			return;
		}
		else {
			if(inputStr.length>0) {
				defaultSet(); // inputString을 antic 를 제외한 문자열 배열 생성
				setString(inputStr); // inputString중에 중복을 제외한 배열 생성 -> combinationString
				combination(new String[K-5], 0, 0); // combinationString중에 K-5 개를 조합해서 				
			}
			System.out.println(ans);			// 조합 결과에 해당하는 문자를 지웠을 때, 0이 된다면 문자를 배울 수 있다고 판단
		}
	}
	
	private static void combination(String[] sel, int idx, int k) {
		if( k == sel.length) {
			int temp = removeChar(sel); // 조합 결과 문자들 지워서 길이가 0이라면 개수 증가
			ans = Math.max(ans, temp); // 조합 결과 중 가장 큰 값을 저장
			return;
		}
		for (int i = idx; i < combinationStr.length; i++) {
			sel[k] = combinationStr[i];
			combination(sel, i+1, k+1);
		}
	}
	
	
	private static int removeChar(String[] str) {
		int temp = 0;
		for (int i = 0; i < inputStr.length; i++) { // 조합 배열 str을 돌면서 해당 문자를 공백으로 했을 때
			String tempString = inputStr[i];		// 그 문자의 길이가 0이라면 개수 증가
			for (String s : str) {
				tempString = tempString.replaceAll(s, "");
			}
			if(tempString.length()==0) temp++;
		}
		return temp;
	}
	
	private static void defaultSet() {		// 기본 문자 antic를 뺀 문자로 저장 -> inputStr
		for (int i = 0; i < N; i++) {
			for (String str : setChar) {
				inputStr[i] = inputStr[i].replaceAll(str, "");
				if(inputStr[i].length() == 0) {
					ans++;
				}
			}
		}
	}
	
	private static void setString(String[] str) {		// inputStr중에서 중복을 제거해서 조합돌리기 위해 combinationString에 저장
		String temp = "";
		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < str[i].length(); j++) {
				if(!temp.contains(str[i].substring(j, j+1))) {
					temp += str[i].substring(j, j+1);
				}
			}
		}
		combinationStr = new String[temp.length()];
		for (int i = 0; i < temp.length(); i++) {
			combinationStr[i] = temp.substring(i, i+1);
		}
	}
}
