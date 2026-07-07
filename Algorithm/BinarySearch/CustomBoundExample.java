import java.util.function.IntPredicate;

public class CustomBoundExample {
	public static void main(String[] args) {
		int[] arr = {1, 3, 3, 5, 7, 7, 7, 9, 11};

		// 1) 인덱스 기반 조건: arr[idx] >= 5 를 만족하는 첫 인덱스 (lowerBound(5)와 동일)
		int idx1 = customBound(0, arr.length - 1, i -> arr[i] >= 5);
		System.out.println("arr[idx] >= 5 인 첫 인덱스: " + idx1);

		// 2) 값 자체를 대상으로 하는 파라메트릭 서치: x*x >= 50 을 만족하는 최소 x
		int idx2 = customBound(0, 100, x -> (long) x * x >= 50);
		System.out.println("x*x >= 50 을 만족하는 최소 x: " + idx2);
	}

	/**
	 * [left, right] 구간에서 condition을 만족하는 가장 작은 값을 이분 탐색으로 찾는다.
	 * condition은 false...false true...true 형태의 단조성을 가져야 한다.
	 * 만족하는 값이 없으면 right + 1을 반환한다.
	 */
	public static int customBound(int left, int right, IntPredicate condition) {
		int min_idx = right + 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (condition.test(mid)) {
				min_idx = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return min_idx;
	}
}
