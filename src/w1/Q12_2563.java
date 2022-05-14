package w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q12_2563 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] wall = new int[100][100];
		List<Point> points = new ArrayList<>();
		StringTokenizer st;

		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		for(Point point : points) {
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
					wall[point.x+i][point.y+j]++;
				}
			}
		}

		int answer = 0;
		for(int[] x : wall) {
			for(int y : x) {
				if(y >0 ) {
					answer++;
				}
			}
		}
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
