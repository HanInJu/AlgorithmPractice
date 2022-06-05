package w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q7_2304_RE {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Stack<Pillar> leftStack = new Stack<>();
		Stack<Pillar> rightStack = new Stack<>();
		ArrayList<Pillar> pillars = new ArrayList<>();

		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			pillars.add(new Pillar(L, H));
		}

		Collections.sort(pillars);

		int maxHeight = 0;
		int len = pillars.size();
		for (Pillar pillar : pillars) {
			if (pillar.y > maxHeight) {
				maxHeight = pillar.y;
				leftStack.push(pillar);
			}
		}
		maxHeight = 0;
		for(int i = len - 1; i >= 0; i--) {
			if(maxHeight < pillars.get(i).y) {
				maxHeight = pillars.get(i).y;
				rightStack.push(pillars.get(i));
			}
		}

		int ans = (rightStack.peek().x - leftStack.peek().x + 1) * rightStack.peek().y;
		int beforeLeft = leftStack.pop().x;
		while(!leftStack.isEmpty()) {
			int left = leftStack.peek().x;
			int height = leftStack.peek().y;
			ans += (beforeLeft - left) * height;
			beforeLeft = left;
			leftStack.pop();
		}

		int beforeRight = rightStack.pop().x + 1;
		while(!rightStack.isEmpty()) {
			int right = rightStack.peek().x + 1;
			int height = rightStack.peek().y;
			ans += (right - beforeRight) * height;
			beforeRight = right;
			rightStack.pop();
		}

		System.out.println(ans);
	}

}

class Pillar implements Comparable<Pillar>{
	int x;
	int y;

	public Pillar(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Pillar o) {
		return this.x < o.x ? -1 : 1;
	}
}
