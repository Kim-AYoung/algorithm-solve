# 알고리즘 목차
- [시간 복잡도란?](#시간-복잡도란)
  - [종류](#종류)
  - [계산법](#계산법)
  - [자료구조에서의 시간 복잡도](#자료구조에서의-시간-복잡도)
- [공간 복잡도](#공간-복잡도)
- [코테 푸는 방법](#코테-푸는-방법)
- [코테 Tip!](#코테-Tip!)
- [알고리즘 종류](#알고리즘-종류)
  - [BFS (Breadth First Search)](#BFS-(Breadth-First-Search))
    - [설계](#설계)
    - [시간복잡도](#시간복잡도)
    - [자료구조](#자료구조)
  - [DFS (Depth First Search)](#DFS-(Depth-First-Search))
    - [설계 (재귀함수 이용)](#설계-(재귀함수-이용))
    - [시간복잡도](#시간복잡도)
    - [자료구조](#자료구조)
  - [백트래킹](#백트래킹)
      - [아이디어](#아이디어)
        - [시간복잡도](#시간복잡도)
        - [자료구조](#자료구조)
  - [구현](#구현)
  - [투 포인터](#투-포인터)
    - [종류](#종류)
  - [이진 탐색](#이진-탐색)
    - [핵심 코드](#핵심-코드)
  - [Greedy](#Greedy)
  - [DP (Dynamic Programming)](#DP-(Dynamic-Programming))

# 시간 복잡도란?

: 문제를 해결하는 데 걸리는 시간과 입력의 함수 관계

- 1sec = 1억 번의 연산(100,000,000)
- 알고리즘 선택 기준으로 사용함
    - (주어진 제한 시간을 연산 수로 변환) > O(n), O(nlogn), O(n^2) 등

## 종류

1. 빅-오메가 : 최선일 때의 연산 횟수
2. 빅-세타 : 보통일 때의 연산 횟수
3. 빅-오: 최악일 때의 연산 횟수
    - 코딩 테스트에서 기준으로 둘 시간 복잡도

## 계산법

: 가장 많이 중첩된 반복문의 수행 횟수

- 상수는 제외

## 자료구조에서의 시간 복잡도

- 평균 / 최악

    | 자료구조 | 접근 | 탐색 | 삽입 | 삭제 |
    | --- | --- | --- | --- | --- |
    | 배열 | O(1) | O(n) | O(n) | O(n) |
    | 스택 | O(n) | O(n) | O(1) | O(1) |
    | 큐 | O(n) | O(n) | O(1) | O(1) |
    | 이중 연결 리스트 | O(n) | O(n) | O(1) | O(1) |

# 공간 복잡도

: 프로그램을 실행시켰을 때 필요로 하는 자원 공간의 양

- 정적 변수로 선언된 것 말고도 동적으로 재귀적인 함수로 인해 공간을 계속해서 필요로 할 경우도 포함한다.
- **예시**
    - `int a[1004];` : 1004 * 4 바이트

# 코테 푸는 방법

- 풀기 전에 최대한 구체적인 계획을 세우기
- 다음 세가지를 주석으로 써보고 문제 풀기
    - 아이디어 : 문제를 어떻게 풀것인지 설계
    - 시간복잡도
    - 자료구조

# 코테 Tip!

1. 안전하게 `int` 대신 `long` 을 사용
2. 입력데이터가 많을 때, 성능을 올리는 방법
    - 입력 : `Scanner`→ `BufferedReader`
    - 출력 : `System.out.print` → `BufferedWriter`
    - 문자열 합치기 : `String class의 +` → `StringBuilder`
3. 문제에서 인덱스가 `0`이 아닌 `1`부터 시작한다면, 배열에서도 같은 방식을 따르는게 좋음

# 알고리즘 종류

## BFS (Breadth First Search)

: 그래프를 탐색하는 방법 중 하나로 인접한 노드를 먼저 탐색

- 자료구조 : 큐
- 사용처
    - 두 노드 사이의 최단 경로

### 설계

1. 시작점에 연결된 vertex 찾기
2. 찾은 vertex를 큐에 저장
3. 큐의 가장 앞의 것을 뽑아서 반복

### 시간복잡도

O(V + E)

### 자료구조

- 검색할 그래프 : 2차원 배열
- 방문여부 확인 : 2차원 배열
- BFS를 실행 : Queue

---

## DFS (Depth First Search)

: 그래프를 탐색하는 방법 중 하나로 최대한 깊이 내려간 뒤 더이상 갈 곳이 없을 경우 옆으로 이동

- 자료구조 : 스택, 재귀함수
    - 재귀 함수를 이용하는 것이 가장 보편적이고 짧은 코드를 작성
- 사용처
    - 모든 노드를 방문하고자 하는 경우
    - BFS보다 좀 더 **간단함**
    - 검색 속도 자체는 BFS보다 **느림**

### 설계 (재귀함수 이용)

1. 시작점에 연결된 Vertex 찾기
2. 연결된 Vertex를 계속해서 찾음 (끝날 때까지)
3. 더이상 연결된 Vertex가 없을 경우 1번으로 되돌아감

### 시간복잡도

O(V + E)

### 자료구조

- 검색할 그래프 : 2차원 배열
- 방문여부 확인 : 2차원 배열

---

## 백트래킹

: 순열같이 **모든 경우의 수를 확인**해야할 때

- 매번 깊이가 달라져서 중첩 for문으로는 확인이 불가한 경우
- **재귀함수**를 이용
- N이 작다면 백트래킹 문제일 확률이 높음

### 아이디어

- 1부터 N중에 하나를 선택한다.
- 다음 1부터 N중에 하나를 선택할 때 이미 선택한 값은 제외한다.
- M개를 모두 선택한 경우 M개의 수를 프린트한다.

### 시간복잡도

- 중복 가능 : N^N
    - N ≤ 8
- 중복 불가능 : N!
    - N ≤ 10

### 자료구조

- 값 선택 여부 저장 : bool[]
- 선택한 값 저장 : List<Integer>

---

## 구현

: 각 조건에 맞는 상황을 구현하는 문제

- 지도 or 배열 안에서 이동하면서 탐험하는 문제
- 별도의 알고리즘이 없음 - **주어진 조건을 그대로, 쉽게** 구현
- 매 시험마다 1문제 이상 무조건 출제

---

## 투 포인터

- 각 원소마다 모든 값을 순회해야할 때 ( O(N^2) ), 연속하다는 특성을 이용해서 투 포인터로 움직이면서 처리 ( O(N) )
- 처음부터 생각하기 어려우므로, 쉬운방법부터 생각하고 시간복잡도를 초과한다면, 연속한다는 특징을 활용할 수 있는지 확인

### **종류**

- 포인터의 시작 위치
    - 투 포인터가 왼쪽에서 시작
    - 각각의 포인터가 왼쪽, 오른쪽에서 시작
    - 각각의 포인터가 다른 배열에서 시작
- 일반적인 투포인터 : O(N) **VS** 정렬 후 투포인터 : O(NlogN)

---

## 이진 탐색

: 어떤 값을 찾을 때 **정렬**의 특징을 이용해 빨리 찾음

- 정렬되어있다고 가정했을 때 하나의 값 탐색 시간 : O(N) → O(logN)
- 처음부터 생각하기 어려우므로 쉬운 방법부터 생각
- 입력의 개수가 1e5정도라면 의심

### 핵심 코드

```python
def search(startIndex, endIndex, target):
	if startIndex == endIndex:
		if nums[startIndex] == target:
			# Found Target
		else:
			# Not Found Target

	middleIndex = (startIndex + endIndex) // 2
	if nums[middleIndex] < target:
		search(middleIndex+1, endIndex, target)
	else:
		search(startIndex, middleIndex, target) 
```

---

## Greedy

: 현재 차례의 최선의 답을 찾는 문제

- 어려운 이유
    - 실전 문제에서, 그리디로 푸는 문제임을 생각하기가 어려움
    - 현재 차례의 최선인지 증명하기가 어려움
        - 반례를 통해 증명할 것
- 예시 : 다른 금액의 동전이 여러개 주어졌을 때 M원을 만드는 최소의 개수

---

## DP (Dynamic Programming)

: 이전의 결과를 재활용 하는 알고리즘

- 예시 : 1~10 숫자 중, 각각 이전값들을 합한 값 구하기
- 어떻게 할지 모르겠을 땐, 하나씩 그려보면서 규칙 찾기
- 점화식을 먼저 세우고 코드 짜기

---