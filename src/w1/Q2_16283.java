package w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q2_16283 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		List<Point> possible = new ArrayList<>();
		List<Point> real = new ArrayList<>();

		for(int x = 1; x < n; x++) {
			possible.add(new Point(x, n - x));
		}

		for(Point p : possible) {
			if((a * p.x + b * p.y) == w) {
				real.add(new Point(p.x, p.y));
			}
		}

		if(real.size() != 1) {
			System.out.println(-1);
		}
		else {
			System.out.println(real.get(0).x + " " + real.get(0).y);
		}

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
