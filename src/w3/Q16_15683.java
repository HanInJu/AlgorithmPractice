package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q16_15683 {
	// cctv의 방향 4가지 중 1가지를 뽑는다.
	// 사각지대의 최소 크기 출력
	private static int N, M, minBlindSpot, blindSpot;
	private static int[][] office;
	private static boolean[][] selectedDirection;
	private static List<Cctv> cctvList = new ArrayList<>();
	// 4가지 경우 : 동, 서, 남, 북
	// 2가지 경우 : 좌우 또는 상하
	// 4가지 경우 : 북동, 남동, 남서, 북서
	// 4가지 경우 : 서북동, 북동남, 동남서, 남서북
	// 1가지 경우

	public static void recur(int cur) {
		if(cur == cctvList.size()) { // 모든 cctv가 관찰하는 지역 표시가 끝났다면
			for(int i = 0; i< cctvList.size(); i++) {
				Cctv cctv = cctvList.get(i);

				// if(selectedDirection[]) {
				//
				// }
			}
			// 사각지대를 계산해서 : 사각지대 999
			// 최소값 갱신
		}

		for(int j = 0; j < cctvList.size(); j++) { // 모든 CCTV에 대해
			Cctv current = cctvList.get(j);
			for(int i = 0; i < 4; i++) { // cctv 방향 설정
				if(current.type == 1) {
					current.setDirectionX(i+1, -9);
				}
				// current.setDirectionX();
				selectedDirection[i][j] = true;
				recur(cur+1);
				selectedDirection[i][j] = false;
			}
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		office = new int[N][M];

		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				cctvList.add(new Cctv(i, j, office[i][j]));
			}
		}

		selectedDirection = new boolean[4][cctvList.size()];
		recur(0);
		System.out.println(minBlindSpot);
	}

	static class Cctv {
		int x;
		int y;
		int type;
		int directionX1;
		int directionX2;
		int directionY1;
		int directionY2;

		public Cctv(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}

		public void setDirectionX(int x1, int x2) {
			this.directionX1 = x1;
			this.directionX2 = x2;
		}

		public void setDirectionY(int y1, int y2) {
			this.directionY1 = y1;
			this.directionY2 = y2;
		}
	}
}
