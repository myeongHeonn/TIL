# 파라메트릭 서치 (Parametric Search)

## 개념
"어떤 조건을 만족하는 최적의 값을 찾아라"라는 최적화 문제를, "값 x에 대해 조건을 만족하는가?"라는 **판별(decision) 문제**로 바꾸어 이분 탐색으로 푸는 기법입니다.

배열의 원소를 탐색하는 일반적인 이진 탐색과 달리, 탐색 공간은 배열이 아니라 **답이 될 수 있는 값의 범위**(`[left, right]`)이며, 매 단계마다 `mid`가 조건을 만족하는지 판별해 범위를 좁혀나갑니다. 이 저장소의 [BinarySearch/CustomBoundExample.java](../BinarySearch/CustomBoundExample.java)가 이 기법의 범용 템플릿에 해당합니다.

## 적용 조건
condition(x)이 x에 대해 **단조성(monotonicity)**을 가져야 합니다.
- `false...false true...true` 형태 → 조건을 만족하는 **최소값** 탐색
- `true...true false...false` 형태 → 조건을 만족하는 **최대값** 탐색

단조성이 깨져 있으면(조건을 만족/불만족하는 구간이 뒤섞여 있으면) 이분 탐색으로 정답을 보장할 수 없습니다.

## 파일 설명

### TreeCuttingExample.java (BOJ 2805 나무 자르기)
- **문제**: 나무 높이 배열과 필요한 나무 길이 `m`이 주어질 때, 절단기 높이 `h`보다 큰 나무만 `h` 위쪽이 잘려나간다. 잘린 나무 길이의 합이 `m` 이상이 되는 **가장 큰** `h`를 구한다.
- **판별 함수**: `getCutLength(heights, h) >= m` — `h`가 커질수록 얻는 길이는 줄어들므로 `true...true false...false` 형태의 단조성을 가짐
- **탐색 범위**: `[0, max(heights)]`
- **변수**: `left`, `right`, `mid`, `max_h` — 조건을 만족할 때마다 `max_h`에 기록하고 오른쪽 구간을 계속 탐색 (최댓값을 찾으므로 `CustomBoundExample`과 반대 방향)

## 공통 구조
```java
long left = 최소 가능값, right = 최대 가능값;
long answer = 초기값;
while (left <= right) {
    long mid = (left + right) / 2;
    if (condition(mid)) {   // 조건을 만족하면 정답 후보로 기록하고
        answer = mid;
        left = mid + 1;      // 더 큰 값 쪽을 탐색 (최댓값을 찾는 경우)
    } else {
        right = mid - 1;
    }
}
```
조건을 만족하는 **최솟값**을 찾는 문제라면 `left = mid + 1` / `right = mid - 1`의 역할을 서로 바꿔주면 됩니다 (`CustomBoundExample.java` 참고).

## 시간 복잡도
탐색 범위의 크기를 `R`, 판별 함수 1회 호출 비용을 `O(f)`라 하면 전체 시간 복잡도는 `O(f log R)`입니다.

| 문제 | 판별 함수 비용 | 전체 시간 복잡도 |
|------|---------------|-----------------|
| 나무 자르기 | O(n) (나무 개수 순회) | O(n log R) |

## 사용 예시
```bash
javac TreeCuttingExample.java
java TreeCuttingExample
```
