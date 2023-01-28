package BOJ;

import java.util.Scanner;

public class Main {
    static int N, M, R, S;
    static int[][] matrix, copy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 배열의 크기 N*M
        M = sc.nextInt();
        R = sc.nextInt(); // 회전 수 R

        // min(N, M) mod 2 = 0
        S = Math.min(N, M) / 2; // 1회전에서 돌려야하는 사각형의 개수

        matrix = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < R; i++) {
            rotateArr(matrix, N, M, S);
        }

        for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.printf("%d ", matrix[i][j]);
			}
			System.out.println("");
		}
    }

    private static void print() {
        for (int[] is : matrix) {
            for (int i : is) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    
	private static void rotateArr(int[][] arr, int N, int M, int s) {
	for (int i = 0; i < s; i++) {
		int squareI = N-1-i;
		int squareJ = M-1-i;
		int temp = arr[i][i];
		for (int j = i; j < squareJ; j++) {
			arr[i][j] = arr[i][j+1];
		}
		for (int j = i; j < squareI; j++) {
			arr[j][squareJ] = arr[j+1][squareJ];
		}
		for (int j = squareJ; j > i; j--) {
			arr[squareI][j] = arr[squareI][j-1];
		}
		for (int j = squareI; j > i; j--) {
			arr[j][i] = arr[j-1][i];
		}
		arr[i+1][i] = temp;
	}
}
}