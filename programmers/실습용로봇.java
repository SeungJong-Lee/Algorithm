// https://school.programmers.co.kr/learn/courses/15009/lessons/121687?language=java

package programmers;

public class 실습용로봇 {
    public int[] solution(String command) {
        for (int i = 0; i < command.length(); i++) {
            char com = command.charAt(i);
            switch (com) {
                case 'R':
                    dir++;
                    break;
                case 'L':
                    dir--;
                    break;
                case 'G':
                    position[0] += dr[dir];
                    position[1] += dc[dir];
                    break;
                case 'B':
                    position[0] += br[dir];
                    position[1] += bc[dir];
                    break;
            }
            if (dir == 4) dir = 0;
            else if (dir == -1) dir = 3;
        }
        return position;
    }

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int[] br = {0, -1, 0, 1};
    static int[] bc = {-1, 0, 1, 0};
    static int dir = 0;
    static int[] position = {0, 0};
}
