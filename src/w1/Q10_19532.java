package w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10_19532 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());

		int x = 0, y;
		if(a == 0) {
			y = c/b;
			x = (f - e*y) / d;
		}
		else if(d == 0) {
			y = f/e;
			x = (c - b*y) / a;
		}
		else if(b == 0) {
			x = c/a;
			y = (f-d*x) / e;
		}
		else if(e == 0) {
			x = f/d;
			y = (c - a*x) / b;
		}
		else {
			for(y = -999; y <= 999; y++) {
				if((b*d-a*e) * y == (c*d - a*f)) {
					x = (c - b*y) / a;
					break;
				}
			}
		}

		System.out.println(x + " " + y);
	}

}
