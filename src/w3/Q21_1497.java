package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q21_1497 {
	// N개 중 ?개를 뽑는데, 최소가 되도록!
	private static int N, M, min;
	private static int[][] guitars;
	private static int[] arr;
	private static boolean flag;

	public static void recur(int cur, int start) {
		if(cur == N) {
			min = Math.min(min, countGuitar());
			return;
		}

		for(int i = start; i<N; i++) {
			arr[cur] = i;
			if(canSingAllSong()) {
				flag = true;
				return;
			}
			recur(cur+1, i+1);
			if(flag) return;
		}
	}

	private static boolean canSingAllSong() {
		boolean[] canPlay = new boolean[M];
		for(int guitar : arr) { // 지금까지 고른 모든 기타를 돌면서
			for(int i = 0; i<M; i++) { // M개의 곡에 대해, 전부 연주 가능한지 확인
				if(guitars[guitar][i] == 1) {
					canPlay[i] = true;
				}
			}
		}
		for(boolean isTrue : canPlay) {
			if(!isTrue) {
				return false;
			}
		}
		return true;
	}

	private static int countGuitar() {
		int result = 0;
		boolean[] canPlay = new boolean[M];

		for(int guitar : arr) {
			for(int i = 0; i<M; i++) {
				if(guitars[guitar][i] == 1) {
					canPlay[i] = true;
				}
 			}
			// 여기까지의 기타로 모든 곡을 연주할 수 있다면?
		}

		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		guitars = new int[N][M];
		arr = new int[N];

		String songs = "";
		char value;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken(); 		// 이름
			songs = st.nextToken(); // 연주할 수 있는 곡
			for(int j = 0; j<M; j++) {
				value = songs.charAt(j);
				if(value == 'Y') {
					guitars[i][j] = 1;
				}
				else {
					guitars[i][j] = 0;
				}
			}
		}

		recur(0,0);
		System.out.println(min);
	}
}
