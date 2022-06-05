package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q21_1497_RE {
	// N개 중 ?개를 뽑는데, 최소가 되도록!
	private static int N, M, min = -1;
	private static int[][] guitars;
	private static int[] arr;
	private static boolean flag;

	public static void recur(int cur, int numberOfGuitar, int start, int songsCanBePlayed) {
		if(cur == numberOfGuitar) {
			int count = 0;

			for(int i = 0; i<M; i++) {
				for(int j = 0; j<numberOfGuitar; j++) {
					if(guitars[arr[j]][i] == 1) {
						count++;
						break;
					}
				}
			}
			if(count == songsCanBePlayed) {
				min = numberOfGuitar;
				flag = true;
			}
			return;
		}

		for(int i = start; i<N; i++) {
			arr[cur] = i;
			recur(cur+1, numberOfGuitar, i+1, songsCanBePlayed);
			if(flag) return;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		guitars = new int[N][M];
		arr = new int[N];

		String songs = "";
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken(); 		// 이름
			songs = st.nextToken(); // 연주할 수 있는 곡
			for(int j = 0; j<M; j++) {
				guitars[i][j] = songs.charAt(j) == 'Y' ? 1 : 0;
			}
		}

		int songsCanBePlayed = 0;
		for(int i = 0; i<M; i++) { // 전체 노래 중에서
			for(int j = 0; j<N; j++) { // j번 기타로
				if(guitars[j][i] == 1) { // i번 노래를 연주할 수 있으면
					songsCanBePlayed++; // i번 노래를 연주할 수 있는 것이므로 ++
					break; // i번째 노래는 이미 이 기타로 연주할 수 있으므로 다음 노래로 넘어간다.
				}
			}
		}

		if(songsCanBePlayed > 0) { // 연주할 수 있는 노래가 있다면,
			for(int i = 1; i<=N; i++) { // N개의 기타 중에서 하나씩 골라본다.
				recur(0, i, 0, songsCanBePlayed);
				if(flag) break;
			}
		}

		System.out.println(min);
	}
}
