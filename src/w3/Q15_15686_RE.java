package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q15_15686_RE {
	private static int N, M, answer;
	private static List<Point> home = new ArrayList<>();
	private static List<Point> chicken = new ArrayList<>();
	private static boolean[] choice;

	public static void recur(int cur, int start) {
		if(cur == M) {
			int chickenDistanceOfCity = 0;

			for(int i = 0; i<home.size(); i++) {
				int chickenDistanceOfAHome = 987654321;
				for(int j = 0; j<chicken.size(); j++) {
					if(choice[j]) {
						int chickenDistance = Math.abs(home.get(i).x - chicken.get(j).x)
											+ Math.abs(home.get(i).y - chicken.get(j).y);
						chickenDistanceOfAHome = Math.min(chickenDistanceOfAHome, chickenDistance);
					}
				}
				chickenDistanceOfCity += chickenDistanceOfAHome;
			}

			answer = Math.min(answer, chickenDistanceOfCity);
			return;
		}

		for(int i = start; i<chicken.size(); i++) {
			choice[i] = true;
			recur(cur+1, i+1);
			choice[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int current;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				current = Integer.parseInt(st.nextToken());
				if(current == 1) {
					home.add(new Point(i, j));
				}
				else if(current == 2) {
					chicken.add(new Point(i, j));
				}
			}
		}

		choice = new boolean[chicken.size()];
		answer = 987654321;

		recur(0,0);
		System.out.println(answer);
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
