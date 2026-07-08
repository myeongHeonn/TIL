public class TreeCuttingExample {
	public static void main(String[] args) {
		int[] heights = {20, 15, 10, 17};
		long m = 7; // 집에 가져가야 하는 나무의 길이

		System.out.println("최대 절단기 높이 H: " + parametricSearch(heights, m));
	}

	// 절단기 높이 h로 나무를 자를 때 얻는 나무 길이의 합 (h보다 큰 부분만 잘려나감)
	private static long getCutLength(int[] heights, long h) {
		long total = 0;
		for (int height : heights) {
			if (height > h) {
				total += height - h;
			}
		}
		return total;
	}

	/**
	 * "잘라서 얻는 나무 길이의 합 >= m" 을 만족하는 가장 큰 절단기 높이 h를 탐색한다 (BOJ 2805 나무 자르기).
	 * h가 커질수록 얻는 길이는 줄어들므로 condition은 true...true false...false 형태의 단조성을 가진다.
	 */
	public static long parametricSearch(int[] heights, long m) {
		long left = 0, right = 0;
		for (int height : heights) {
			right = Math.max(right, height);
		}

		long max_h = left;
		while (left <= right) {
			long mid = (left + right) / 2;

			if (getCutLength(heights, mid) >= m) {
				max_h = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return max_h;
	}
}
