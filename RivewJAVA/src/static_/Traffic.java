package static_;

class Road{
	int[] traffic = new int[10];

	public Road(int...nums) {
		for(int i = 0; i < traffic.length; i++) {
			traffic[i] = nums[i];
		}
	}

	public int timeSum(int start, int end) {
		int timeSum = 0;
		for(int i = start; i <= end; i++) {
			timeSum += traffic[i];
		}
		return timeSum;
	}

}

class Bridge {
	int index;
	int total;

	public Bridge(int index) {
		this.index = index;
	}

	public static Bridge min(Bridge[] bridges) {
		Bridge min = bridges[0];
		for(int i = 0; i < bridges.length; i++) {
			//			min = total[i] > min ? min : total[i];
			if(min.total > bridges[i].total) min = bridges[i];
		}
		return min;
	}

	public void bridgeInfo() {
		System.out.println("다리 번호: " + index);
		System.out.println("최단 시간: " + total);
	}

}

public class Traffic {

	public static void main(String[] args) {
		/*
		 * 도로 교통상황이 숫자로 주어진다.
		 * 
		 * 출발 70 80 60 20 30 50 10 80 77 89
		 * 			 ||	   ||	 ||
		 * 	   70 60 40 50 55 65 23 44 37 88 도착
		 * 
		 * 북쪽도로에서 남쪽도로로 건널수 있는 다리는 index번호로 주어진다.
		 * 이때, 가장 최소시간이 소요되는 다리는 몇번 다리인지 출력하고 최소시간을 함께 출력!
		 * 
		 * 출력예시) 다리번호: 6
		 * 		   최소시간: 512
		 * 
		 * 주의사항.
		 * 1. 무조건 다리를 1번 건너야함 (도착지점이 남쪽이기 때문에)
		 * 2. 다리를 여러번 건널수 없고 딱, 한번만 가능
		 * 3. 다리를 건널때에는 남쪽, 북쪽 소요시간이 같이 소요됨. (즉, 같이 합산해야함)
		 * 4. 소요시간이 같은 경우가 발생하면 낮은 다리번호를 출력
		 * */

		Road north = new Road(70, 80, 60, 20, 30, 50, 10, 80, 77, 89);
		Road south = new Road(70, 60, 40, 50, 55, 65, 23, 44, 37, 88);

		//		Bridge b1 = new Bridge(2);
		//		Bridge b2 = new Bridge(4);
		//		Bridge b3 = new Bridge(6);

		Bridge[] bridges = {new Bridge(2), new Bridge(4), new Bridge(6)};

		for(int i = 0; i < bridges.length; i++) {
			bridges[i].total = north.timeSum(0, bridges[i].index) 
					+ south.timeSum(bridges[i].index, south.traffic.length-1);
		}

		System.out.println(bridges[0].total);

		//		Bridge[][] minTotal = {
		//				{bridges[0], bridges[0].total},
		//				{bridges[1], bridges[1].total},
		//				{bridges[2], bridges[2].total},
		//		};

		Bridge minBridge = Bridge.min(bridges);
		minBridge.bridgeInfo();
	}

}
