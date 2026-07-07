public class BinarySearchExample {
	public static void main(String[] args) {
		int[] arr = {1, 3, 3, 5, 7, 7, 7, 9, 11};
		int target = 7;

		System.out.println("index: " + binarySearch(arr, target));
		System.out.println("index (없는 값 4): " + binarySearch(arr, 4));
	}

	// 정렬된 배열에서 target과 일치하는 원소의 인덱스를 반환 (없으면 -1)
	public static int binarySearch(int[] arr, int target) {
		int left = 0, right = arr.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return -1;
	}
}
