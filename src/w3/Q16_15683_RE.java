package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16_15683_RE {
	private static int N, M, blindSpot, cctv;
	private static Cctv[] cctvList;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int[][][] direction = {
		{{0}},
		{{1}, {2}, {3}, {0}},
		{{1,3}, {2,0}},
		{{1,2}, {2,3}, {3,0}, {0,1}},
		{{1,2,3}, {2,3,0}, {3,0,1}, {0,1,2}}, // 타입이 한줄이고, {} 하나가 방향
		{{1,2,3,0}},
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] office = new int[N][M];
		cctvList = new Cctv[8];

		int remainArea = N*M;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				if(1 <= office[i][j] && office[i][j] <= 5) {
					cctvList[cctv++] = new Cctv(i, j, office[i][j]);
				}
				else if(office[i][j] == 6) {
					remainArea--;
				}
			}
		}

		blindSpot = 987654321;
		recur(0, remainArea - cctv, office);
		System.out.println(blindSpot);
	}

	public static void recur(int cur, int remainArea, int[][] currentMap) {
		if(cur == cctv) {
			blindSpot = Math.min(blindSpot, remainArea);
			return;
		}

		int[][] map = new int[N][M];
		copyMap(map, currentMap);
		Cctv currentCctv = cctvList[cur];

		for(int i = 0; i<direction[currentCctv.type].length; i++) { // cctv 타입이 돌 수 있는 만큼 돌면서
			int observedArea = 0;
			for(int j = 0; j<direction[currentCctv.type][i].length; j++) { // 방향을 선택하고
				int selectDirection = direction[currentCctv.type][i][j];
				observedArea += observe(currentCctv, selectDirection, map);
			}
			recur(cur+1, remainArea - observedArea, map);
			copyMap(map, currentMap);
		}
	}

	private static void copyMap(int[][] map, int[][] beforeMap) {
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				map[i][j] = beforeMap[i][j];
			}
		}
	}

	public static int observe(Cctv cctv, int direction, int[][] map) {
		int observedArea = 0, nx = cctv.x, ny = cctv.y;

		while(true) {
			nx += dx[direction];
			ny += dy[direction];

			if(!inRange(nx, ny) || map[nx][ny] == 6) return observedArea;
			if((1<= map[nx][ny] && map[nx][ny] <= 5) || map[nx][ny] == -1) continue;

			map[nx][ny] = -1;
			observedArea++;
		}
	}

	public static boolean inRange(int x, int y) {
		return 0<=x && x<N && 0<=y && y<M;
	}

	static class Cctv {
		int x;
		int y;
		int type;

		public Cctv(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}
}
