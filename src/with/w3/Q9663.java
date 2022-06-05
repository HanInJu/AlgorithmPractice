package with.w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9663 {
	public static int n, count;
	public static int[][] board;

	public static void recursion(int cursor) {
		if(cursor == n) {
			return;
		}

		for(int i = 0; i < n*n ; i++) {

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n*n개에서 n개 뽑기
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];

		recursion(0);
	}
}
