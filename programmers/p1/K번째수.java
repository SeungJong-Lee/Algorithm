package programmers.p1;// https://school.programmers.co.kr/learn/courses/30/lessons/42748
import java.util.*;
class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            int start = commands[i][0];
            int end = commands[i][1];
            int numIdx = commands[i][2];
            for(int j=start-1; j<end; j++) {
                queue.offer(array[j]);
            }
            int pollNum = 0;
            for(int j=0; j<numIdx; j++) {
                pollNum = queue.poll();
            }
            answer[i] = pollNum;
        }
        return answer;
    }
}