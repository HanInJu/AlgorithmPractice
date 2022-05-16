package with.w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3_2615 {
	private static int[][] board = new int[19][19];
	private static int[] dx = {-1, 0, 1, 0, 1, -1, 1, -1};
	private static int[] dy = {0, 1, 0, -1, 1, -1, -1, 1};
	private static int dir = 0;
	private static int BLACK = 1;
	private static int WHITE = 2;
	// private static int x, y;

	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int x, y;

		for(int i = 0; i<19; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<19; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0; i<19; i++) {
			for(int j = 0; j<19; j++) {
				if(board[i][j] == BLACK) {
					x = i;
					y = j;
					if(isWin(i,j, BLACK)) {
						break;
					}
				}
				if(board[i][j] == WHITE) {
					x = i;
					y = j;
					if(isWin(i,j, WHITE)) {
						break;
					}
				}
			}
		}

	}

	public static boolean isWin(int i, int j, int color) {
		return false;
	}
}
