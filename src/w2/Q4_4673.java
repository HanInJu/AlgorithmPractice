package w2;

public class Q4_4673 {
	public static void main(String[] args) {
		int[] arr = new int[10000];
		boolean[] answer = new boolean[11000];

		for(int i = 1; i<=9; i++) {
			arr[i-1] = i+i;
			answer[arr[i-1]] = true;
		}
		for(int i = 10; i<=99; i++) {
			arr[i-1] = i+(i/10)+(i%10);
			answer[arr[i-1]] = true;
		}
		for(int i = 100; i<=999; i++) {
			arr[i-1] = i+(i/100)+((i/10)%10)+(i%10);
			answer[arr[i-1]] = true;
		}
		for(int i = 1000; i<=9999; i++) {
			arr[i-1] = i+(i/1000)+((i/100)%10)+((i/10)%10)+(i%10);
			answer[arr[i-1]] = true;
		}

		for(int i = 1; i<10001; i++) {
			if(!answer[i]) {
				System.out.println(i);
			}
		}
	}
}
