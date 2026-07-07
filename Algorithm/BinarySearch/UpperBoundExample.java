public class UpperBoundExample {
	public static void main(String[] args) {
		int[] arr = {1, 3, 3, 5, 7, 7, 7, 9, 11};
		int target = 7;

		System.out.println("upperBound(7): " + upperBound(arr, target)); // 7
	}

	// target 초과인 값이 처음 등장하는 인덱스를 반환 (C++ upper_bound와 동일한 의미)
	public static int upperBound(int[] arr, int target) {
		int left = 0, right = arr.length - 1;
		int max_idx = arr.length; // 조건을 만족하는 값이 없으면 배열 길이 반환

		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid] > target) {
				max_idx = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return max_idx;
	}
}
