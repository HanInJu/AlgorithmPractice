package w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q17 {
	public static int n;
	public static int[][] board = new int[1000][1000];
	public static int[] dx = {1, 0, -1, 0};
	public static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		int c = Integer.parseInt(br.readLine());
		int x = 0;
		int y = 0;
		int d = 0;
		int num = n * n;

		while (board[x][y] == 0) {
			board[x][y] = num--;
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (!inRange(nx, ny) || board[nx][ny] != 0) {
				d = (d + 1) % 4;
				nx = x + dx[d];
				ny = y + dy[d];
			}
			x = nx;
			y = ny;
		}

		int nx = 0;
		int ny = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == c) {
					nx = i + 1;
					ny = j + 1;
				}
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println(nx + " " + ny);
	}

	private static boolean inRange(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < n;
	}

}
