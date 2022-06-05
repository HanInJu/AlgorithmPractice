package w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q8_2615 {
	static int[][] board = new int[20][20];
	static int[] dx = {0, 1, 1, -1};
	static int[] dy = {1, 1, 0, 1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int x = 1; x <= 19; x++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int y = 1; y <= 19; y++) {
				board[x][y] = Integer.parseInt(st.nextToken());
			}
		}

		for (int x = 1; x <= 19; x++) {
			for (int y = 1; y <= 19; y++) {
				if (board[x][y] != 0 && isWin(x, y)) {
					System.out.println(board[x][y]);
					System.out.println(x + " " + y);
					return;
				}
			}
		}
	}

	private static boolean inRange(int x, int y) {
		return 1 <= x && x <= 19 && 1 <= y && y <= 19;
	}

	private static boolean isWin(int x, int y) {
		boolean flag = false;
		for (int i = 0; i < 4; i++) {
			int count = 1;

			if (inRange(x - dx[i], y - dy[i]) && board[x][y] == board[x - dx[i]][y - dy[i]]) {
				continue;
			}

			if (inRange(x + dx[i] * 5, y + dy[i] * 5) && board[x][y] == board[x + dx[i] * 5][y + dy[i] * 5]) {
				continue;
			}

			for (int k = 1; k <= 4; k++) {
				if (inRange(x + dx[i] * k, y + dy[i] * k) && board[x][y] == board[x + dx[i] * k][y + dy[i] * k])
					count++;
			}

			if (count == 5) {
				flag = true;
				break;
			}

		}

		return flag;
	}
}
