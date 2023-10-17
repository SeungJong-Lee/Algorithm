// https://school.programmers.co.kr/learn/courses/30/lessons/181188#qna

package programmers.p2;

import java.util.Arrays;

public class 요격시스템 {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> {
            return o1[1]-o2[1];
        });
        int shootPoint = 0;
        for(int[] arr : targets) {
            if(shootPoint <= arr[0]) {
                shootPoint = arr[1];
                answer++;
            }
        }
        return answer;
    }
}
