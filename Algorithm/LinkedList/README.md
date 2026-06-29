# 연결 리스트 (Linked List)

## 개념
연결 리스트는 동적 메모리 할당을 사용하여 데이터를 저장하는 선형 자료구조입니다. 배열과 달리 메모리에 연속적으로 저장되지 않으며, 각 노드는 데이터와 다음 노드를 가리키는 포인터를 포함합니다.

## 파일 설명

### 1. Node.java
- **역할**: 연결 리스트의 기본 단위인 노드를 정의
- **속성**: 
  - `data`: 저장할 데이터
  - `next`: 다음 노드를 가리키는 참조

### 2. LinkedList.java
- **역할**: 연결 리스트의 모든 연산을 구현
- **주요 메서드**:
  - `insertAtBeginning(int data)`: 맨 앞에 노드 추가
  - `insertAtEnd(int data)`: 맨 뒤에 노드 추가
  - `insertAtPosition(int data, int position)`: 특정 위치에 노드 추가
  - `deleteAtBeginning()`: 맨 앞 노드 삭제
  - `deleteAtEnd()`: 맨 뒤 노드 삭제
  - `deleteByValue(int data)`: 특정 값의 노드 삭제
  - `deleteAtPosition(int position)`: 특정 위치의 노드 삭제
  - `search(int data)`: 특정 값 검색
  - `display()`: 리스트 출력
  - `size()`: 리스트 크기 반환
  - `clear()`: 리스트 초기화

### 3. Main.java
- **역할**: LinkedList의 모든 기능을 테스트하는 예제

## 시간 복잡도

| 연산 | 시간 복잡도 |
|------|-----------|
| 삽입 (맨 앞) | O(1) |
| 삽입 (맨 뒤) | O(n) |
| 삽입 (중간) | O(n) |
| 삭제 (맨 앞) | O(1) |
| 삭제 (맨 뒤) | O(n) |
| 삭제 (중간) | O(n) |
| 검색 | O(n) |
| 접근 | O(n) |

## 장점
- 동적 크기 조절 가능
- 삽입/삭제가 배열보다 효율적 (특히 맨 앞)
- 메모리 낭비 없음

## 단점
- 임의 접근 불가능 (O(n) 필요)
- 메모리 오버헤드 (포인터 저장)
- 캐시 효율성 낮음

## 사용 예시
```bash
javac Node.java LinkedList.java Main.java
java Main
```

## 출력 예시
```
=== 연결 리스트 기본 연산 예제 ===

1. 맨 뒤에 추가: 10, 20, 30
LinkedList: 10 -> 20 -> 30 -> null

2. 맨 앞에 추가: 5
LinkedList: 5 -> 10 -> 20 -> 30 -> null

...
```
