package array;
import java.util.Scanner;

public class PascalTriangle {

	public static void main(String[] args) {

		/*
		 * 		4
		 * 		6	2
		 * 		9	3	1
		 * 		19	10	7	?
		 * 
		 * 	위와 같은 규칙을 좀더 일반화하여 각행의 제일 첫번째 숫자들만 주어지면
		 *  N크기의 모든 격자판 정보를 출력하는 프로그램을 작성하시오.
		 *  
		 *  입력예시)
		 *  4
		 *  4
		 *  6
		 *  9
		 *  19
		 *  출력예시)
		 *  4
		 *  6	2
		 *  9	3	1
		 *  19	10	7	6
		 * 
		 * */
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][];

		for(int i=0; i < arr.length; i++) {
			arr[i] = new int[i+1];
			arr[i][0] = sc.nextInt();
		}

		for(int i = 1; i < arr.length; i++) {
			for(int j = 1; j < arr[i].length; j++) {
				arr[i][j] = arr[i][j-1] - arr[i-1][j-1];
			}
		}

		// 배열의 모든 요소 출력
		for(int[] a : arr) {
			for(int num : a) {
				System.out.print(num + "\t");
			}
			System.out.println();
		}

	}
}



