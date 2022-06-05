package w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q15 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());


		OUTER : for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			ArrayList<Person> pList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				pList.add(new Person(st.nextToken()));
			}

			int min = Integer.MAX_VALUE;
			for (int i = 0; i < pList.size(); i++) {
				for (int j = i+1; j < pList.size(); j++) {
					for (int k = j+1; k < pList.size(); k++) {
						min = Math.min(min, sumDistance(pList.get(i), pList.get(j), pList.get(k)));
						if(min == 0) {
							System.out.println(min);
							continue OUTER;
						}
					}
				}
			}
			System.out.println(min);
		}
	}

	private static int sumDistance(Person person1, Person person2, Person person3) {
		int sum = 0;
		sum += distance(person1, person2);
		sum += distance(person2, person3);
		sum += distance(person1, person3);
		return sum;
	}

	private static int distance(Person person1, Person person2) {
		int sum = 0;
		if(person1.M != person2.M)
			sum++;
		if(person1.B != person2.B)
			sum++;
		if(person1.T != person2.T)
			sum++;
		if(person1.I != person2.I)
			sum++;
		return sum;
	}

	static class Person{
		int M;
		int B;
		int T;
		int I;

		public Person(String mbti) {
			if(mbti.contains("E"))
				M = 0;
			else
				M = 1;
			if(mbti.contains("S"))
				B = 0;
			else
				B = 1;
			if(mbti.contains("T"))
				T = 0;
			else
				T = 1;
			if(mbti.contains("J"))
				I = 0;
			else
				I = 1;
		}
	}
}
