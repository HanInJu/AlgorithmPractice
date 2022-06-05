package w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q7_2304_X {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] points = new int[1001];
		int x, y, minX, maxX, area, maxY;

		minX = 987654321;
		maxX = -1;
		maxY = -1;
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			points[x] = y;

			minX = Math.min(minX, x);
			maxX = Math.max(maxX, x);
			// maxY = Math.max(maxY, y);
		}

		area = 0;
		Point beforePoint = new Point(minX, points[minX]);
		for(int i = minX; i <= maxX; i++) {
			if(points[i] > beforePoint.y) {
				if(points[i] > points[i+1]) {
					area += points[i];
					beforePoint.changePoint(i+1, points[i+1]);
				}
				area += (i - beforePoint.x) * beforePoint.y;
				beforePoint.changePoint(i, points[i]);
			}
			if(i == maxX) {
				area += (i - beforePoint.x) * points[i];
			}
		}
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void changePoint(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
