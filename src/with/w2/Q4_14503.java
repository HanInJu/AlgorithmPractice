package with.w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4_14503 {
	private static int[][] floor;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[] changeDir = {1, 2, 3, 0};
	private static int CLEANED = 2;
	private static int  n, m;

	public static void main(String[] args) throws IOException {
		int x, y, dir;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		floor = new int[n][m];

		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());

		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				floor[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(robotCleaning(x, y, changeDir[dir]));
	}

	public static int robotCleaning(int x, int y, int dir) {
		setCleaned(x, y);
		int nx, ny;
		nx = x + dx[0];
		ny = y + dy[0];

		//왼쪽에 청소하지 않은 빈공간이 있다면
		if(!isWall(nx, ny) && !isCleaned(nx, ny)) {
			dir = (dir + 1) % 4;
		}
		return 0;
	}

	public static boolean isCleaned(int x, int y) {
		return floor[x][y] == CLEANED;
	}

	public static boolean isWall(int x, int y) {
		return floor[x][y] == 1;
	}

	public static void setCleaned(int x, int y) {
		floor[x][y] = CLEANED;
	}
}
