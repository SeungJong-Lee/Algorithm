// https://school.programmers.co.kr/learn/courses/30/lessons/86971

package programmers.p2;

import java.util.ArrayList;

public class 전력망을둘로나누기 {
    static ArrayList<Integer>[] list;
    static boolean[] v;
    static int Cnt;
    public int solution(int n, int[][] wires) {
        int answer = 99999;
        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            list[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<wires.length; i++) {
            int s = wires[i][0];
            int e = wires[i][1];
            list[s].add(e);
            list[e].add(s);
        }
        for(int i=1; i<=n; i++) {
            v = new boolean[n+1];
            v[i] = true;
            Cnt = 0;
            dfs(1);
            int minVal = Math.abs(Cnt - (n - Cnt));
            answer = Math.min(answer, minVal);

        }

        return answer;
    }
    private static void dfs(int index) {
        v[index] = true;
        Cnt++;
        for(Integer next : list[index]) {
            if(!v[next]){
                v[next] = true;
                dfs(next);
            }
        }
    }
}
