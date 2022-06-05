package w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2_1018 {
	private static boolean[][] board;
	private static int n, m, minValue = 64;
	private static int SIZE = 8, BOARD_SIZE = 64;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String row;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new boolean[n][m];
		for(int i = 0; i<n; i++) {
			row = br.readLine();
			for(int j = 0; j<m; j++) {
				board[i][j] = (row.charAt(j) == 'W');
			}
		}

		for(int i = 0; i < n-SIZE+1; i++) {
			for(int j = 0; j < m-SIZE+1; j++) {
				countToRepaint(i, j);
			}
		}

		System.out.println(minValue);
	}

	public static void countToRepaint(int x, int y) {
		boolean firstColor = board[x][y];
		int matchedCounter, endX, endY;

		endX = x+8;
		endY = y+8;
		matchedCounter = 0;
		for(int i = x; i<endX; i++) {
			for(int j = y; j<endY; j++) {
				if(board[i][j] != firstColor) {
					matchedCounter++;
				}
				firstColor = !firstColor;
			}
			firstColor = !firstColor;
		}

		matchedCounter = Math.min(matchedCounter, BOARD_SIZE - matchedCounter);
		minValue = Math.min(minValue, matchedCounter);
	}

}
