public class LowerBoundExample {
	public static void main(String[] args) {
		int[] arr = {1, 3, 3, 5, 7, 7, 7, 9, 11};
		int target = 7;

		System.out.println("lowerBound(7): " + lowerBound(arr, target)); // 4
		System.out.println("lowerBound(6): " + lowerBound(arr, 6)); // 4 (6은 없지만 7이 들어갈 위치)
	}

	// target 이상인 값이 처음 등장하는 인덱스를 반환 (C++ lower_bound와 동일한 의미)
	public static int lowerBound(int[] arr, int target) {
		int left = 0, right = arr.length - 1;
		int min_idx = arr.length; // 조건을 만족하는 값이 없으면 배열 길이 반환

		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid] >= target) {
				min_idx = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return min_idx;
	}
}
