# 이진 탐색 (Binary Search)

## 개념
정렬된 배열에서 탐색 범위를 절반씩 줄여가며 원하는 값을 찾는 알고리즘입니다. 매 단계마다 `left`, `right`로 정의된 구간의 중앙값 `mid`와 target을 비교해 탐색 범위를 좁혀나갑니다.

## 파일 설명

### 1. BinarySearchExample.java
- **역할**: target과 정확히 일치하는 원소의 인덱스를 탐색 (없으면 -1)
- **변수**: `left`, `right`, `mid`

### 2. LowerBoundExample.java
- **역할**: target **이상**인 값이 처음 등장하는 인덱스를 탐색 (C++ `lower_bound`와 동일)
- **변수**: `left`, `right`, `mid`, `min_idx` — 조건(`arr[mid] >= target`)을 만족할 때마다 `min_idx`에 기록하고 왼쪽 구간을 계속 탐색

### 3. UpperBoundExample.java
- **역할**: target **초과**인 값이 처음 등장하는 인덱스를 탐색 (C++ `upper_bound`와 동일)
- **변수**: `left`, `right`, `mid`, `max_idx` — 조건(`arr[mid] > target`)을 만족할 때마다 `max_idx`에 기록하고 왼쪽 구간을 계속 탐색

### 4. CustomBoundExample.java
- **역할**: 배열 값이 아닌 임의의 `IntPredicate` 조건으로 경계를 탐색하는 범용 이분 탐색 (파라메트릭 서치 템플릿)
- **변수**: `left`, `right`, `mid`, `min_idx`
- **전제조건**: 조건이 `false...false true...true` 형태의 단조성을 가져야 함
- **활용 예**: "x*x >= N을 만족하는 최소 x" 같이 배열이 아닌 값 자체를 탐색 공간으로 삼는 문제

## 공통 구조
네 파일 모두 `[left, right]` 폐구간(inclusive) 방식을 사용합니다.

```java
int left = 0, right = arr.length - 1;
while (left <= right) {
    int mid = (left + right) / 2;
    // 조건 비교 후 left = mid + 1 또는 right = mid - 1
}
```

## 시간 복잡도
| 연산 | 시간 복잡도 |
|------|-----------|
| 이진 탐색 | O(log n) |
| lower_bound | O(log n) |
| upper_bound | O(log n) |
| custom_bound | O(log n) |

## 사용 예시
```bash
javac BinarySearchExample.java
java BinarySearchExample
```
