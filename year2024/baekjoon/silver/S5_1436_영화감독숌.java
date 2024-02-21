package year2024.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_1436_영화감독숌 {
    public static void main(String[] args) throws IOException {
        int num = getInput();
        System.out.println(solve(num));
    }

    private static int solve(int cnt) {
        int num = 666;
        while (cnt > 0) {
            if (Integer.toString(num).contains("666")) {
                cnt--;
            }
            num++;
        }
        return num - 1;
    }

    private static int getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }
}
