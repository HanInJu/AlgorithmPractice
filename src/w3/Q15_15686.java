package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15_15686 {
	// 모든 치킨거리의 합이 최소가 되도록 치킨집 개수 중 M개를 중복없이 고른다. 조합! 고르고나서 최소 치킨거리를 구해라
	// 0 빈곳, 1 집, 2 치킨집
	// chicken 중에서 M개를 고른다.
	private static int N, M, answer;
	private static int[] home;
	private static int[] chicken;
	private static int[] arr;
	private static boolean[] choice;

	public static void recur(int cur, int start) {
		if(cur == M) { // M개를 다 골랐다면?
			int chickenDistanceOfCity = 0; // 도시의 치킨거리
			for(int i = 0; i<home.length; i++) { // 모든 집에 대해
				int minChickenDistance = 0;
				for(int j = 0; j<chicken.length; j++) { // 모든 치킨집과의 거리를 계산해서
					if(choice[j]) {
						int chickenDistance = Math.abs(home[i] - chicken[arr[j]]) + Math.abs(i - arr[j]);
						minChickenDistance = Math.min(minChickenDistance, chickenDistance); // 그 중 최소값을 구한 뒤,
					}
				}
				chickenDistanceOfCity += minChickenDistance; // 도시의 치킨거리에 더한다
			}
			answer = Math.min(answer, chickenDistanceOfCity); // 최소값과 여기서 구한 도시의 치킨거리 중 더 작은 값을 정답으로 한다.
			return;
		}

		for(int i = start; i<chicken.length; i++) {
			// arr[cur] = i;
			choice[i] = true; // 치킨집 하나 고름 : i번째 idx(행)에 있는 치킨집을 골랐다고 하자.
			recur(cur+1, i+1);
			choice[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		home = new int[N*N];
		chicken = new int[N*N];
		arr = new int[M];

		int currentValue;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				currentValue = Integer.parseInt(st.nextToken());
				if(currentValue == 1) {
					home[i] = currentValue; // idx가 행, 값이 열
				}
				else if(currentValue == 2) {
					chicken[i] = currentValue;
				}
			}
		}
		choice = new boolean[chicken.length];
		recur(0,0);
		System.out.println(answer);
	}

}
